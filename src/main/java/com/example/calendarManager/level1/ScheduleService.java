package com.example.calendarManager.level1;

import com.example.calendarManager.level1.DTO.requestDTO.ScheduleGetRequestDTO;
import com.example.calendarManager.level1.DTO.requestDTO.SchedulePostRequestDTO;
import com.example.calendarManager.level1.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level1.repository.ScheduleRepository;
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
}
