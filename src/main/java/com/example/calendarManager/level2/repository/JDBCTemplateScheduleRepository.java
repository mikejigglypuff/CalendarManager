package com.example.calendarManager.level2.repository;

import com.example.calendarManager.level2.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level2.domain.Schedule;
import com.example.calendarManager.level2.mapper.ScheduleGetResponseDTORowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JDBCTemplateScheduleRepository implements ScheduleRepository {
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

    @Override
    public int updateWorks(String password, String works) {
        String sql = "update schedule set works = :works, updatedAt = :updatedAt" +
            " where password = :password";
        Map<String, Object> params = new HashMap<>();
        params.put("works", works);
        params.put("updatedAt", LocalDateTime.now());
        params.put("password", password);

        return namedParameterTemplate.update(sql, params);
    }

    @Override
    public int updateWriter(String password, String writer) {
        String sql = "update schedule set writer=:writer, updatedAt = :updatedAt" +
            " where password = :password";
        Map<String, Object> params = new HashMap<>();
        params.put("writer", writer);
        params.put("updatedAt", LocalDateTime.now());
        params.put("password", password);

        return namedParameterTemplate.update(sql, params);
    }

    @Override
    public int updateWorksAndWriter(String password, String works, String writer) {
        String sql = "update schedule set works=:works, writer=:writer, updatedAt = :updatedAt"
            + " where password = :password";
        Map<String, Object> params = new HashMap<>();
        params.put("works", works);
        params.put("writer", writer);
        params.put("updatedAt", LocalDateTime.now());
        params.put("password", password);

        return namedParameterTemplate.update(sql, params);
    }

    @Override
    public int delete(Long scheduleID, String password) {
        String sql = "delete from schedule " +
            "where scheduleID = :scheduleID and password = :password";
        Map<String, Object> params = new HashMap<>();
        params.put("scheduleID", scheduleID);
        params.put("password", password);

        return namedParameterTemplate.update(sql, params);
    }
}
