package com.promeet.calendar.application.handlers;

import com.promeet.calendar.application.command.CreateCalendarEventCommand;
import com.promeet.calendar.domain.ddd.CommandHandler;
import com.promeet.calendar.domain.event.CalendarEventCreated;
import com.promeet.calendar.domain.model.CalendarEvent;
import com.promeet.calendar.domain.model.CalendarEventRepository;
import com.promeet.calendar.domain.model.Timestamp;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class CreateCalendarEventHandler implements CommandHandler<CreateCalendarEventCommand> {

    private final CalendarEventRepository repository;

    @Override
    @Transactional
    public void handle(CreateCalendarEventCommand command) {
        CalendarEvent event = CalendarEvent.create(
                command.owner(),
                command.title(),
                command.description(),
                command.startingDate(),
                command.endingDate(),
                command.status()
        );
        this.repository.save(event);

        // Creating domain event
        CalendarEventCreated domainEvent = new CalendarEventCreated();
        domainEvent.setId(event.getId());
        domainEvent.setOccurredOn(new Timestamp(new Date()));
        domainEvent.setEventTitle(event.getTitle());
    }
}
