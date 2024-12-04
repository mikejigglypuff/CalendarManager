package com.example.calendarManager.level2.repository;

import com.example.calendarManager.level2.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level2.domain.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository {
    public int save(Schedule schedule);

    public ScheduleGetResponseDTO findOne(Long scheduleID);
    public List<ScheduleGetResponseDTO> findAll();
    public List<ScheduleGetResponseDTO> findByWriter(String writer);
    public List<ScheduleGetResponseDTO> findByUpdatedAt(LocalDate updatedAt);
    public List<ScheduleGetResponseDTO> findByWriterAndUpdatedAt(String writer, LocalDate updatedAt);

    public int updateWorks(String password, String works);
    public int updateWriter(String password, String writer);
    public int updateWorksAndWriter(String password, String works, String writer);

    public int delete(Long scheduleID, String password);
}
