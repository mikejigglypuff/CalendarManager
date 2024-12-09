package com.example.calendarManager.level6.service;

import com.example.calendarManager.level6.DTO.requestDTO.WriterGetOneRequestDTO;
import com.example.calendarManager.level6.DTO.requestDTO.WriterPostRequestDTO;
import com.example.calendarManager.level6.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level6.DTO.responseDTO.WriterPostResponseDTO;
import com.example.calendarManager.level6.domain.Writer;
import com.example.calendarManager.level6.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Controller에게 DTO 클래스를 받아 Repository가 쿼리하기 좋은 형태로 변환하는 역할 담당
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

    public WriterGetResponseDTO getWriter(WriterGetOneRequestDTO dto) {
        return repository.findOne(dto.getMap());
    }
}