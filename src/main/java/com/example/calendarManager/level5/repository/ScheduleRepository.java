package com.example.calendarManager.level5.repository;

import com.example.calendarManager.level5.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level5.domain.Schedule;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository {
    public int save(Schedule schedule);

    public ScheduleGetResponseDTO findOne(Long scheduleID);
    public List<ScheduleGetResponseDTO> findAll();
    public List<ScheduleGetResponseDTO> findAll(Pageable pageable);
    public List<ScheduleGetResponseDTO> findByWriterID(Long writerID);
    public List<ScheduleGetResponseDTO> findByUpdatedAt(LocalDate updatedAt);
    public List<ScheduleGetResponseDTO> findByWriterIDAndUpdatedAt(Long writerID, LocalDate updatedAt);

    public int updateWorks(String password, String works);
    public int updateWriterID(String password, Long writerID);
    public int updateWorksAndWriterID(String password, String works, Long writerID);

    public int delete(Long scheduleID, String password);
}
