package com.promeet.calendar.domain.ddd;

import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
// L'ID doit implémenter Serializable pour être utilisé comme @EmbeddedId
public abstract class AggregateId<T> implements Serializable {
    protected UUID value;

    public AggregateId(UUID value) {
        this.value = value;
    }

    public AggregateId() {
    }

    public UUID value() {return this.value;}

    // Il est CRUCIAL de surcharger equals et hashCode pour un @EmbeddedId
    @Override
    public boolean equals(Object o) { /* ... */
        return false;
    }
    @Override
    public int hashCode() { /* ... */
        return 0;
    }
}
