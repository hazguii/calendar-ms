package com.promeet.calendar.application;

import com.promeet.calendar.application.command.CreateCalendarEventCommand;
import com.promeet.calendar.application.handlers.CreateCalendarEventHandler;
import com.promeet.calendar.domain.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateCalendarEventHandlerTest {

    @InjectMocks
    public CreateCalendarEventHandler handler;

    @Mock
    public CalendarEventRepository calendarEventRepository;

    @Captor
    ArgumentCaptor<CalendarEvent> captor;

    @Test
    public void should_create_calendar_event(){
        // Arrange
        UUID ownerId = UUID.randomUUID();
        CreateCalendarEventCommand command = CreateCalendarEventCommand.builder()
                .owner(new CalendarEventOwner(ownerId))
                .title(new CalendarEventTitle("Test Title"))
                .description(new CalendarEventDescription("Test Description"))
                .startingDate(new Timestamp())
                .endingDate(new Timestamp())
                .status(CalendarEventStatus.SCHEDULED)
                .build();
        doNothing().when(calendarEventRepository).save(any(CalendarEvent.class));

        // Act
        handler.handle(command);
        verify(calendarEventRepository).save(captor.capture());

        // Assert
        CalendarEvent event = captor.getValue();
        Assertions.assertAll(
                () -> Assertions.assertNotNull(event.getId())
        );
    }
}
