package com.example.calendarManager.level6.DTO.requestDTO;

import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ScheduleGetRequestDTO {
    @Positive(message = "writerID는 양의 정수여야 합니다.")
    private final Long writerID;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
