package com.example.calendarManager.level4.DTO.responseDTO;

import java.time.LocalDateTime;

public class ScheduleGetResponseDTO {
    private final Long scheduleID;
    private final String works;
    private final Long writerID;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ScheduleGetResponseDTO(
        Long scheduleID, String works, Long writerID, LocalDateTime createdAt, LocalDateTime updatedAt
    ) {
        this.scheduleID = scheduleID;
        this.works = works;
        this.writerID = writerID;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getScheduleID() {
        return scheduleID;
    }

    public String getWorks() {
        return works;
    }

    public Long getWriterID() {
        return writerID;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
