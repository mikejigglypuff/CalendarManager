package com.example.calendarManager.level6.mapper;

import com.example.calendarManager.level6.DTO.responseDTO.ScheduleGetResponseDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

// 쿼리 결과가 필요한 데이터만 갖도록 매핑하는 클래스
@Component
public class ScheduleGetResponseDTORowMapper implements RowMapper<ScheduleGetResponseDTO> {
    @Override
    public ScheduleGetResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ScheduleGetResponseDTO(
            rs.getLong("scheduleID"),
            rs.getString("works"),
            rs.getLong("writerID"),
            rs.getTimestamp("createdAt").toLocalDateTime(),
            rs.getTimestamp("updatedAt").toLocalDateTime()
        );
    }
}
