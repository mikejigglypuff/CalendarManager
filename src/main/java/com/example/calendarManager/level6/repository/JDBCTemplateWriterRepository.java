package com.example.calendarManager.level6.repository;

import com.example.calendarManager.level6.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level6.domain.Writer;
import com.example.calendarManager.level6.mapper.WriterGetResponseDTORowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JDBCTemplateWriterRepository implements WriterRepository {
    private final NamedParameterJdbcTemplate namedTemplate;
    private final WriterGetResponseDTORowMapper rowMapper;

    @Autowired
    public JDBCTemplateWriterRepository(DataSource dataSource, WriterGetResponseDTORowMapper rowMapper) {
        this.namedTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.rowMapper = rowMapper;
    }

    @Override
    public String save(Writer writer) {
        String sql = "insert into writer (writerName, email, createdAt, updatedAt)"
            + " values (:writerName, :email, :createdAt, :updatedAt)";
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(writer);
        namedTemplate.update(sql, parameterSource);
        return writer.getWriterName();
    }

    @Override
    public WriterGetResponseDTO findOne(Map<String, Object> param) {
        return namedTemplate.queryForObject("select * from writer where writerID = :writerID", param, rowMapper);
    }
}
