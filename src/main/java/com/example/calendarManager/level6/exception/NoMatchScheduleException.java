package com.example.calendarManager.level6.exception;

import java.util.NoSuchElementException;

public class NoMatchScheduleException extends NoSuchElementException {
    public NoMatchScheduleException() {
        super("요청과 일치하는 일정이 없습니다.");
    }
}
