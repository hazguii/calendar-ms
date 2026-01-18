package com.promeet.calendar.domain.model;

import com.promeet.calendar.domain.ddd.ValueObject;
import jakarta.persistence.Embeddable;

@Embeddable
public class CalendarEventTitle extends ValueObject<String> {

    public CalendarEventTitle(){
        super();
    }
    public CalendarEventTitle(String value) {
        super(value);
    }
}
