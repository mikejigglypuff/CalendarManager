package com.example.calendarManager.level4.DTO.requestDTO;

import jakarta.validation.constraints.NotNull;

public class SchedulePatchRequestDTO {
    @NotNull(message = "password가 포함되어야 합니다")
    private final String password;
    private final String works;
    private final Long writerID;

    public SchedulePatchRequestDTO(String password, String works, Long writerID) {
        this.password = password;
        this.works = works;
        this.writerID = writerID;
    }

    public String getWorks() {
        return works;
    }

    public String getPassword() {
        return password;
    }

    public Long getWriterID() {
        return writerID;
    }

    public boolean hasWorks() { return this.works != null; }
    public boolean hasWriterID(){ return this.writerID != null; }
}
