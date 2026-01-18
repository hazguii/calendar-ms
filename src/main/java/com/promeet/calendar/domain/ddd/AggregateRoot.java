package com.promeet.calendar.domain.ddd;

import java.util.UUID;

public abstract class AggregateRoot {
    protected UUID id;

    protected AggregateRoot(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        this.id = id;
    }


    public UUID id(){ return id;}

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AggregateRoot that = (AggregateRoot) o;
        return id.equals(that.id);
    }

    @Override
    public final int hashCode() {
        return id.hashCode();
    }
}
