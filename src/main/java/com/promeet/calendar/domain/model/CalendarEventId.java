package com.promeet.calendar.domain.model;

import com.promeet.calendar.domain.ddd.ValueObject;

import java.util.UUID;

public class CalendarEventId extends ValueObject<UUID> {

    CalendarEventId(UUID id){super(id);}

}
