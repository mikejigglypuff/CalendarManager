package com.example.calendarManager.level1;

import com.example.calendarManager.level1.DTO.requestDTO.ScheduleGetRequestDTO;
import com.example.calendarManager.level1.DTO.requestDTO.SchedulePostRequestDTO;
import com.example.calendarManager.level1.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level1.DTO.responseDTO.SchedulePostResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//@RestController
@RequestMapping(value = "/schedule", consumes = "application/json")
public class ScheduleController {
    private final ScheduleService service;

    @Autowired
    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    @PostMapping
    public SchedulePostResponseDTO postSchedule(
        @RequestBody SchedulePostRequestDTO requestDTO
    ) {
        int affectedRowNumber = service.addSchedule(new Schedule(requestDTO));
        // 로깅 추가할 것
        return new SchedulePostResponseDTO(affectedRowNumber);
    }

    @GetMapping
    public List<ScheduleGetResponseDTO> getSchedule(
        @RequestParam(required = false, defaultValue = "") String writer,
        @RequestParam(required = false) LocalDate updatedAt
    ) {
        return service.getScheduleList(new ScheduleGetRequestDTO(writer, updatedAt));
    }
}
