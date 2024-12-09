package com.example.calendarManager.level6.DTO.requestDTO;

import jakarta.validation.constraints.Positive;

// 요청을 표현하기 위한 클래스
// 단일 필드만 갖게 되도 요청의 표현이 더 중요하다 판단함
public class ScheduleGetOneRequestDTO extends RequestDTO {
    // 값이 null일 경우 자동으로 다른 컨트롤러가 처리됨
    // 따라서 null 체크 할 필요 없음
    @Positive(message = "scheduleID는 양의 정수여야 합니다.")
    private final Long scheduleID;

    public ScheduleGetOneRequestDTO(Long scheduleID) {
        this.scheduleID = scheduleID;
        map.put("scheduleID", scheduleID);
    }
}
