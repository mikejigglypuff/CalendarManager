package com.example.calendarManager.level3.DTO.requestDTO;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class WriterPostRequestDTO {
    @NotNull(message = "writerName이 포함되어야 합니다")
    private final String writerName;
    @NotNull(message = "email이 포함되어야 합니다")
    private final String email;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private final LocalDateTime updatedAt = LocalDateTime.now();

    public WriterPostRequestDTO(String writerName, String email) {
        this.writerName = writerName;
        this.email = email;
    }

    public String getWriterName() {
        return writerName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
