package com.example.calendarManager.level5.repository;

import com.example.calendarManager.level5.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level5.domain.Writer;

public interface WriterRepository{
    public String save(Writer writer);

    public WriterGetResponseDTO findOne(Long writerID);
}
