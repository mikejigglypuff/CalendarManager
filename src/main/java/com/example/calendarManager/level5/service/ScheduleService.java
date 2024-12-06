package com.example.calendarManager.level5.service;

import com.example.calendarManager.level5.DTO.requestDTO.ScheduleGetPageRequestDTO;
import com.example.calendarManager.level5.DTO.requestDTO.ScheduleGetRequestDTO;
import com.example.calendarManager.level5.DTO.requestDTO.SchedulePatchRequestDTO;
import com.example.calendarManager.level5.DTO.requestDTO.SchedulePutRequestDTO;
import com.example.calendarManager.level5.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level5.domain.Schedule;
import com.example.calendarManager.level5.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ScheduleService{
    private final ScheduleRepository repository;

    @Autowired
    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    public int addSchedule(Schedule schedule) {
        int affectedSchedules = repository.save(schedule);
        checkAffectedRows(affectedSchedules);
        return affectedSchedules;
    }

    public ScheduleGetResponseDTO getSchedule(Long scheduleID) {
        return repository.findOne(scheduleID);
    }

    public List<ScheduleGetResponseDTO> getScheduleList(ScheduleGetPageRequestDTO dto) {
        List<ScheduleGetResponseDTO> schedules = repository.findAll(PageRequest.of(dto.getOffset(), dto.getSize()));
        checkEmptyResult(schedules);
        return schedules;
    }

    public List<ScheduleGetResponseDTO> getScheduleList(ScheduleGetRequestDTO dto) {
        boolean hasWriterID = dto.hasWriterID(), isUpdatedAt = dto.isUpdatedAt();

        List<ScheduleGetResponseDTO>  schedules;
        if(!hasWriterID && !isUpdatedAt) {
            schedules = repository.findAll();
        } else if(!hasWriterID) {
            schedules = repository.findByUpdatedAt(dto.getUpdatedAt());
        } else if(!isUpdatedAt) {
            schedules = repository.findByWriterID(dto.getWriterID());
        } else {
            schedules = repository.findByWriterIDAndUpdatedAt(dto.getWriterID(), dto.getUpdatedAt());
        }

        checkEmptyResult(schedules);
        return schedules;
    }

    public int updateSchedule(SchedulePatchRequestDTO dto) {
        boolean hasWorks = dto.hasWorks(), hasWriterID = dto.hasWriterID();

        int affectedSchedules = 0;
        if(hasWorks && hasWriterID) {
            affectedSchedules = repository.updateWorksAndWriterID(dto.getPassword(), dto.getWorks(), dto.getWriterID());
        } else if(hasWorks) {
            affectedSchedules = repository.updateWorks(dto.getPassword(), dto.getWorks());
        } else if(hasWriterID) {
            affectedSchedules = repository.updateWriterID(dto.getPassword(), dto.getWriterID());
        }

        checkAffectedRows(affectedSchedules);
        return affectedSchedules;
    }

    public int deleteSchedule(SchedulePutRequestDTO DTO) {
        int affectedSchedules = repository.delete(DTO.getScheduleID(), DTO.getPassword());
        checkAffectedRows(affectedSchedules);
        return affectedSchedules;
    }

    public void checkEmptyResult(List<ScheduleGetResponseDTO> result) throws NoSuchElementException {
        if(result.isEmpty()) throw new NoSuchElementException("해당하는 일정이 없습니다.");
    }

    public void checkAffectedRows(int result) throws NoSuchElementException {
        if(result == 0) throw new NoSuchElementException("해당하는 일정이 없습니다.");
    }
}
