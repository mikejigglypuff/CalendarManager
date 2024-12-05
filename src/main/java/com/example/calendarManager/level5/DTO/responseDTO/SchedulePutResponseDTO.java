package com.example.calendarManager.level5.DTO.responseDTO;

public class SchedulePutResponseDTO {
    private final String message;

    public SchedulePutResponseDTO(int deletedRowNumber) {
        this.message = deletedRowNumber + "개의 일정을 삭제했습니다.";
    }

    public String getMessage() {
        return message;
    }
}
