package com.example.calendarManager.level3.service;

import com.example.calendarManager.level3.DTO.requestDTO.WriterPostRequestDTO;
import com.example.calendarManager.level3.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level3.DTO.responseDTO.WriterPostResponseDTO;
import com.example.calendarManager.level3.domain.Writer;
import com.example.calendarManager.level3.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriterService {
    private final WriterRepository repository;

    @Autowired
    public WriterService(WriterRepository repository) {
        this.repository = repository;
    }

    public WriterPostResponseDTO addWriter(WriterPostRequestDTO dto) {
        return new WriterPostResponseDTO(repository.save(new Writer(dto)));
    }

    public WriterGetResponseDTO getWriter(Long writerID) {
        return repository.findOne(writerID);
    }
}
