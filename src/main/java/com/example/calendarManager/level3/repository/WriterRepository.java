package com.example.calendarManager.level3.repository;

import com.example.calendarManager.level3.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level3.domain.Writer;

public interface WriterRepository {
    public String save(Writer writer);

    public WriterGetResponseDTO findOne(Long writerID);
}
