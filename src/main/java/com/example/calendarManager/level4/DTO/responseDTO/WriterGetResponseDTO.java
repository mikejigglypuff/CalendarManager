package com.example.calendarManager.level4.DTO.responseDTO;

import com.example.calendarManager.level4.domain.Writer;

public class WriterGetResponseDTO {
    private final Writer writer;

    public WriterGetResponseDTO(Writer writer) {
        this.writer = writer;
    }

    public Writer getWriter() {
        return writer;
    }
}
