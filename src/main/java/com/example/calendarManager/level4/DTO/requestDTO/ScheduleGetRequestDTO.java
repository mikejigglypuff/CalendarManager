package com.example.calendarManager.level4.DTO.requestDTO;

import java.time.LocalDate;

public class ScheduleGetRequestDTO {
    private final Long writerID;
    private final LocalDate updatedAt;

    public ScheduleGetRequestDTO(Long writerID, LocalDate updatedAt) {
        this.writerID = writerID;
        this.updatedAt = updatedAt;
    }

    public Long getWriterID() { return writerID; }
    public LocalDate getUpdatedAt() { return updatedAt; }

    public boolean hasWriterID() { return this.writerID != null; }
    public boolean isUpdatedAt() { return updatedAt != null; }
}
