package com.example.calendarManager.level5.DTO.responseDTO;

public class SchedulePostResponseDTO {
    private final String message;

    public SchedulePostResponseDTO(int affectedRowNumber) {
        this.message = affectedRowNumber + "개의 일정이 추가되었습니다.";
    }

    public String getMessage() {
        return message;
    }
}
