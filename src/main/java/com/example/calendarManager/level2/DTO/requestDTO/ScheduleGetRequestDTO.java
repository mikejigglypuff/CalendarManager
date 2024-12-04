package com.example.calendarManager.level2.DTO.requestDTO;

import java.time.LocalDate;

public class ScheduleGetRequestDTO {
    private final String writer;
    private final LocalDate updatedAt;

    public ScheduleGetRequestDTO(String writer, LocalDate updatedAt) {
        this.writer = writer;
        this.updatedAt = updatedAt;
    }

    public String getWriter() { return writer; }
    public LocalDate getUpdatedAt() { return updatedAt; }

    public boolean hasWriter() { return !writer.isEmpty(); }
    public boolean isUpdatedAt() { return updatedAt != null; }
}
