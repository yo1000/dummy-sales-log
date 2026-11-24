package com.yo1000.saleslog.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DataConfigurationProperties.class)
public class DataConfiguration {
    @Bean
    @ConditionalOnExpression("{'db','rdb','jdbc','jpa'}.contains('${app.data.type}')")
    public DataSource dataSource(DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    /**
     * 外部の DB を使わない場合の DataSource。組み込みの H2 をメモリモードで起動する。
     * {@code h2} 系では保有ポイントの保存先になり、spring.datasource.* の設定は使わない。
     */
    @Bean
    @ConditionalOnMissingBean(DataSource.class)
    public DataSource inMemoryDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .generateUniqueName(true)
                .build();
    }
}
