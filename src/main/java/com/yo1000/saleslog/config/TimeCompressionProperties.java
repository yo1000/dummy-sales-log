package com.yo1000.saleslog.config;

import com.yo1000.saleslog.util.TimeCompression;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.LocalDate;

/**
 * 時間圧縮の設定。
 *
 * @param initialDate 購入日時の起点となる日付
 * @param ratio       時間の進む速さ（実時間に対する倍率）。既定は 8,640 倍（実時間1秒 = 2.4時間、5分で30日）。
 *                    1 を指定すると実時間と同じ速さで進む
 */
@ConfigurationProperties(prefix = "app.time-compression")
public record TimeCompressionProperties(
        LocalDate initialDate,
        Long ratio
) {
    public TimeCompressionProperties {
        if (ratio == null) {
            ratio = TimeCompression.DEFAULT_RATIO;
        }
        if (ratio <= 0) {
            throw new IllegalArgumentException("app.time-compression.ratio must be positive: " + ratio);
        }
    }
}
