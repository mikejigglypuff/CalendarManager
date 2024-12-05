package com.example.calendarManager.level4.repository;

import com.example.calendarManager.level4.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level4.domain.Writer;

public interface WriterRepository {
    public String save(Writer writer);

    public WriterGetResponseDTO findOne(Long writerID);
}
