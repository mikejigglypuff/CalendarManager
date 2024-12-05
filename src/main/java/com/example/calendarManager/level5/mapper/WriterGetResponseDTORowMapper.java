package com.example.calendarManager.level5.mapper;


import com.example.calendarManager.level5.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level5.domain.Writer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class WriterGetResponseDTORowMapper implements RowMapper<WriterGetResponseDTO> {
    @Override
    public WriterGetResponseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Writer writer = new Writer(
            rs.getLong("writerID"),
            rs.getString("writerName"),
            rs.getString("email"),
            rs.getTimestamp("createdAt").toLocalDateTime(),
            rs.getTimestamp("updatedAt").toLocalDateTime()
        );

        return new WriterGetResponseDTO(writer);
    }
}
