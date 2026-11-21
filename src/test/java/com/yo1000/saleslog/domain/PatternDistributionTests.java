package com.yo1000.saleslog.domain;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

class PatternDistributionTests {
    private static final int MEMBERS = 500_000;

    @Test
    void buyingPatternIsDeterministicByCustomerId() {
        for (int id = 1; id <= 1_000; id++) {
            assertThat(BuyingPattern.forCustomer(id)).isEqualTo(BuyingPattern.forCustomer(id));
        }
    }

    @Test
    void brandCombinationFollowsDefinedRatio() {
        Map<BuyingPattern.BrandCombination, Integer> counts = new EnumMap<>(BuyingPattern.BrandCombination.class);
        for (int id = 1; id <= MEMBERS; id++) {
            counts.merge(BuyingPattern.forCustomer(id).brandCombination(), 1, Integer::sum);
        }
        assertRatio(counts.get(BuyingPattern.BrandCombination.SINGLE_BRAND), 3.0 / 10);
        assertRatio(counts.get(BuyingPattern.BrandCombination.MAIN_BRAND_WITH_OTHERS), 5.0 / 10);
        assertRatio(counts.get(BuyingPattern.BrandCombination.VARIOUS_BRANDS), 2.0 / 10);
    }

    @Test
    void budgetFollowsDefinedRatio() {
        Map<BuyingPattern.Budget, Integer> counts = new EnumMap<>(BuyingPattern.Budget.class);
        for (int id = 1; id <= MEMBERS; id++) {
            counts.merge(BuyingPattern.forCustomer(id).budget(), 1, Integer::sum);
        }
        assertRatio(counts.get(BuyingPattern.Budget.SUPER_HIGH), 1.0 / 100);
        assertRatio(counts.get(BuyingPattern.Budget.HIGH), 9.0 / 100);
        assertRatio(counts.get(BuyingPattern.Budget.MIDDLE), 70.0 / 100);
        assertRatio(counts.get(BuyingPattern.Budget.LOW), 20.0 / 100);
    }

    @Test
    void pointBehaviorFollowsDefinedRatio() {
        Map<PointBehaviors, Integer> counts = new EnumMap<>(PointBehaviors.class);
        for (int id = 1; id <= MEMBERS; id++) {
            assertThat(PointBehaviorPattern.forCustomer(id)).isEqualTo(PointBehaviorPattern.forCustomer(id));
            counts.merge(PointBehaviorPattern.forCustomer(id), 1, Integer::sum);
        }
        assertRatio(counts.get(PointBehaviors.NOT_USE), 1.0 / 50);
        assertRatio(counts.get(PointBehaviors.RANDOM), 20.0 / 50);
        assertRatio(counts.get(PointBehaviors.FULL_PAYMENT_ONLY), 20.0 / 50);
        assertRatio(counts.get(PointBehaviors.EXPENSIVE_PAYMENT_ONLY), 3.0 / 50);
        assertRatio(counts.get(PointBehaviors.FRACTIONS_ONLY), 6.0 / 50);
    }

    private static void assertRatio(Integer count, double expected) {
        assertThat(count).isNotNull();
        assertThat((double) count / MEMBERS).isCloseTo(expected, within(0.005));
    }
}
