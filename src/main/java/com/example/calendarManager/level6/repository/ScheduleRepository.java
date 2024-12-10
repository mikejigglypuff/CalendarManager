package com.example.calendarManager.level6.repository;

import com.example.calendarManager.level6.DTO.responseDTO.ScheduleGetPageResponseDTO;
import com.example.calendarManager.level6.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level6.domain.Schedule;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

// DB 접근기술의 변경을 대비하기 위한 추상화
public interface ScheduleRepository {
    public int save(Schedule schedule);

    public ScheduleGetResponseDTO findOne(Map<String, Object> param);

    public List<ScheduleGetResponseDTO> findAll();

    public List<ScheduleGetPageResponseDTO> findAll(Pageable pageable, Map<String, Object> param);

    public List<ScheduleGetResponseDTO> findByWriterID(Map<String, Object> param);

    public List<ScheduleGetResponseDTO> findByUpdatedAt(Map<String, Object> param);

    public List<ScheduleGetResponseDTO> findByWriterIDAndUpdatedAt(Map<String, Object> param);

    public int updateWorks(Map<String, Object> param);

    public int updateWriterID(Map<String, Object> param);

    public int updateWorksAndWriterID(Map<String, Object> param);

    public int delete(Map<String, Object> param);
}
