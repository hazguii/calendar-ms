package com.promeet.calendar.infrastructure.persistence;

import com.promeet.calendar.domain.model.CalendarEvent;
import com.promeet.calendar.domain.model.CalendarEventId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarEventJpaRepository extends JpaRepository<CalendarEvent, CalendarEventId> {
}
