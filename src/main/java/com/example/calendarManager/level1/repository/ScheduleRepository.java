package com.example.calendarManager.level1.repository;

import com.example.calendarManager.level1.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level1.Schedule;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository {
    public int save(Schedule schedule);

    public ScheduleGetResponseDTO findOne(Long scheduleID);
    public List<ScheduleGetResponseDTO> findAll();
    public List<ScheduleGetResponseDTO> findByWriter(String writer);
    public List<ScheduleGetResponseDTO> findByUpdatedAt(LocalDate updatedAt);
    public List<ScheduleGetResponseDTO> findByWriterAndUpdatedAt(String writer, LocalDate updatedAt);
}
