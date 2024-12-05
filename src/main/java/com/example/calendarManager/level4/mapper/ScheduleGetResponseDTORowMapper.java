package com.example.calendarManager.level4.mapper;

import com.example.calendarManager.level4.DTO.responseDTO.ScheduleGetResponseDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

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
