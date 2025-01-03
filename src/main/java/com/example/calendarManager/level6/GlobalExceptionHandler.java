package com.example.calendarManager.level6;

import com.example.calendarManager.level6.exception.QueryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

// 전역 범위에서 예외 발생 시의 HTTP 응답을 정의하는 클래스
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return makeStringResBody(HttpStatus.NOT_FOUND, "No element found: " + e.getMessage());
    }

    // 요청에 필수 값들이 포함되지 않았을 때 발생하는 예외 처리
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return makeStringResBody(HttpStatus.BAD_REQUEST, "잘못된 요청: " + e.getMessage());
    }

    // validator 검증 실패해 생긴 MethodArgumentNotValidException 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // 여러 필드들의 validator에서 발생한 문제들을 모두 HTTP response body에 저장
        Map<String, String> body = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error ->
            body.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationExceptionException(DataIntegrityViolationException e) {
        return makeStringResBody(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(QueryException.class)
    public ResponseEntity<String> handleQueryException(QueryException e) {
        return makeStringResBody(HttpStatus.INTERNAL_SERVER_ERROR, "데이터 일관성 문제: " + e.getMessage());
    }

    private ResponseEntity<String> makeStringResBody(HttpStatus status, String body) {
        return ResponseEntity.status(status).body(body);
    }
}
