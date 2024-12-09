package com.example.calendarManager.level6.DTO.requestDTO;

import jakarta.validation.constraints.Positive;

public class WriterGetOneRequestDTO extends RequestDTO{
    @Positive(message = "writerID는 양의 정수여야 합니다.")
    private final Long writerID;

    public WriterGetOneRequestDTO(Long writerID) {
        this.writerID = writerID;
        map.put("writerID", writerID);
    }
}
