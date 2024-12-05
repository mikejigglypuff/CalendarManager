package com.example.calendarManager.level5.DTO.requestDTO;

import jakarta.validation.constraints.NotNull;

public class SchedulePostRequestDTO {
    @NotNull(message = "works가 포함되어야 합니다")
    private final String works;
    @NotNull(message = "writerID가 포함되어야 합니다")
    private final Long writerID;
    @NotNull(message = "password가 포함되어야 합니다")
    private final String password;

    public SchedulePostRequestDTO(String works, Long writerID, String password) {
        this.works = works;
        this.writerID = writerID;
        this.password = password;
    }

    public String getWorks() {
        return works;
    }

    public Long getWriterID() {
        return writerID;
    }

    public String getPassword() {
        return password;
    }
}
