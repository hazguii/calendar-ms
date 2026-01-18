package com.promeet.calendar.infrastructure.persistence;

import com.promeet.calendar.domain.model.CalendarEvent;
import com.promeet.calendar.domain.model.CalendarEventId;
import com.promeet.calendar.domain.model.CalendarEventRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public class PostgresqlCalendarEventRepositoryImpl implements CalendarEventRepository {

    private final CalendarEventJpaRepository jpaRepository;

    PostgresqlCalendarEventRepositoryImpl(CalendarEventJpaRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }
    @Override
    public void save(CalendarEvent event) {
        this.jpaRepository.save(event);
    }

    @Override
    public Optional<CalendarEvent> lookup(CalendarEventId id) {
        return Optional.empty();
    }
}
