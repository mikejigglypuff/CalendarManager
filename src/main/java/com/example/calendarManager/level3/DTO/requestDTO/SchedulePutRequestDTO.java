package com.example.calendarManager.level3.DTO.requestDTO;

import jakarta.validation.constraints.NotNull;

public class SchedulePutRequestDTO {
    @NotNull(message = "scheduleID가 포함되어야 합니다")
    private final Long scheduleID;
    @NotNull(message = "password가 포함되어야 합니다")
    private final String password;

    public SchedulePutRequestDTO(Long scheduleID, String password) {
        this.scheduleID = scheduleID;
        this.password = password;
    }

    public Long getScheduleID() {
        return scheduleID;
    }

    public String getPassword() {
        return password;
    }
}
