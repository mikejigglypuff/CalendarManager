package com.example.calendarManager.level2.service;

import com.example.calendarManager.level2.DTO.requestDTO.ScheduleGetRequestDTO;
import com.example.calendarManager.level2.DTO.requestDTO.SchedulePatchRequestDTO;
import com.example.calendarManager.level2.DTO.requestDTO.SchedulePutRequestDTO;
import com.example.calendarManager.level2.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level2.domain.Schedule;
import com.example.calendarManager.level2.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
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

    public List<ScheduleGetResponseDTO> getScheduleList(ScheduleGetRequestDTO dto) {
        boolean hasWriter = dto.hasWriter(), isUpdatedAt = dto.isUpdatedAt();

        if(!hasWriter && !isUpdatedAt) {
            return repository.findAll();
        } else if(!hasWriter) {
            return repository.findByUpdatedAt(dto.getUpdatedAt());
        } else if(!isUpdatedAt) {
            return repository.findByWriter(dto.getWriter());
        } else {
            return repository.findByWriterAndUpdatedAt(dto.getWriter(), dto.getUpdatedAt());
        }
    }

    public int updateSchedule(SchedulePatchRequestDTO dto) {
        boolean hasWorks = dto.hasWorks(), hasWriter = dto.hasWriter();

        if(hasWorks && hasWriter) {
            return repository.updateWorksAndWriter(dto.getPassword(), dto.getWorks(), dto.getWriter());
        } else if(hasWorks) {
            return repository.updateWorks(dto.getPassword(), dto.getWorks());
        } else if(hasWriter) {
            return repository.updateWriter(dto.getPassword(), dto.getWriter());
        }

        return 0;
    }

    public int deleteSchedule(SchedulePutRequestDTO DTO) {
        return repository.delete(DTO.getScheduleID(), DTO.getPassword());
    }
}
