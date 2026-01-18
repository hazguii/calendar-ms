package com.promeet.calendar.domain.ddd;

import jakarta.persistence.MappedSuperclass;
import lombok.ToString;

@MappedSuperclass // Même si tes objets sont des @Embeddable, Hibernate a besoin de savoir que la classe parente ValueObject contient des informations de mapping (le champ value).
@ToString
public abstract class ValueObject<T> {

    protected T value;

    protected ValueObject(){}

    protected ValueObject(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        this.value = value;
    }

    public T value() {
        return value;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValueObject<?> that = (ValueObject<?>) o;
        return value.equals(that.value);
    }

    @Override
    public final int hashCode() {
        return value.hashCode();
    }
}
