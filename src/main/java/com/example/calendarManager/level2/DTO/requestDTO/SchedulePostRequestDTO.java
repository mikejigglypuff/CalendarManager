package com.example.calendarManager.level2.DTO.requestDTO;

import jakarta.validation.constraints.NotNull;

public class SchedulePostRequestDTO {
    @NotNull(message = "works가 포함되어야 합니다")
    private final String works;
    @NotNull(message = "writer가 포함되어야 합니다")
    private final String writer;
    @NotNull(message = "password가 포함되어야 합니다")
    private final String password;

    public SchedulePostRequestDTO(String works, String writer, String password) {
        this.works = works;
        this.writer = writer;
        this.password = password;
    }

    public String getWorks() {
        return works;
    }

    public String getWriter() {
        return writer;
    }

    public String getPassword() {
        return password;
    }
}
