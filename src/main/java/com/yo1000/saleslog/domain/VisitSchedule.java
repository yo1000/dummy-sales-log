package com.yo1000.saleslog.domain;

import com.yo1000.saleslog.util.IdHashes;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 定期的に再訪する会員の来店予定。
 * <ul>
 *     <li>{@link VisitFrequency#MONTHLY}: 各暦月に1回、月内のどこかで来店する</li>
 *     <li>{@link VisitFrequency#YEARLY}: 各暦年に1回、年内のどこかで来店する</li>
 * </ul>
 * 来店日時は会員IDと期間（年月・年）から機械的に算出されるため、状態を持たずに再現できる。
 * 期間ごとに日時が変わるので、毎回同じ日時に来店することはない。
 */
public class VisitSchedule {
    private static final long SALT_MONTH = 0x6D6F6E7468L; // "month"
    private static final long SALT_YEAR = 0x79656172L;    // "year"
    private static final int CACHE_SIZE = 4;

    /** 来店予定 */
    public record Visit(int customerId, LocalDateTime dateTime) {}

    private final int[] monthlyCustomerIds;
    private final int[] yearlyCustomerIds;

    private final Map<YearMonth, long[]> monthlyCache = lruCache();
    private final Map<Year, long[]> yearlyCache = lruCache();

    public VisitSchedule(int maxCustomerId) {
        this.monthlyCustomerIds = customerIds(maxCustomerId, VisitFrequency.MONTHLY);
        this.yearlyCustomerIds = customerIds(maxCustomerId, VisitFrequency.YEARLY);
    }

    public int monthlyCustomerCount() {
        return monthlyCustomerIds.length;
    }

    public int yearlyCustomerCount() {
        return yearlyCustomerIds.length;
    }

    /**
     * {@code from} より後、{@code to} 以前（from, to]に予定されている来店を日時順に返す。
     * 連続する区間で呼び出せば、来店予定は重複も漏れもなく1回ずつ返される。
     */
    public synchronized List<Visit> visitsBetween(LocalDateTime from, LocalDateTime to) {
        List<Visit> visits = new ArrayList<>();
        if (!to.isAfter(from)) {
            return visits;
        }
        long fromSec = from.toEpochSecond(ZoneOffset.UTC);
        long toSec = to.toEpochSecond(ZoneOffset.UTC);

        for (YearMonth ym = YearMonth.from(from); !ym.isAfter(YearMonth.from(to)); ym = ym.plusMonths(1)) {
            long start = ym.atDay(1).atStartOfDay().toEpochSecond(ZoneOffset.UTC);
            collect(monthlyCache.computeIfAbsent(ym, this::monthlyPlan), start, fromSec, toSec, visits);
        }
        for (Year y = Year.from(from); !y.isAfter(Year.from(to)); y = y.plusYears(1)) {
            long start = y.atDay(1).atStartOfDay().toEpochSecond(ZoneOffset.UTC);
            collect(yearlyCache.computeIfAbsent(y, this::yearlyPlan), start, fromSec, toSec, visits);
        }

        visits.sort((a, b) -> a.dateTime().compareTo(b.dateTime()));
        return visits;
    }

    private long[] monthlyPlan(YearMonth ym) {
        long seconds = ym.lengthOfMonth() * 86_400L;
        return plan(monthlyCustomerIds, seconds, SALT_MONTH ^ (ym.getYear() * 12L + ym.getMonthValue()));
    }

    private long[] yearlyPlan(Year y) {
        long seconds = y.length() * 86_400L;
        return plan(yearlyCustomerIds, seconds, SALT_YEAR ^ y.getValue());
    }

    /**
     * 期間内の来店予定を作る。要素は「期間開始からの経過秒 << 32 | 会員ID」で、昇順に並ぶ。
     */
    private static long[] plan(int[] customerIds, long periodSeconds, long salt) {
        long[] plan = new long[customerIds.length];
        for (int i = 0; i < customerIds.length; i++) {
            long offset = Long.remainderUnsigned(IdHashes.mix(customerIds[i], salt), periodSeconds);
            plan[i] = (offset << 32) | customerIds[i];
        }
        Arrays.sort(plan);
        return plan;
    }

    private static void collect(long[] plan, long periodStart, long fromSec, long toSec, List<Visit> visits) {
        // (fromSec, toSec] に入る経過秒の範囲を二分探索で求める
        long lowOffset = fromSec - periodStart + 1;
        long highOffset = toSec - periodStart;
        if (highOffset < 0) {
            return;
        }
        int index = lowerBound(plan, Math.max(lowOffset, 0) << 32);
        for (; index < plan.length; index++) {
            long offset = plan[index] >>> 32;
            if (offset > highOffset) {
                break;
            }
            visits.add(new Visit(
                    (int) plan[index],
                    LocalDateTime.ofEpochSecond(periodStart + offset, 0, ZoneOffset.UTC)));
        }
    }

    private static int lowerBound(long[] sorted, long value) {
        int low = 0;
        int high = sorted.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (sorted[mid] < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int[] customerIds(int maxCustomerId, VisitFrequency frequency) {
        return IntStream.rangeClosed(1, maxCustomerId)
                .filter(id -> VisitFrequency.forCustomer(id) == frequency)
                .toArray();
    }

    private static <K, V> Map<K, V> lruCache() {
        return new LinkedHashMap<>(CACHE_SIZE, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > CACHE_SIZE;
            }
        };
    }
}
