package com.promeet.calendar.domain.ddd;

import com.promeet.calendar.domain.model.Timestamp;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class DomainEvent<T> {
    public T id;
    public Timestamp occurredOn;

    protected DomainEvent() {
    }
}
