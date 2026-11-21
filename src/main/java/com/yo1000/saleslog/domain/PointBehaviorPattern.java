package com.yo1000.saleslog.domain;

import com.yo1000.saleslog.util.IdHashes;

/**
 * ポイント行使パターン。
 * 会員IDから {@link PointBehaviors} を機械的に算出する。同じ会員IDであれば常に同じパターンになる。
 * <ul>
 *     <li>{@link PointBehaviors#NOT_USE}: 1/50</li>
 *     <li>{@link PointBehaviors#RANDOM}: 20/50</li>
 *     <li>{@link PointBehaviors#FULL_PAYMENT_ONLY}: 20/50</li>
 *     <li>{@link PointBehaviors#EXPENSIVE_PAYMENT_ONLY}: 3/50</li>
 *     <li>{@link PointBehaviors#FRACTIONS_ONLY}: 6/50</li>
 * </ul>
 */
public final class PointBehaviorPattern {
    private static final long SALT = 0x706F696E74L; // "point"

    private static final PointBehaviors[] BEHAVIORS = {
            PointBehaviors.NOT_USE,
            PointBehaviors.RANDOM,
            PointBehaviors.FULL_PAYMENT_ONLY,
            PointBehaviors.EXPENSIVE_PAYMENT_ONLY,
            PointBehaviors.FRACTIONS_ONLY,
    };
    private static final int[] WEIGHTS = {1, 20, 20, 3, 6};

    private PointBehaviorPattern() {}

    /** 会員IDからポイント行使パターンを算出する。 */
    public static PointBehaviors forCustomer(int customerId) {
        return BEHAVIORS[IdHashes.weightedIndex(customerId, SALT, WEIGHTS)];
    }
}
