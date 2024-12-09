package com.example.calendarManager.level6.repository;

import com.example.calendarManager.level6.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level6.domain.Writer;

import java.util.Map;

public interface WriterRepository {
    public String save(Writer writer);

    public WriterGetResponseDTO findOne(Map<String, Object> param);
}
