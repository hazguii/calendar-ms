package com.promeet.calendar.domain.ddd;

public interface CommandHandler <C extends Command>{
    void handle(C command);
}
