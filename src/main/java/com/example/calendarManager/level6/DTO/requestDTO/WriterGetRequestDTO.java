package com.example.calendarManager.level6.DTO.requestDTO;

public class WriterGetRequestDTO extends RequestDTO {
    private final String writerName;

    public WriterGetRequestDTO(String writerName) {
        this.writerName = writerName;
        map.put("writerName", writerName);
    }
}
