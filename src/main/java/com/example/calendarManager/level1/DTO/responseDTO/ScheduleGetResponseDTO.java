package com.example.calendarManager.level1.DTO.responseDTO;

import java.time.LocalDateTime;

public class ScheduleGetResponseDTO {
    private final Long scheduleID;
    private final String works;
    private final String writer;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ScheduleGetResponseDTO(
        Long scheduleID, String works, String writer, LocalDateTime createdAt, LocalDateTime updatedAt
    ) {
        this.scheduleID = scheduleID;
        this.works = works;
        this.writer = writer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getScheduleID() {
        return scheduleID;
    }

    public String getWorks() {
        return works;
    }

    public String getWriter() {
        return writer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
