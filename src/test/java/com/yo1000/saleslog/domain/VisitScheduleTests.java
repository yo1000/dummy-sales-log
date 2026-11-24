package com.yo1000.saleslog.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class VisitScheduleTests {
    private static final int MEMBERS = 500_000;
    private static VisitSchedule schedule;

    @BeforeAll
    static void setUp() {
        schedule = new VisitSchedule(MEMBERS);
    }

    @Test
    void frequencyFollowsDefinedRatio() {
        assertThat((double) schedule.monthlyCustomerCount() / MEMBERS).isCloseTo(0.05, within(0.002));
        assertThat((double) schedule.yearlyCustomerCount() / MEMBERS).isCloseTo(0.15, within(0.003));
    }

    @Test
    void frequencyIsNotBiasedToConsecutiveIds() {
        // 先頭・中間・末尾のどの連続区間でも、全体と同じ割合で分布する
        for (int start : new int[]{1, 250_001, 490_001}) {
            long monthly = IntStream.range(start, start + 10_000)
                    .filter(id -> VisitFrequency.forCustomer(id) == VisitFrequency.MONTHLY).count();
            long yearly = IntStream.range(start, start + 10_000)
                    .filter(id -> VisitFrequency.forCustomer(id) == VisitFrequency.YEARLY).count();
            assertThat(monthly / 10_000.0).isCloseTo(0.05, within(0.01));
            assertThat(yearly / 10_000.0).isCloseTo(0.15, within(0.015));
        }
    }

    @Test
    void monthlyMembersVisitEveryCalendarMonthAndYearlyMembersEveryYear() {
        VisitSchedule small = new VisitSchedule(20_000);
        LocalDateTime start = LocalDateTime.of(1999, 1, 1, 0, 0);
        LocalDateTime end = LocalDateTime.of(2001, 1, 1, 0, 0);

        // 2.4時間（実時間1秒相当）刻みで連続して取得する
        List<VisitSchedule.Visit> visits = new ArrayList<>();
        for (LocalDateTime from = start.minusSeconds(1); from.isBefore(end.minusSeconds(1)); ) {
            LocalDateTime to = from.plusMinutes(144);
            if (to.isAfter(end.minusSeconds(1))) {
                to = end.minusSeconds(1);
            }
            visits.addAll(small.visitsBetween(from, to));
            from = to;
        }

        Map<Integer, List<VisitSchedule.Visit>> byCustomer = visits.stream()
                .collect(Collectors.groupingBy(VisitSchedule.Visit::customerId));

        for (int id = 1; id <= 20_000; id++) {
            VisitFrequency frequency = VisitFrequency.forCustomer(id);
            List<VisitSchedule.Visit> own = byCustomer.getOrDefault(id, List.of());
            switch (frequency) {
                case MONTHLY -> {
                    Set<YearMonth> months = own.stream()
                            .map(v -> YearMonth.from(v.dateTime())).collect(Collectors.toSet());
                    // 月1回の予定に加え、年1回の予定は持たない
                    assertThat(own).hasSize(24);
                    assertThat(months).hasSize(24);
                }
                case YEARLY -> {
                    assertThat(own).hasSize(2);
                    assertThat(own.get(0).dateTime().getYear()).isEqualTo(1999);
                    assertThat(own.get(1).dateTime().getYear()).isEqualTo(2000);
                }
                case IRREGULAR -> assertThat(own).isEmpty();
            }
        }
    }

    @Test
    void consecutiveWindowsReturnSameVisitsAsOneWindow() {
        LocalDateTime from = LocalDateTime.of(1999, 1, 30, 12, 0);
        LocalDateTime to = LocalDateTime.of(1999, 2, 2, 12, 0);

        List<VisitSchedule.Visit> whole = schedule.visitsBetween(from, to);
        List<VisitSchedule.Visit> pieces = new ArrayList<>();
        for (LocalDateTime t = from; t.isBefore(to); t = t.plusMinutes(144)) {
            LocalDateTime next = t.plusMinutes(144).isAfter(to) ? to : t.plusMinutes(144);
            pieces.addAll(schedule.visitsBetween(t, next));
        }

        assertThat(whole).isNotEmpty();
        assertThat(pieces).containsExactlyElementsOf(whole);
        assertThat(whole).allMatch(v -> v.dateTime().isAfter(from) && !v.dateTime().isAfter(to));
    }

    @Test
    void visitDateTimeChangesEveryMonth() {
        LocalDateTime jan = LocalDateTime.of(1999, 1, 1, 0, 0);
        Map<Integer, Integer> janDays = schedule.visitsBetween(jan.minusSeconds(1), jan.plusMonths(1).minusSeconds(1))
                .stream().filter(v -> VisitFrequency.forCustomer(v.customerId()) == VisitFrequency.MONTHLY)
                .collect(Collectors.toMap(VisitSchedule.Visit::customerId, v -> v.dateTime().getDayOfMonth()));
        Map<Integer, Integer> febDays = schedule.visitsBetween(jan.plusMonths(1).minusSeconds(1), jan.plusMonths(2).minusSeconds(1))
                .stream().filter(v -> VisitFrequency.forCustomer(v.customerId()) == VisitFrequency.MONTHLY)
                .collect(Collectors.toMap(VisitSchedule.Visit::customerId, v -> v.dateTime().getDayOfMonth()));

        long sameDay = janDays.entrySet().stream()
                .filter(e -> Objects.equals(febDays.get(e.getKey()), e.getValue())).count();
        assertThat((double) sameDay / janDays.size()).isLessThan(0.1);
    }
}
