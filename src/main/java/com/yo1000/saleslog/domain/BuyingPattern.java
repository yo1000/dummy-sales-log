package com.yo1000.saleslog.domain;

import com.yo1000.saleslog.util.IdHashes;

import java.util.Arrays;
import java.util.SplittableRandom;
import java.util.random.RandomGenerator;

/**
 * 購買パターン。購入ブランドの組み合わせと購入予算の組で表す。
 * <p>
 * 会員の購買パターンは {@link #forCustomer(int)} で会員IDから機械的に算出され、
 * 同じ会員IDであれば常に同じパターンになる。
 *
 * @param brandCombination 購入ブランドの組み合わせ
 * @param budget           購入予算
 * @param seed             メインブランドの選定などに使う、パターン固有のシード
 */
public record BuyingPattern(
        BrandCombination brandCombination,
        Budget budget,
        long seed
) {
    private static final long SALT_COMBINATION = 0x6272616E64L; // "brand"
    private static final long SALT_BUDGET = 0x627564676574L;    // "budget"
    private static final long SALT_SEED = 0x73656564L;          // "seed"

    /** 購入ブランドの組み合わせ */
    public enum BrandCombination {
        /** 同一ブランド内で購入する（3/10） */
        SINGLE_BRAND(3, 100),
        /** 同一ブランドは高割合・別ブランドは小割合で組み合わせる（5/10） */
        MAIN_BRAND_WITH_OTHERS(5, 80),
        /** 様々なブランドからランダムに購入する（2/10） */
        VARIOUS_BRANDS(2, 0),
        ;

        private final int weight;
        private final int mainBrandPercentage;

        BrandCombination(int weight, int mainBrandPercentage) {
            this.weight = weight;
            this.mainBrandPercentage = mainBrandPercentage;
        }

        public int weight() {
            return weight;
        }

        /** 1商品ごとにメインブランドから選ばれる確率（%） */
        public int mainBrandPercentage() {
            return mainBrandPercentage;
        }
    }

    /** 購入予算（1回の購入あたりの目標金額の範囲） */
    public enum Budget {
        /** 超高額（1/100） */
        SUPER_HIGH(1, 300_000, 2_000_000),
        /** 高額（9/100） */
        HIGH(9, 80_000, 300_000),
        /** 中程度（70/100） */
        MIDDLE(70, 10_000, 80_000),
        /** 安い（20/100） */
        LOW(20, 1_000, 10_000),
        ;

        private final int weight;
        private final int min;
        private final int max;

        Budget(int weight, int min, int max) {
            this.weight = weight;
            this.min = min;
            this.max = max;
        }

        public int weight() {
            return weight;
        }

        public int min() {
            return min;
        }

        public int max() {
            return max;
        }

        /** 予算範囲から目標金額を対数一様に抽選する（範囲内の低い金額ほど出やすい） */
        public int draw(RandomGenerator random) {
            double logMin = Math.log(min);
            double logMax = Math.log(max);
            return (int) Math.round(Math.exp(logMin + random.nextDouble() * (logMax - logMin)));
        }
    }

    private static final int[] COMBINATION_WEIGHTS = Arrays.stream(BrandCombination.values())
            .mapToInt(BrandCombination::weight).toArray();
    private static final int[] BUDGET_WEIGHTS = Arrays.stream(Budget.values())
            .mapToInt(Budget::weight).toArray();

    /**
     * 会員IDから購買パターンを算出する。
     * 組み合わせと予算はそれぞれ独立に、定義した割合で振り分けられる。
     */
    public static BuyingPattern forCustomer(int customerId) {
        return new BuyingPattern(
                BrandCombination.values()[IdHashes.weightedIndex(customerId, SALT_COMBINATION, COMBINATION_WEIGHTS)],
                Budget.values()[IdHashes.weightedIndex(customerId, SALT_BUDGET, BUDGET_WEIGHTS)],
                IdHashes.mix(customerId, SALT_SEED));
    }

    /** 非会員向けに、同じ割合で購買パターンをランダムに抽選する。 */
    public static BuyingPattern random(RandomGenerator random) {
        return forCustomer(random.nextInt()).withSeed(random.nextLong());
    }

    /**
     * このパターンの主に購入するブランドを決定する。
     * 予算内で購入できる商品を持つブランドから、係数を重みとして選ぶ。
     * 同じパターン（シード）であれば常に同じブランドになる。
     */
    public Brand mainBrand(Catalog catalog) {
        return catalog.randomBrand(new SplittableRandom(seed), brandId ->
                catalog.minPrice(brandId) <= budget.max() / 2
                        && catalog.maxPrice(brandId) >= budget.min() / 2);
    }

    private BuyingPattern withSeed(long seed) {
        return new BuyingPattern(brandCombination, budget, seed);
    }
}
