package com.yo1000.saleslog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;

@Configuration
@ConfigurationProperties(prefix = "app.data")
public class DataConfigurationProperties {
    private InMemoryProperties inMemory;
    private FileProperties file;

    public InMemoryProperties getInMemory() {
        return inMemory;
    }

    public void setInMemory(InMemoryProperties inMemory) {
        this.inMemory = inMemory;
    }

    public FileProperties getFile() {
        return file;
    }

    public void setFile(FileProperties file) {
        this.file = file;
    }

    public static class InMemoryProperties {
        private boolean enabled;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }

    public static class FileProperties {
        private boolean enabled;
        private Path path;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public Path getPath() {
            return path;
        }

        public void setPath(Path path) {
            this.path = path;
        }
    }
}
