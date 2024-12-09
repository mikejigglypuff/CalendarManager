package com.example.calendarManager.level6.mapper;


import com.example.calendarManager.level6.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level6.domain.Writer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

// 쿼리 결과가 필요한 데이터만 갖도록 매핑하는 클래스
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
