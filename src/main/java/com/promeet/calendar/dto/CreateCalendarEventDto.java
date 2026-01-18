package com.promeet.calendar.dto;

import com.promeet.calendar.application.command.CreateCalendarEventCommand;
import com.promeet.calendar.domain.model.*;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class CreateCalendarEventDto {
    private String title;
    private String description;
    private Date startingDate;
    private Date endingDate;

    public CreateCalendarEventCommand toCommand(UUID ownerId, CalendarEventStatus status) {
        return CreateCalendarEventCommand.builder()
                .build();
    }
}
