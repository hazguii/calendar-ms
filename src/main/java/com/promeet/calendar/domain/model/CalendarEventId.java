package com.promeet.calendar.domain.model;

import com.promeet.calendar.domain.ddd.AggregateId;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class CalendarEventId extends AggregateId<CalendarEvent> {
    public CalendarEventId() {
        super();
    }

    public CalendarEventId(UUID value) {
        super(value);
    }
}
