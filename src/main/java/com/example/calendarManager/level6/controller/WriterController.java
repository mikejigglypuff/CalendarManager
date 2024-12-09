package com.example.calendarManager.level6.controller;

import com.example.calendarManager.level6.DTO.requestDTO.WriterGetOneRequestDTO;
import com.example.calendarManager.level6.DTO.requestDTO.WriterGetRequestDTO;
import com.example.calendarManager.level6.DTO.requestDTO.WriterPostRequestDTO;
import com.example.calendarManager.level6.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level6.DTO.responseDTO.WriterPostResponseDTO;
import com.example.calendarManager.level6.service.WriterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Service 계층에 DTO를 전달하는 역할
// HTML page를 사용하지 않는 프로젝트이므로 RestController 사용
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

    // 작성자 ID로 작성자 단건 조회
    @GetMapping(value = "/{writerID}")
    public WriterGetResponseDTO getWriter(@PathVariable Long writerID) {
        return service.getWriter(new WriterGetOneRequestDTO(writerID));
    }

    @GetMapping
    public List<WriterGetResponseDTO> getWritersByName(@Valid @ModelAttribute WriterGetRequestDTO dto) {
        return service.getWriterByName(dto);
    }
}
