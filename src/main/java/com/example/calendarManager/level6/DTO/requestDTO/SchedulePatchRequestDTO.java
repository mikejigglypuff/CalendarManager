package com.example.calendarManager.level6.DTO.requestDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class SchedulePatchRequestDTO extends RequestDTO {
    @NotNull(message = "password 값이 포함되어야 합니다.")
    @Size(max = 20, message = "password는 20자 이하여야 합니다.")
    private final String password;

    @Size(max = 200, message = "works는 200자 이하여야 합니다.")
    private final String works;

    @Positive(message = "writerID는 양의 정수여야 합니다.")
    private final Long writerID;

    public SchedulePatchRequestDTO(String password, String works, Long writerID) {
        this.password = password;
        this.works = works;
        this.writerID = writerID;
        map.put("password", password);
        if (this.hasWorks()) map.put("works", works);
        if (this.hasWriterID()) map.put("writerID", writerID);
    }

    public String getWorks() {
        return works;
    }

    public String getPassword() {
        return password;
    }

    public Long getWriterID() {
        return writerID;
    }

    private boolean hasWorks() {
        return this.works != null;
    }

    private boolean hasWriterID() {
        return this.writerID != null;
    }
}
