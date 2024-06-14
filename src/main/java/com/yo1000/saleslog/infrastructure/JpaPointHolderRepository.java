package com.yo1000.saleslog.infrastructure;

import com.yo1000.saleslog.domain.PointHolder;
import com.yo1000.saleslog.domain.PointHolderRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@ConditionalOnExpression("{'db','rdb','jdbc','jpa'}.contains('${app.data.type}')")
@Repository
public interface JpaPointHolderRepository extends PointHolderRepository, JpaRepository<PointHolder, String> {}
