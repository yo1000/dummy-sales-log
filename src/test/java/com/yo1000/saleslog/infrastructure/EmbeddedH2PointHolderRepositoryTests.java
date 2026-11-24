package com.yo1000.saleslog.infrastructure;

import com.yo1000.saleslog.domain.Customer;
import com.yo1000.saleslog.domain.PointHolder;
import com.yo1000.saleslog.domain.PointHolderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * app.data.type=h2 では、外部の DB を用意しなくても組み込みの H2（メモリモード）に保有ポイントを保存できる。
 * spring.datasource.url に外部 DB の URL が残っていても使われないことも確かめる。
 */
@SpringBootTest(properties = {
        "app.data.type=h2",
        "spring.datasource.url=jdbc:postgresql://unreachable:5432/saleslog",
        "app.member.purchases-per-sec=0"
})
class EmbeddedH2PointHolderRepositoryTests {
    @Autowired
    PointHolderRepository repository;

    @Autowired
    DataSource dataSource;

    @Test
    void usesEmbeddedInMemoryH2() throws Exception {
        // Given / When
        String url;
        try (Connection connection = dataSource.getConnection()) {
            url = connection.getMetaData().getURL();
        }

        // Then
        Assertions.assertThat(url).startsWith("jdbc:h2:mem:");
        Assertions.assertThat(repository).isInstanceOf(JpaPointHolderRepository.class);
    }

    @Test
    void savesAndFindsPointHolder() {
        // Given
        PointHolder pointHolder = new PointHolder(new Customer(264589), 0);
        pointHolder.setPoint(1375);

        // When
        repository.save(pointHolder);
        PointHolder found = repository.findByCustomerId(264589);

        // Then
        Assertions.assertThat(found).isNotNull();
        Assertions.assertThat(found.getPoint()).isEqualTo(1375);
    }
}
