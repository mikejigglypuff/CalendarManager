package com.example.calendarManager.level5.repository;

import com.example.calendarManager.level5.DTO.responseDTO.WriterGetResponseDTO;
import com.example.calendarManager.level5.domain.Writer;
import com.example.calendarManager.level5.mapper.WriterGetResponseDTORowMapper;
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
    public WriterGetResponseDTO findOne(Long writerID) {
        String sql = "select * from writer where writerID = :writerID";
        Map<String, Object> param = new HashMap<>();
        param.put("writerID", writerID);
        return namedTemplate.queryForObject(sql, param, rowMapper);
    }
}
