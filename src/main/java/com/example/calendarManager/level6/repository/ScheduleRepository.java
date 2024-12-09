package com.example.calendarManager.level6.repository;

import com.example.calendarManager.level6.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level6.domain.Schedule;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ScheduleRepository{
    public int save(Schedule schedule);

    public ScheduleGetResponseDTO findOne(Map<String, Object> param);
    public List<ScheduleGetResponseDTO> findAll();
    public List<ScheduleGetResponseDTO> findAll(Pageable pageable);
    public List<ScheduleGetResponseDTO> findByWriterID(Map<String, Object> param);
    public List<ScheduleGetResponseDTO> findByUpdatedAt(Map<String, Object> param);
    public List<ScheduleGetResponseDTO> findByWriterIDAndUpdatedAt(Map<String, Object> param);

    public int updateWorks(Map<String, Object> param);
    public int updateWriterID(Map<String, Object> param);
    public int updateWorksAndWriterID(Map<String, Object> param);

    public int delete(Map<String, Object> param);
}
