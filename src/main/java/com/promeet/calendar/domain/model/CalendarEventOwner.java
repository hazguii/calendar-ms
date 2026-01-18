package com.promeet.calendar.domain.model;

import com.promeet.calendar.domain.ddd.Entity;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class CalendarEventOwner extends Entity {

    public CalendarEventOwner(){
        super();
    }
    public CalendarEventOwner(UUID id){
        super(id);
    }

}
