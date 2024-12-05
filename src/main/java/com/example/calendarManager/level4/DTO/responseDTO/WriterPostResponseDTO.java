package com.example.calendarManager.level4.DTO.responseDTO;

public class WriterPostResponseDTO {
    private final String message;

    public WriterPostResponseDTO(String writer) {
        this.message = writer + "님, 환영합니다.";
    }

    public String getMessage() {
        return message;
    }
}
