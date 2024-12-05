package com.example.calendarManager.level4.domain;

import com.example.calendarManager.level4.DTO.requestDTO.SchedulePostRequestDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("schedule")
public class Schedule {
    @Id
    private Long scheduleID;
    private String works;
    private LocalDateTime updatedAt;

    private final Long writerID;
    private final String password;
    private final LocalDateTime createdAt;

    public Schedule(SchedulePostRequestDTO dto) {
        this.password = dto.getPassword();
        this.writerID = dto.getWriterID();
        this.works = dto.getWorks();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Schedule(
        String works, Long writerID, String password, LocalDateTime createdAt, LocalDateTime updatedAt
    ) {
        this.password = password;
        this.writerID = writerID;
        this.works = works;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getScheduleID() {
        return scheduleID;
    }

    public Long getWriterID() {
        return writerID;
    }

    public String getWorks() {
        return works;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getPassword() {
        return password;
    }

    public void setWorks(String works) {
        this.works = works;
        this.updatedAt = LocalDateTime.now();
    }
}
