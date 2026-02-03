package com.promeet.calendar.controller;

import com.promeet.calendar.application.command.CreateCalendarEventCommand;
import com.promeet.calendar.application.handlers.CreateCalendarEventHandler;
import com.promeet.calendar.domain.event.CalendarEventCreated;
import com.promeet.calendar.domain.model.*;
import com.promeet.calendar.dto.CreateCalendarEventDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CalendarResource {

    private final CreateCalendarEventHandler createCalendarEventHandler;

    public CalendarResource(CreateCalendarEventHandler createCalendarEventHandler) {
        this.createCalendarEventHandler = createCalendarEventHandler;
    }

    @PostMapping("/v1/calendar")
    public ResponseEntity<Void> getCalendarEvent(@RequestBody CreateCalendarEventDto request){
        // Creating the command
        CreateCalendarEventCommand command = CreateCalendarEventCommand.builder()
                .owner(new CalendarEventOwner(UUID.randomUUID()))
                .title(new CalendarEventTitle(request.getTitle()))
                .description(new CalendarEventDescription(request.getDescription()))
                .startingDate(new Timestamp(request.getStartingDate()))
                .endingDate(new Timestamp(request.getEndingDate()))
                .status(CalendarEventStatus.SCHEDULED)
                .build();
        createCalendarEventHandler.handle(command);


        return ResponseEntity.ok().build();
    }



}
