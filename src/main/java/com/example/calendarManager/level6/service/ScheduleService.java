package com.example.calendarManager.level6.service;

import com.example.calendarManager.level6.DTO.requestDTO.*;
import com.example.calendarManager.level6.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level6.domain.Schedule;
import com.example.calendarManager.level6.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

// Controller에게 DTO 클래스를 받아 Repository가 쿼리하기 좋은 형태로 변환하는 역할 담당
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

    public ScheduleGetResponseDTO getSchedule(ScheduleGetOneRequestDTO dto) {
        return repository.findOne(dto.getMap());
    }

    public List<ScheduleGetResponseDTO> getScheduleList(ScheduleGetPageRequestDTO dto) {
        return repository.findAll(PageRequest.of(dto.getOffset(), dto.getSize()), dto.getMap());
    }

    public List<ScheduleGetResponseDTO> getScheduleList(ScheduleGetRequestDTO dto) {
        Map<String, Object> param = dto.getMap();
        boolean hasWriterID = param.containsKey("writerID"), isUpdatedAt = param.containsKey("updatedAt");

        if (!hasWriterID && !isUpdatedAt) {
            return repository.findAll();
        } else if (!hasWriterID) {
            return repository.findByUpdatedAt(param);
        } else if (!isUpdatedAt) {
            return repository.findByWriterID(param);
        }

        return repository.findByWriterIDAndUpdatedAt(param);
    }

    public int updateSchedule(SchedulePatchRequestDTO dto) {
        Map<String, Object> param = dto.getMap();
        param.put("updatedAt", LocalDateTime.now());
        boolean hasWorks = param.containsKey("works"), hasWriterID = param.containsKey("writerID");

        if (hasWorks && hasWriterID) {
            return repository.updateWorksAndWriterID(param);
        } else if (hasWorks) {
            return repository.updateWorks(param);
        } else if (hasWriterID) {
            return repository.updateWriterID(param);
        }

        return 0;
    }

    public int deleteSchedule(SchedulePutRequestDTO dto) {
        return repository.delete(dto.getMap());
    }
}
