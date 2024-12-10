package com.example.calendarManager.level6.mapper;

import com.example.calendarManager.level6.DTO.responseDTO.ScheduleGetPageResponseDTO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ScheduleGetPageResponseDTOMapper implements RowMapper<ScheduleGetPageResponseDTO> {
    @Override
    public ScheduleGetPageResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ScheduleGetPageResponseDTO(
            rs.getLong("scheduleID"),
            rs.getString("writerName"),
            rs.getString("works"),
            rs.getLong("writerID"),
            rs.getTimestamp("createdAt").toLocalDateTime(),
            rs.getTimestamp("updatedAt").toLocalDateTime()
        );
    }
}
