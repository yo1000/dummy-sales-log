package com.yo1000.saleslog.util;

/**
 * ID から決定的（同じIDなら常に同じ値）かつ一様に分散した値を算出するユーティリティ。
 */
public final class IdHashes {
    private IdHashes() {}

    /**
     * SplitMix64 の最終化関数で ID と salt を撹拌する。
     * 連番のIDでも偏りのない64bit値になる。
     */
    public static long mix(long id, long salt) {
        long z = id * 0x9E3779B97F4A7C15L + salt;
        z = (z ^ (z >>> 30)) * 0xBF58476D1CE4E5B9L;
        z = (z ^ (z >>> 27)) * 0x94D049BB133111EBL;
        return z ^ (z >>> 31);
    }

    /**
     * ID を重み付きのバケットに振り分け、そのインデックスを返す。
     *
     * @param weights 各バケットの重み（例: {3, 5, 2} なら 3/10, 5/10, 2/10）
     */
    public static int weightedIndex(long id, long salt, int[] weights) {
        int total = 0;
        for (int weight : weights) {
            total += weight;
        }
        long point = Long.remainderUnsigned(mix(id, salt), total);
        for (int i = 0; i < weights.length; i++) {
            point -= weights[i];
            if (point < 0) {
                return i;
            }
        }
        return weights.length - 1;
    }
}
