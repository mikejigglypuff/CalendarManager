package com.example.calendarManager.level6.DTO.responseDTO;

import com.example.calendarManager.level6.domain.Writer;

public class WriterGetResponseDTO {
    private final Writer writer;

    public WriterGetResponseDTO(Writer writer) {
        this.writer = writer;
    }

    public Writer getWriter() {
        return writer;
    }
}
