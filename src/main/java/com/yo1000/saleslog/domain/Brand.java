package com.yo1000.saleslog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ブランド。
 *
 * @param id         ブランドID
 * @param name       ブランド名
 * @param popularity 人気スコア（50〜200）。ブランド選択時の重みとして使用する（購買ログには出力しない）
 */
public record Brand(
        int id,
        String name,
        @JsonIgnore
        int popularity
) {}
