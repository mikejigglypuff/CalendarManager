package com.example.calendarManager.level2.DTO.requestDTO;

import jakarta.validation.constraints.NotNull;

public class SchedulePatchRequestDTO {
    @NotNull(message = "password가 포함되어야 합니다")
    private final String password;
    private final String works;
    private final String writer;

    public SchedulePatchRequestDTO(String password, String works, String writer) {
        this.password = password;
        this.works = works;
        this.writer = writer;
    }

    public String getWorks() {
        return works;
    }

    public String getPassword() {
        return password;
    }

    public String getWriter() {
        return writer;
    }

    public boolean hasWorks() { return !(this.works == null); }
    public boolean hasWriter(){ return !(this.writer == null); }
}
