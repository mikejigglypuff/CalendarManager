package com.example.calendarManager.level1.mapper;

import com.example.calendarManager.level1.DTO.responseDTO.ScheduleGetResponseDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ScheduleGetResponseDTORowMapper implements RowMapper<ScheduleGetResponseDTO> {
    @Override
    public ScheduleGetResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ScheduleGetResponseDTO(
            rs.getLong("scheduleID"),
            rs.getString("works"),
            rs.getString("writer"),
            rs.getTimestamp("createdAt").toLocalDateTime(),
            rs.getTimestamp("updatedAt").toLocalDateTime()
        );
    }
}
