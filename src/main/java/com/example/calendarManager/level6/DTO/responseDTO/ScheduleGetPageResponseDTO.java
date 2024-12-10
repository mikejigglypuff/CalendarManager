package com.example.calendarManager.level6.DTO.responseDTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ScheduleGetPageResponseDTO {
    private final Long scheduleID;
    private final String writerName;
    private final String works;
    private final Long writerID;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}
