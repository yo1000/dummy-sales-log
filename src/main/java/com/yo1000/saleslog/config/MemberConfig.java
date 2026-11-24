package com.yo1000.saleslog.config;

import com.yo1000.saleslog.domain.VisitSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberConfig {
    private final Logger logger = LoggerFactory.getLogger(MemberConfig.class);

    @Bean
    public VisitSchedule visitSchedule(MemberConfigurationProperties props) {
        VisitSchedule schedule = new VisitSchedule(props.getMaxId());
        logger.info("Visit schedule: {} monthly members, {} yearly members (of {})",
                schedule.monthlyCustomerCount(), schedule.yearlyCustomerCount(), props.getMaxId());
        return schedule;
    }
}
