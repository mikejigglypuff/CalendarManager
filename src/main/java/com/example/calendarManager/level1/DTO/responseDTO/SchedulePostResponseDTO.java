package com.example.calendarManager.level1.DTO.responseDTO;

public class SchedulePostResponseDTO {
    private final String resultMessage;

    public SchedulePostResponseDTO(int affectedRowNumber) {
        this.resultMessage = affectedRowNumber + "개의 일정이 추가되었습니다.";
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
