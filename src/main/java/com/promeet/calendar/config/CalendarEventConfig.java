package com.promeet.calendar.config;

import com.promeet.calendar.application.handlers.CreateCalendarEventHandler;
import com.promeet.calendar.domain.model.CalendarEventRepository;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class CalendarEventConfig {

    @Bean
    public CreateCalendarEventHandler createCalendarEventHandler(CalendarEventRepository repo){
        return new CreateCalendarEventHandler(repo);
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/changelog/db.changelog-master.xml");
        liquibase.setDataSource(dataSource);
        liquibase.setShouldRun(true);
        return liquibase;
    }
}
