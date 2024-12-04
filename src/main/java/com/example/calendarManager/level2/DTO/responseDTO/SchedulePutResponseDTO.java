package com.example.calendarManager.level2.DTO.responseDTO;

public class SchedulePutResponseDTO {
    private final String resultMessage;

    public SchedulePutResponseDTO(int deletedRowNumber) {
        this.resultMessage = deletedRowNumber + "개의 일정을 삭제했습니다.";
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
