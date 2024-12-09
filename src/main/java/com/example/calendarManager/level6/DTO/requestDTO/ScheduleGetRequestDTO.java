package com.example.calendarManager.level6.DTO.requestDTO;

import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ScheduleGetRequestDTO extends RequestDTO {
    @Positive(message = "writerID는 양의 정수여야 합니다.")
    private final Long writerID;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private final LocalDate updatedAt;

    public ScheduleGetRequestDTO(Long writerID, LocalDate updatedAt) {
        this.writerID = writerID;
        this.updatedAt = updatedAt;
        if(this.hasWriterID()) map.put("writerID", writerID);
        if(this.isUpdatedAt()) map.put("updatedAt", updatedAt);
    }

    public Long getWriterID() { return writerID; }
    public LocalDate getUpdatedAt() { return updatedAt; }

    private boolean hasWriterID() { return this.writerID != null; }
    private boolean isUpdatedAt() { return updatedAt != null; }
}
