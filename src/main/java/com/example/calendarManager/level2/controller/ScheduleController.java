package com.example.calendarManager.level2.controller;

import com.example.calendarManager.level2.DTO.requestDTO.ScheduleGetRequestDTO;
import com.example.calendarManager.level2.DTO.requestDTO.SchedulePatchRequestDTO;
import com.example.calendarManager.level2.DTO.requestDTO.SchedulePostRequestDTO;
import com.example.calendarManager.level2.DTO.requestDTO.SchedulePutRequestDTO;
import com.example.calendarManager.level2.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level2.DTO.responseDTO.SchedulePatchResponseDTO;
import com.example.calendarManager.level2.DTO.responseDTO.SchedulePostResponseDTO;
import com.example.calendarManager.level2.DTO.responseDTO.SchedulePutResponseDTO;
import com.example.calendarManager.level2.domain.Schedule;
import com.example.calendarManager.level2.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/schedule", consumes = "application/json")
public class ScheduleController {
    private final ScheduleService service;

    @Autowired
    public ScheduleController(ScheduleService service) {
        this.service = service;
    }

    @PostMapping
    public SchedulePostResponseDTO postSchedule(@Valid @RequestBody SchedulePostRequestDTO requestDTO) {
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

    @PatchMapping
    public SchedulePatchResponseDTO patchSchedule(@Valid @RequestBody SchedulePatchRequestDTO requestDTO) {
        int patchResult = service.updateSchedule(requestDTO);
        // 로깅 추가할 것
        return new SchedulePatchResponseDTO(patchResult);
    }

    @PutMapping
    public SchedulePutResponseDTO putSchedule(@Valid @RequestBody SchedulePutRequestDTO requestDTO) {
        int deleteResult = service.deleteSchedule(requestDTO);
        // 로깅 추가할 것
        return new SchedulePutResponseDTO(deleteResult);
    }
}
