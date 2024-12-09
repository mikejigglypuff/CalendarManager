package com.example.calendarManager.level6.exception;

import java.util.NoSuchElementException;

// 에러 메시지 관리용 예외
// 생성자에 매개변수를 받지 않고 하드코딩된 문자열을 이곳에서만 작성되도록 함
// 이러한 방식으로 문자열 입력 실수를 방지하는 목적
public class NoMatchWriterException extends NoSuchElementException {
    public NoMatchWriterException() {
        super("요청과 일치하는 작성자가 없습니다.");
    }
}
