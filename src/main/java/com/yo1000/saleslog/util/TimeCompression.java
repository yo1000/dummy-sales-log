package com.yo1000.saleslog.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

public class TimeCompression {
    private final LocalDate initialDate;
    private final long initialTime;
    private final long ratio;

    /** 既定の倍率。8,640倍なら実時間5分で30日が経過する */
    public static final long DEFAULT_RATIO = 8_640L;

    public TimeCompression() {
        this(LocalDate.now());
    }

    public TimeCompression(LocalDate initialDate) {
        this(initialDate, DEFAULT_RATIO);
    }

    public TimeCompression(LocalDate initialDate, long ratio) {
        if (ratio <= 0) {
            throw new IllegalArgumentException("ratio must be positive: " + ratio);
        }
        this.initialDate = initialDate;
        this.initialTime = System.currentTimeMillis();
        this.ratio = ratio;
    }

    public long ratio() {
        return ratio;
    }

    public LocalDateTime now() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - initialTime;

        return LocalDateTime.ofEpochSecond(
                initialDate.toEpochSecond(LocalTime.MIN, ZoneOffset.UTC) + (elapsedTime * ratio) / 1000L,
                0,
                ZoneOffset.UTC);
    }
}
