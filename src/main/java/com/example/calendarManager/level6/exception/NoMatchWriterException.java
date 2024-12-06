package com.example.calendarManager.level6.exception;

import java.util.NoSuchElementException;

public class NoMatchWriterException extends NoSuchElementException {
    public NoMatchWriterException() {
        super("요청과 일치하는 작성자가 없습니다.");
    }
}
