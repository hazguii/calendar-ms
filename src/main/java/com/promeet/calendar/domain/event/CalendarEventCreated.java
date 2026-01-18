package com.promeet.calendar.domain.event;

import com.promeet.calendar.domain.ddd.DomainEvent;
import com.promeet.calendar.domain.model.CalendarEventId;
import com.promeet.calendar.domain.model.CalendarEventTitle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CalendarEventCreated extends DomainEvent<CalendarEventId> {
    public CalendarEventTitle eventTitle;
}
