package com.example.calendarManager.level6.DTO.requestDTO;

import java.util.HashMap;
import java.util.Map;

public class RequestDTO {
    // NamedQuery에 필드를 묶어 parameter로 전달하기 위함
    protected final Map<String, Object> map = new HashMap<>();

    public Map<String, Object> getMap() {
        return map;
    }
}
