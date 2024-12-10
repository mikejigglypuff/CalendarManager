package com.example.calendarManager.level6.controller;

import com.example.calendarManager.level6.DTO.requestDTO.*;
import com.example.calendarManager.level6.DTO.responseDTO.*;
import com.example.calendarManager.level6.domain.Schedule;
import com.example.calendarManager.level6.service.ScheduleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

// Service 계층에 DTO를 전달하는 역할
// HTML page를 사용하지 않는 프로젝트이므로 RestController 사용
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
        return new SchedulePostResponseDTO(affectedRowNumber);
    }

    // 스케줄 ID로 스케줄 단건 조회
    @GetMapping("/{scheduleID}")
    public ScheduleGetResponseDTO getSchedule(@PathVariable Long scheduleID) {
        return service.getSchedule(new ScheduleGetOneRequestDTO(scheduleID));
    }

    @GetMapping("/page")
    public List<ScheduleGetPageResponseDTO> getSchedulePage(@Valid ScheduleGetPageRequestDTO requestDTO) {
        return service.getScheduleList(requestDTO);
    }

    @GetMapping
    public List<ScheduleGetResponseDTO> getSchedules(@Valid @ModelAttribute ScheduleGetRequestDTO dto) {
        return service.getScheduleList(dto);
    }

    @PatchMapping
    public SchedulePatchResponseDTO patchSchedule(@Valid @RequestBody SchedulePatchRequestDTO requestDTO) {
        int patchResult = service.updateSchedule(requestDTO);
        return new SchedulePatchResponseDTO(patchResult);
    }

    // DELETE method 사용 시 비밀번호를 request body에 담을 수 없으므로 PUT 메서드를 사용함
    @PutMapping
    public SchedulePutResponseDTO putSchedule(@Valid @RequestBody SchedulePutRequestDTO requestDTO) {
        int deleteResult = service.deleteSchedule(requestDTO);
        return new SchedulePutResponseDTO(deleteResult);
    }

}
