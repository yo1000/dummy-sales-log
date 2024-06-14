package com.yo1000.saleslog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.thread")
public class ThreadConfigurationProperties {
    private int noisesPerSec;

    public int getNoisesPerSec() {
        return noisesPerSec;
    }

    public void setNoisesPerSec(int noisesPerSec) {
        this.noisesPerSec = noisesPerSec;
    }
}
