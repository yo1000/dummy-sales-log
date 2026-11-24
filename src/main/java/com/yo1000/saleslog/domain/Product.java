package com.yo1000.saleslog.domain;

/**
 * 商品（商品名 x カラー・パターン 単位）。
 *
 * @param id      商品ID
 * @param brandId ブランドID
 * @param genreId ジャンルID
 * @param name    商品名
 * @param color   カラー・パターン（展開がない場合は空文字）
 * @param price   価格
 */
public record Product(
        int id,
        int brandId,
        int genreId,
        String name,
        String color,
        int price
) {}
