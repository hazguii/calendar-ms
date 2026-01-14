package com.promeet.calendar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalendarResource {

    @GetMapping("/v1/calendar")
    public ResponseEntity<String> getCalendarEvent(){
        return ResponseEntity.ok("Hello world");
    }

}
