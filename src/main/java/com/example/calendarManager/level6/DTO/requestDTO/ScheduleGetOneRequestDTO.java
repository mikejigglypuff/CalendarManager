package com.example.calendarManager.level6.DTO.requestDTO;

import jakarta.validation.constraints.Positive;

public class ScheduleGetOneRequestDTO extends RequestDTO {
    @Positive(message = "scheduleID는 양의 정수여야 합니다.")
    private final Long scheduleID;

    public ScheduleGetOneRequestDTO(Long scheduleID) {
        this.scheduleID = scheduleID;
        map.put("scheduleID", scheduleID);
    }
}
