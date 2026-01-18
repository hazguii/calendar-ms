package com.promeet.calendar.domain.model;

import com.promeet.calendar.domain.ddd.AggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "calendar_event")
public class CalendarEvent extends AggregateRoot {

    @EmbeddedId // Car c'est l'ID
    @AttributeOverride(name = "value", column = @Column(name = "id"))
    private CalendarEventId id;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "owner_id"))
    private CalendarEventOwner owner;
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "title"))
    private CalendarEventTitle title;
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "description"))
    private CalendarEventDescription description;
    @Embedded
    @AttributeOverride(name="value", column = @Column(name = "starting_date"))
    private Timestamp startingDate;
    @Embedded
    @AttributeOverride(name="value", column = @Column(name = "ending_date"))
    private Timestamp endingDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CalendarEventStatus status;

    private CalendarEvent(CalendarEventId id){
        super(id.value());
        this.id = id;
    }

    protected CalendarEvent(){
        super(UUID.randomUUID());
    }

    public static CalendarEvent create(
            CalendarEventOwner owner,
            CalendarEventTitle title,
            CalendarEventDescription description,
            Timestamp startingDate,
            Timestamp endingDate,
            CalendarEventStatus status
    ){
        // Creating a new Calendar event
        CalendarEventId id = new CalendarEventId(UUID.randomUUID());
        CalendarEvent event = new CalendarEvent(id);

        // Setting event details
        event.setOwner(owner);
        event.setTitle(title);
        event.setDescription(description);
        event.setStartingDate(startingDate);
        event.setEndingDate(endingDate);
        event.setStatus(status);

        return event;
    }

    public void setEndingDate(Timestamp date){
        int comparatorResult = date.compareTo(this.startingDate);
        if (comparatorResult>0) throw new IllegalArgumentException("ending date should not be before starting date");
        this.endingDate = date;
    }

}
