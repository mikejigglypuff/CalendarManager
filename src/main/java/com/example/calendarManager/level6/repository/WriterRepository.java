package com.example.calendarManager.level6.repository;

import com.example.calendarManager.level6.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level6.domain.Writer;

public interface WriterRepository{
    public String save(Writer writer);

    public WriterGetResponseDTO findOne(Long writerID);
}