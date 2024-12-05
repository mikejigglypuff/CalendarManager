package com.example.calendarManager.level3.DTO.responseDTO;

public class SchedulePatchResponseDTO {
    private final String message;

    public SchedulePatchResponseDTO(int patchRowNumber) {
        this.message = patchRowNumber + "개의 일정을 수정했습니다.";
    }

    public String getMessage() {
        return message;
    }
}
