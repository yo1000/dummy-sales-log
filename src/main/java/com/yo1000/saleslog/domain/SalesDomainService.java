package com.yo1000.saleslog.domain;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;

@Service
public class SalesDomainService {
    /** 1回の購入で選ぶ商品の最大点数 */
    static final int MAX_PICKS = 12;
    /** 目標金額に対してこの割合に達したら購入を終える */
    static final double SATISFIED_RATIO = 0.8;
    /** 安価な商品を2点まとめ買いする確率（%）と、その対象となる価格の上限 */
    static final int MULTI_QUANTITY_PERCENTAGE = 15;
    static final int MULTI_QUANTITY_PRICE_LIMIT = 5_000;

    private final Catalog catalog;

    public SalesDomainService(Catalog catalog) {
        this.catalog = catalog;
    }

    /**
     * 購買パターンに従って商品を選び、購入（ポイント適用前）を作成する。
     *
     * @param customer 会員。非会員の場合は {@code null}
     */
    public Sales sell(Customer customer, BuyingPattern pattern, LocalDateTime dateTime) {
        List<SalesItem> items = pick(pattern, ThreadLocalRandom.current());
        int total = items.stream().mapToInt(SalesItem::subtotal).sum();

        return new Sales(
                UUID.randomUUID().toString(),
                dateTime,
                0,
                0,
                total,
                items,
                customer
        );
    }

    List<SalesItem> pick(BuyingPattern pattern, RandomGenerator random) {
        int target = pattern.budget().draw(random);
        int mainBrandId = pattern.mainBrand(catalog).id();

        Map<Integer, SalesItem> picked = new LinkedHashMap<>();
        int total = 0;

        for (int i = 0; i < MAX_PICKS && total < target * SATISFIED_RATIO; i++) {
            int brandId = chooseBrand(pattern.brandCombination(), mainBrandId, random);
            int remaining = target - total;

            Product product = catalog.randomProduct(brandId, remaining, random);
            if (product == null) {
                if (!picked.isEmpty()) {
                    continue; // このブランドには予算内の商品がない。別の商品を探す
                }
                // 1点目が見つからない場合はメインブランド（予算に合うよう選定済み）から選び、
                // それでもなければメインブランドの最安商品を予算超過でも1点買う
                product = catalog.randomProduct(mainBrandId, remaining, random);
                if (product == null) {
                    product = catalog.cheapestProduct(mainBrandId);
                }
            }

            int quantity = product.price() <= MULTI_QUANTITY_PRICE_LIMIT
                    && product.price() * 2 <= remaining
                    && random.nextInt(100) < MULTI_QUANTITY_PERCENTAGE
                    ? 2 : 1;

            SalesItem current = picked.get(product.id());
            picked.put(product.id(), SalesItem.of(product,
                    catalog.brand(product.brandId()),
                    catalog.genre(product.genreId()),
                    (current != null ? current.quantity() : 0) + quantity));
            total += product.price() * quantity;
        }

        return new ArrayList<>(picked.values());
    }

    private int chooseBrand(BuyingPattern.BrandCombination combination, int mainBrandId, RandomGenerator random) {
        if (random.nextInt(100) < combination.mainBrandPercentage()) {
            return mainBrandId;
        }
        return catalog.randomBrand(random, brandId -> brandId != mainBrandId).id();
    }
}
