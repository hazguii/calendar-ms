package com.promeet.calendar.application.command;

import com.promeet.calendar.domain.ddd.Command;
import com.promeet.calendar.domain.model.*;
import lombok.Builder;

@Builder
public record CreateCalendarEventCommand(CalendarEventOwner owner,
                                         CalendarEventTitle title,
                                         CalendarEventDescription description,
                                         Timestamp startingDate,
                                         Timestamp endingDate,
                                         CalendarEventStatus status) implements Command {
}
