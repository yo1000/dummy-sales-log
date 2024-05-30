package com.yo1000.saleslog.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class TimeCompression {
    private final long initialTime;
    private final long ratio;

    public TimeCompression() {
        initialTime = System.currentTimeMillis();
        // If time flows at 8,640x speed, 30 days pass in 5 minutes.
        ratio = 8_640L;
    }

    public LocalDateTime now() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - initialTime;

        return LocalDateTime.ofEpochSecond(
                (initialTime + elapsedTime * ratio) / 1000L, 0,
                ZoneOffset.UTC);
    }
}
