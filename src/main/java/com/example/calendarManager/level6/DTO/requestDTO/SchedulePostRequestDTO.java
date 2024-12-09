package com.example.calendarManager.level6.DTO.requestDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class SchedulePostRequestDTO extends RequestDTO {
    @NotNull(message = "works가 포함되어야 합니다.")
    @Size(max = 200, message = "works는 200자 이하여야 합니다.")
    private final String works;

    @NotNull(message = "writerID가 포함되어야 합니다.")
    @Positive(message = "writerID는 양의 정수여야 합니다.")
    private final Long writerID;

    @NotNull(message = "password가 포함되어야 합니다.")
    @Size(max = 20, message = "password는 20자 이하여야 합니다.")
    private final String password;

    public SchedulePostRequestDTO(String works, Long writerID, String password) {
        this.works = works;
        this.writerID = writerID;
        this.password = password;
        map.put("works", works);
        map.put("writerID", writerID);
        map.put("password", password);
    }

    public String getWorks() {
        return works;
    }

    public Long getWriterID() {
        return writerID;
    }

    public String getPassword() {
        return password;
    }
}
