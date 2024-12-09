package com.example.calendarManager.level6.DTO.requestDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class SchedulePutRequestDTO extends RequestDTO {
    @NotNull(message = "schedule이 포함되어야 합니다.")
    @Positive(message = "scheduleID는 양의 정수여야 합니다.")
    private final Long scheduleID;

    @NotNull(message = "password가 포함되어야 합니다.")
    @Size(max = 20, message = "password는 20자 이하여야 합니다.")
    private final String password;

    public SchedulePutRequestDTO(Long scheduleID, String password) {
        this.scheduleID = scheduleID;
        this.password = password;
        map.put("scheduleID", scheduleID);
        map.put("password", password);
    }

    public Long getScheduleID() {
        return scheduleID;
    }

    public String getPassword() {
        return password;
    }
}
