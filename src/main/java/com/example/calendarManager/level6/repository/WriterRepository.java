package com.example.calendarManager.level6.repository;

import com.example.calendarManager.level6.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level6.domain.Writer;

import java.util.List;
import java.util.Map;

// DB 접근기술의 변경을 대비하기 위한 추상화
public interface WriterRepository {
    public String save(Writer writer);

    public WriterGetResponseDTO findOne(Map<String, Object> param);
    public List<WriterGetResponseDTO> findByName(Map<String, Object> param);
}
