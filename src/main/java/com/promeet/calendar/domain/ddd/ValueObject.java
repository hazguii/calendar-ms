package com.promeet.calendar.domain.ddd;

public abstract class ValueObject<T> {

    protected final T value;

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
