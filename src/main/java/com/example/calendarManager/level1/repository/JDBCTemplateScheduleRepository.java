package com.example.calendarManager.level1.repository;

import com.example.calendarManager.level1.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level1.Schedule;
import com.example.calendarManager.level1.mapper.ScheduleGetResponseDTORowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JDBCTemplateScheduleRepository implements ScheduleRepository{
    private final JdbcTemplate template;
    private final NamedParameterJdbcTemplate namedParameterTemplate;
    private final ScheduleGetResponseDTORowMapper dtoRowMapper;

    @Autowired
    public JDBCTemplateScheduleRepository(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        this.namedParameterTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.dtoRowMapper = new ScheduleGetResponseDTORowMapper();
    }

    @Override
    public int save(Schedule schedule) {
        String sql = "insert into schedule (works, writer, password, createdAt, updatedAt)"
            + " values (:works, :writer, :password, :createdAt, :updatedAt)";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(schedule);

        return namedParameterTemplate.update(sql, paramSource);
    }

    @Override
    public List<ScheduleGetResponseDTO> findAll() {
        String sql = "select * from schedule";
        return template.query(sql, dtoRowMapper);
    }

    @Override
    public List<ScheduleGetResponseDTO> findByWriter(String writer) {
        String sql = "select * from schedule where writer = :writer";
        Map<String, Object> params = new HashMap<>();
        params.put("writer", writer);

        return namedParameterTemplate.query(sql, params, dtoRowMapper);
    }

    @Override
    public List<ScheduleGetResponseDTO> findByUpdatedAt(LocalDate updatedAt) {
        String sql = "select * from schedule where updatedAt > :updatedAt";
        Map<String, Object> params = new HashMap<>();
        params.put("updatedAt", updatedAt);

        return namedParameterTemplate.query(sql, params, dtoRowMapper);
    }

    @Override
    public List<ScheduleGetResponseDTO> findByWriterAndUpdatedAt(String writer, LocalDate updatedAt) {
        String sql = "select * from schedule where writer = :writer and updatedAt > :updatedAt";
        Map<String, Object> params = new HashMap<>();
        params.put("writer", writer);
        params.put("updatedAt", updatedAt);

        return namedParameterTemplate.query(sql, params, dtoRowMapper);
    }
}
