package com.example.calendarManager.level3.DTO.responseDTO;

import com.example.calendarManager.level3.domain.Writer;

import java.time.LocalDateTime;

public class WriterGetResponseDTO {
    private final Writer writer;

    public WriterGetResponseDTO(Writer writer) {
        this.writer = writer;
    }

    public Writer getWriter() {
        return writer;
    }
}
