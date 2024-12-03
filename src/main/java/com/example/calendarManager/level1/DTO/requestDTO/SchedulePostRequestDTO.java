package com.example.calendarManager.level1.DTO.requestDTO;

public class SchedulePostRequestDTO {
    private final String works;
    private final String writer;
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
