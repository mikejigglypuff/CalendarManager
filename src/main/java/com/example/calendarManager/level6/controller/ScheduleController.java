package com.example.calendarManager.level6.controller;

import com.example.calendarManager.level6.DTO.requestDTO.*;
import com.example.calendarManager.level6.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level6.DTO.responseDTO.SchedulePatchResponseDTO;
import com.example.calendarManager.level6.DTO.responseDTO.SchedulePostResponseDTO;
import com.example.calendarManager.level6.DTO.responseDTO.SchedulePutResponseDTO;
import com.example.calendarManager.level6.domain.Schedule;
import com.example.calendarManager.level6.service.ScheduleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
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

    @GetMapping("/{scheduleID}")
    public ScheduleGetResponseDTO getSchedule(
        @Positive(message = "scheduleID는 양의 정수여야 합니다.") @PathVariable Long scheduleID) {
        return service.getSchedule(scheduleID);
    }

    @GetMapping("/page")
    public List<ScheduleGetResponseDTO> getSchedulePage(@Valid ScheduleGetPageRequestDTO requestDTO) {
        return service.getScheduleList(requestDTO);
    }

    @GetMapping
    public List<ScheduleGetResponseDTO> getSchedules(
        @RequestParam(required = false, defaultValue = "") Long writerID,
        @RequestParam(required = false) LocalDate updatedAt
    ) {
        return service.getScheduleList(new ScheduleGetRequestDTO(writerID, updatedAt));
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
