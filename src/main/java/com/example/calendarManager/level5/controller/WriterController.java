package com.example.calendarManager.level5.controller;

import com.example.calendarManager.level5.DTO.requestDTO.WriterPostRequestDTO;
import com.example.calendarManager.level5.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level5.DTO.responseDTO.WriterPostResponseDTO;
import com.example.calendarManager.level5.service.WriterService;
import jakarta.validation.Valid;
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
    public WriterGetResponseDTO getWriter(@PathVariable Long writerID) {
        return service.getWriter(writerID);
    }
}
