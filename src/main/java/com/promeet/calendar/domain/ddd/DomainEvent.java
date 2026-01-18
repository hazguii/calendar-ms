package com.promeet.calendar.domain.ddd;

import com.promeet.calendar.domain.model.Timestamp;

import java.util.UUID;

public abstract class DomainEvent {
    private UUID id;
    private Timestamp occurredOn;
}
