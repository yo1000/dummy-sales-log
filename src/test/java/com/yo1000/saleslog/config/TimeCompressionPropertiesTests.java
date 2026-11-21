package com.yo1000.saleslog.config;

import com.yo1000.saleslog.util.TimeCompression;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TimeCompressionPropertiesTests {
    @Test
    void ratioDefaultsToCurrentValue() {
        TimeCompressionProperties props = bind(Map.of("app.time-compression.initial-date", "1999-02-11"));
        assertThat(props.initialDate()).isEqualTo(LocalDate.of(1999, 2, 11));
        assertThat(props.ratio()).isEqualTo(8_640L);
    }

    @Test
    void ratioCanBeChanged() {
        TimeCompressionProperties props = bind(Map.of(
                "app.time-compression.initial-date", "1999-02-11",
                "app.time-compression.ratio", "24"));
        assertThat(props.ratio()).isEqualTo(24L);
    }

    @Test
    void ratioMustBePositive() {
        assertThatThrownBy(() -> new TimeCompressionProperties(LocalDate.of(1999, 2, 11), 0L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void timeAdvancesByRatio() throws InterruptedException {
        LocalDate initialDate = LocalDate.of(1999, 2, 11);
        TimeCompression realTime = new TimeCompression(initialDate, 1);
        TimeCompression fast = new TimeCompression(initialDate, 3_600);

        Thread.sleep(1_100);

        LocalDateTime start = initialDate.atStartOfDay();
        assertThat(Duration.between(start, realTime.now()).getSeconds()).isBetween(1L, 3L);
        // 3,600倍なら実時間1秒で1時間進む
        assertThat(Duration.between(start, fast.now()).toMinutes()).isBetween(60L, 180L);
    }

    private static TimeCompressionProperties bind(Map<String, String> source) {
        return new Binder(new MapConfigurationPropertySource(source))
                .bind("app.time-compression", TimeCompressionProperties.class)
                .get();
    }
}
