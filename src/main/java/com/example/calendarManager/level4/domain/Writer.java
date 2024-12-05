package com.example.calendarManager.level4.domain;

import com.example.calendarManager.level4.DTO.requestDTO.WriterPostRequestDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("writer")
public class Writer {
    @Id
    private Long writerID;
    private final String writerName;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public Writer(WriterPostRequestDTO dto) {
        this.writerName = dto.getWriterName();
        this.email = dto.getEmail();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Writer(
        Long writerID, String writerName, String email, LocalDateTime createdAt, LocalDateTime updatedAt
    ) {
        this.writerID = writerID;
        this.writerName = writerName;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getWriterID() { return writerID; }

    public String getWriterName() { return writerName; }

    public String getEmail() { return email; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
