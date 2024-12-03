package com.example.calendarManager.level1;

import com.example.calendarManager.level1.DTO.requestDTO.SchedulePostRequestDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("schedule")
public class Schedule {
    @Id
    private Long scheduleID;
    private String works;
    private String writer;
    private LocalDateTime updatedAt;

    private final String password;
    private final LocalDateTime createdAt;

    public Schedule(SchedulePostRequestDTO dto) {
        this.password = dto.getPassword();
        this.writer = dto.getWriter();
        this.works = dto.getWorks();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Schedule(
        String works, String writer, String password, LocalDateTime createdAt, LocalDateTime updatedAt
    ) {
        this.password = password;
        this.writer = writer;
        this.works = works;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getScheduleID() {
        return scheduleID;
    }

    public String getWriter() {
        return writer;
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

    public void setWriter(String writer) {
        this.writer = writer;
        this.updatedAt = LocalDateTime.now();
    }

    public void setWorks(String works) {
        this.works = works;
        this.updatedAt = LocalDateTime.now();
    }
}
