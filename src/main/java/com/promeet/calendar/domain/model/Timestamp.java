package com.promeet.calendar.domain.model;

import com.promeet.calendar.domain.ddd.ValueObject;
import jakarta.persistence.Embeddable;

import java.util.Date;

@Embeddable
public class Timestamp extends ValueObject<Date> implements Comparable<Timestamp>{

    public Timestamp(){super(new Date());}
    public Timestamp(Date value) {
        super(value);
    }

    @Override
    public int compareTo(Timestamp o) {
        if(this.value.equals(o.value)) return 0;
        else if (this.value.after(o.value)) return -1;
        return 1;
    }
}
