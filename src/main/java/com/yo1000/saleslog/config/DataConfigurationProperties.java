package com.yo1000.saleslog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;

@ConfigurationProperties(prefix = "app.data")
public class DataConfigurationProperties {
    private String type;
    private FileProperties file;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FileProperties getFile() {
        return file;
    }

    public void setFile(FileProperties file) {
        this.file = file;
    }

    public static class FileProperties {
        private Path path;

        public Path getPath() {
            return path;
        }

        public void setPath(Path path) {
            this.path = path;
        }
    }
}
