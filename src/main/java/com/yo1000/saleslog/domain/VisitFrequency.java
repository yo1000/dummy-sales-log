package com.yo1000.saleslog.domain;

import com.yo1000.saleslog.util.IdHashes;

import java.util.Arrays;

/**
 * 会員の来店頻度。
 * 会員IDを撹拌したハッシュ値で振り分けるため、連続するIDに偏ることはない。
 */
public enum VisitFrequency {
    /** 1ヶ月に1回以上再訪する（全体の5%）。各暦月に必ず1回来店し、加えてランダムにも来店する */
    MONTHLY(5),
    /** 1年に1回以上再訪する（全体の15%）。各暦年に必ず1回来店し、加えてランダムにも来店する */
    YEARLY(15),
    /** 再訪するかどうかはランダム（残り80%）。ランダムな来店のみ */
    IRREGULAR(80),
    ;

    private static final long SALT = 0x7669736974L; // "visit"
    private static final int[] WEIGHTS = Arrays.stream(values()).mapToInt(VisitFrequency::weight).toArray();

    private final int weight;

    VisitFrequency(int weight) {
        this.weight = weight;
    }

    public int weight() {
        return weight;
    }

    /** 会員IDから来店頻度を算出する。同じ会員IDであれば常に同じ頻度になる。 */
    public static VisitFrequency forCustomer(int customerId) {
        return values()[IdHashes.weightedIndex(customerId, SALT, WEIGHTS)];
    }
}
