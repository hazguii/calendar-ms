package com.promeet.calendar.application.handlers;

import com.promeet.calendar.application.command.CreateCalendarEventCommand;
import com.promeet.calendar.domain.ddd.CommandHandler;
import com.promeet.calendar.domain.model.CalendarEvent;
import com.promeet.calendar.domain.model.CalendarEventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

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
    }
}
