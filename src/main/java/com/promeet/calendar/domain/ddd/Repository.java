package com.promeet.calendar.domain.ddd;

import java.util.Optional;

public interface Repository<A extends AggregateRoot, Id extends AggregateId<A>> {
    void save(A aggregateRoot);
    Optional<A> lookup(Id aggregateId);
}
