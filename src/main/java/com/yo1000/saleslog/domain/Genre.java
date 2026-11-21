package com.yo1000.saleslog.domain;

/**
 * 商品ジャンル。
 *
 * @param id   ジャンルID
 * @param name ジャンル名
 */
public record Genre(
        int id,
        String name
) {}
