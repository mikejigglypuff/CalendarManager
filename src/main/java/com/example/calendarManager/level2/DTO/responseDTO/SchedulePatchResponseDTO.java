package com.example.calendarManager.level2.DTO.responseDTO;

public class SchedulePatchResponseDTO {
    private final String resultMessage;

    public SchedulePatchResponseDTO(int patchRowNumber) {
        this.resultMessage = patchRowNumber + "개의 일정을 수정했습니다.";
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
