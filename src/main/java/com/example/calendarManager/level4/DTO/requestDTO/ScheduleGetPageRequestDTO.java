package com.example.calendarManager.level4.DTO.requestDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ScheduleGetPageRequestDTO {
    @Positive
    private final int offset;
    private final int size;

    public ScheduleGetPageRequestDTO(int offset, int size) {
        this.offset = offset;
        this.size = size;
    }

    public int getOffset() {
        return offset;
    }

    public int getSize() {
        return size;
    }
}
