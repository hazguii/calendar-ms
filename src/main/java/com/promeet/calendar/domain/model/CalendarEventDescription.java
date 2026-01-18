package com.promeet.calendar.domain.model;

import com.promeet.calendar.domain.ddd.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class CalendarEventDescription extends ValueObject<String> {

    public CalendarEventDescription(){}
    public CalendarEventDescription(String value) {
        super(value);
    }
}
