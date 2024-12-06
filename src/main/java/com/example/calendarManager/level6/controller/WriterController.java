package com.example.calendarManager.level6.controller;

import com.example.calendarManager.level6.DTO.requestDTO.WriterPostRequestDTO;
import com.example.calendarManager.level6.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level6.DTO.responseDTO.WriterPostResponseDTO;
import com.example.calendarManager.level6.service.WriterService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/writer", consumes = "application/json")
public class WriterController {
    private final WriterService service;

    @Autowired
    public WriterController(WriterService service) {
        this.service = service;
    }

    @PostMapping
    public WriterPostResponseDTO postWriter(@Valid @RequestBody WriterPostRequestDTO requestDTO) {
        return service.addWriter(requestDTO);
    }

    @GetMapping(value = "/{writerID}")
    public WriterGetResponseDTO getWriter(
        @Positive(message = "writerID는 양의 정수여야 합니다.") @PathVariable Long writerID) {
        return service.getWriter(writerID);
    }
}
