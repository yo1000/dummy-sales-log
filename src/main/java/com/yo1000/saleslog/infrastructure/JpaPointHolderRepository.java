package com.yo1000.saleslog.infrastructure;

import com.yo1000.saleslog.domain.PointHolder;
import com.yo1000.saleslog.domain.PointHolderRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DB に保有ポイントを保存するリポジトリ。
 * {@code db} 系は外部の DB（spring.datasource.*）、{@code h2} 系は組み込みの H2（メモリモード）を使う。
 */
@ConditionalOnExpression("{'db','rdb','jdbc','jpa','h2','embedded'}.contains('${app.data.type}')")
@Repository
public interface JpaPointHolderRepository extends PointHolderRepository, JpaRepository<PointHolder, String> {}
