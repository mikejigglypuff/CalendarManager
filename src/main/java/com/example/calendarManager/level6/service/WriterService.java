package com.example.calendarManager.level6.service;

import com.example.calendarManager.level6.DTO.requestDTO.WriterGetOneRequestDTO;
import com.example.calendarManager.level6.DTO.requestDTO.WriterPostRequestDTO;
import com.example.calendarManager.level6.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level6.DTO.responseDTO.WriterPostResponseDTO;
import com.example.calendarManager.level6.domain.Writer;
import com.example.calendarManager.level6.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriterService{
    private final WriterRepository repository;

    @Autowired
    public WriterService(WriterRepository repository) {
        this.repository = repository;
    }

    public WriterPostResponseDTO addWriter(WriterPostRequestDTO dto) {
        return new WriterPostResponseDTO(repository.save(new Writer(dto)));
    }

    public WriterGetResponseDTO getWriter(WriterGetOneRequestDTO dto) {
        return repository.findOne(dto.getMap());
    }
}