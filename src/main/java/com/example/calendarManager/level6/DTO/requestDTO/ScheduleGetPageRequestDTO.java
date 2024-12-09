package com.example.calendarManager.level6.DTO.requestDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ScheduleGetPageRequestDTO extends RequestDTO {
    @NotNull(message = "offset이 포함되어야 합니다.")
    @Positive(message = "offset은 양의 정수여야 합니다.")
    private final Integer offset;

    @NotNull(message = "size가 포함되어야 합니다.")
    @Positive(message = "size는 양의 정수여야 합니다.")
    private final Integer size;

    public ScheduleGetPageRequestDTO(Integer offset, Integer size) {
        this.offset = offset;
        this.size = size;
        map.put("offset", offset);
        map.put("size", size);
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getSize() {
        return size;
    }
}
