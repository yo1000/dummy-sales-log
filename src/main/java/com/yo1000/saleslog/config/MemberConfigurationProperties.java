package com.yo1000.saleslog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 会員による購入の設定。
 * 会員IDは 1〜{@code maxId} の範囲からランダムに選ばれる。
 */
@ConfigurationProperties(prefix = "app.member")
public class MemberConfigurationProperties {
    /** 会員IDの最大値 */
    private int maxId = 500_000;
    /** 1秒あたりの会員による購入件数 */
    private int purchasesPerSec = 3;
    /** 会員の購入を処理するスレッド数。同じ会員の購入は同じスレッドで直列に処理される */
    private int threads = 16;

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public int getPurchasesPerSec() {
        return purchasesPerSec;
    }

    public void setPurchasesPerSec(int purchasesPerSec) {
        this.purchasesPerSec = purchasesPerSec;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }
}
