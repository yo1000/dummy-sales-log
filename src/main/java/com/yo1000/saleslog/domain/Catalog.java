package com.yo1000.saleslog.domain;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.random.RandomGenerator;

/**
 * ブランド・ジャンル・商品のカタログ。
 * 生成後は不変で、スレッドセーフに参照できる。
 */
public class Catalog {
    private final List<Brand> brands;
    private final Map<Integer, Brand> brandsById;
    private final Map<Integer, Genre> genresById;
    /** ブランドID → 価格昇順の商品配列 */
    private final Map<Integer, Product[]> productsByBrand;
    /** ブランドID → 価格昇順の価格配列（二分探索用） */
    private final Map<Integer, int[]> pricesByBrand;

    public Catalog(Collection<Brand> brands, Collection<Genre> genres, Collection<Product> products) {
        Map<Integer, List<Product>> grouped = new HashMap<>();
        for (Product product : products) {
            grouped.computeIfAbsent(product.brandId(), k -> new ArrayList<>()).add(product);
        }

        Map<Integer, Product[]> productsByBrand = new HashMap<>();
        Map<Integer, int[]> pricesByBrand = new HashMap<>();
        grouped.forEach((brandId, list) -> {
            Product[] sorted = list.stream()
                    .sorted(Comparator.comparingInt(Product::price).thenComparingInt(Product::id))
                    .toArray(Product[]::new);
            productsByBrand.put(brandId, sorted);
            pricesByBrand.put(brandId, Arrays.stream(sorted).mapToInt(Product::price).toArray());
        });

        // 商品を持たないブランドは購入対象にできないため除外する
        this.brands = brands.stream()
                .filter(brand -> productsByBrand.containsKey(brand.id()))
                .sorted(Comparator.comparingInt(Brand::id))
                .toList();
        if (this.brands.isEmpty()) {
            throw new IllegalArgumentException("Catalog requires at least one brand with products");
        }

        Map<Integer, Brand> brandsById = new HashMap<>();
        this.brands.forEach(brand -> brandsById.put(brand.id(), brand));
        Map<Integer, Genre> genresById = new HashMap<>();
        genres.forEach(genre -> genresById.put(genre.id(), genre));

        this.brandsById = Collections.unmodifiableMap(brandsById);
        this.genresById = Collections.unmodifiableMap(genresById);
        this.productsByBrand = Collections.unmodifiableMap(productsByBrand);
        this.pricesByBrand = Collections.unmodifiableMap(pricesByBrand);
    }

    public List<Brand> brands() {
        return brands;
    }

    public Brand brand(int brandId) {
        return brandsById.get(brandId);
    }

    public Genre genre(int genreId) {
        return genresById.get(genreId);
    }

    public int productCount() {
        return productsByBrand.values().stream().mapToInt(products -> products.length).sum();
    }

    /** ブランド内の最安価格 */
    public int minPrice(int brandId) {
        return pricesByBrand.get(brandId)[0];
    }

    /** ブランド内の最高価格 */
    public int maxPrice(int brandId) {
        int[] prices = pricesByBrand.get(brandId);
        return prices[prices.length - 1];
    }

    /** ブランド内の最安商品 */
    public Product cheapestProduct(int brandId) {
        return productsByBrand.get(brandId)[0];
    }

    /**
     * ブランド内で {@code maxPrice} 以下の商品を一様ランダムに1つ選ぶ。
     *
     * @return 該当商品がなければ {@code null}
     */
    public Product randomProduct(int brandId, int maxPrice, RandomGenerator random) {
        int[] prices = pricesByBrand.get(brandId);
        int upper = upperBound(prices, maxPrice);
        if (upper <= 0) {
            return null;
        }
        return productsByBrand.get(brandId)[random.nextInt(upper)];
    }

    /**
     * 人気スコアを重みとしてブランドを1つ選ぶ。
     *
     * @param filter 対象とするブランドIDの条件。該当がなければ全ブランドから選ぶ
     */
    public Brand randomBrand(RandomGenerator random, IntPredicate filter) {
        List<Brand> candidates = brands.stream()
                .filter(brand -> filter.test(brand.id()))
                .toList();
        if (candidates.isEmpty()) {
            candidates = brands;
        }

        long totalWeight = candidates.stream().mapToLong(Brand::popularity).sum();
        long point = random.nextLong(totalWeight);
        for (Brand candidate : candidates) {
            point -= candidate.popularity();
            if (point < 0) {
                return candidate;
            }
        }
        return candidates.getLast();
    }

    /** {@code value} 以下となる要素数（= 最初に value を超える位置） */
    private static int upperBound(int[] sorted, int value) {
        int low = 0;
        int high = sorted.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (sorted[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
