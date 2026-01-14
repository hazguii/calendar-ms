package com.promeet.calendar.domain.model;

import com.promeet.calendar.domain.ddd.AggregateRoot;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CalendarEvent extends AggregateRoot {

    private CalendarEventId id;
    private CalendarEventOwner owner;

    CalendarEvent(UUID id){
        super(id);
    }
}
