package com.example.calendarManager.level6.service;

import com.example.calendarManager.level6.DTO.requestDTO.ScheduleGetPageRequestDTO;
import com.example.calendarManager.level6.DTO.requestDTO.ScheduleGetRequestDTO;
import com.example.calendarManager.level6.DTO.requestDTO.SchedulePatchRequestDTO;
import com.example.calendarManager.level6.DTO.requestDTO.SchedulePutRequestDTO;
import com.example.calendarManager.level6.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level6.domain.Schedule;
import com.example.calendarManager.level6.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService{
    private final ScheduleRepository repository;

    @Autowired
    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    public int addSchedule(Schedule schedule) {
        return repository.save(schedule);
    }

    public ScheduleGetResponseDTO getSchedule(Long scheduleID) {
        return repository.findOne(scheduleID);
    }

    public List<ScheduleGetResponseDTO> getScheduleList(ScheduleGetPageRequestDTO dto) {
        return repository.findAll(PageRequest.of(dto.getOffset(), dto.getSize()));
    }

    public List<ScheduleGetResponseDTO> getScheduleList(ScheduleGetRequestDTO dto) {
        boolean hasWriterID = dto.hasWriterID(), isUpdatedAt = dto.isUpdatedAt();

        if(!hasWriterID && !isUpdatedAt) {
            return repository.findAll();
        } else if(!hasWriterID) {
            return repository.findByUpdatedAt(dto.getUpdatedAt());
        } else if(!isUpdatedAt) {
            return repository.findByWriterID(dto.getWriterID());
        }

        return repository.findByWriterIDAndUpdatedAt(dto.getWriterID(), dto.getUpdatedAt());
    }

    public int updateSchedule(SchedulePatchRequestDTO dto) {
        boolean hasWorks = dto.hasWorks(), hasWriterID = dto.hasWriterID();

        if(hasWorks && hasWriterID) {
            return repository.updateWorksAndWriterID(dto.getPassword(), dto.getWorks(), dto.getWriterID());
        } else if(hasWorks) {
            return repository.updateWorks(dto.getPassword(), dto.getWorks());
        } else if(hasWriterID) {
            return repository.updateWriterID(dto.getPassword(), dto.getWriterID());
        }

        return 0;
    }

    public int deleteSchedule(SchedulePutRequestDTO DTO) {
        return repository.delete(DTO.getScheduleID(), DTO.getPassword());
    }
}
