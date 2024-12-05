package com.example.calendarManager.level5.repository;

import com.example.calendarManager.level5.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level5.domain.Schedule;
import com.example.calendarManager.level5.mapper.ScheduleGetResponseDTORowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
        String sql = "insert into schedule (works, writerID, password, createdAt, updatedAt)"
            + " values (:works, :writerID, :password, :createdAt, :updatedAt)";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(schedule);

        return namedParameterTemplate.update(sql, paramSource);
    }

    @Override
    public ScheduleGetResponseDTO findOne(Long scheduleID) {
        String sql = "select * from schedule where scheduleID = :scheduleID";
        Map<String, Object> params = new HashMap<>();
        params.put("scheduleID", scheduleID);

        return namedParameterTemplate.queryForObject(sql, params, dtoRowMapper);
    }

    @Override
    public List<ScheduleGetResponseDTO> findAll() {
        String sql = "select * from schedule";
        return template.query(sql, dtoRowMapper);
    }

    @Override
    public List<ScheduleGetResponseDTO> findAll(Pageable pageable) {
        String sql = "select * from schedule limit :limit offset :offset";
        Map<String, Object> params = new HashMap<>();
        params.put("limit", pageable.getPageSize());
        params.put("offset", pageable.getOffset());

        return namedParameterTemplate.query(sql, params, dtoRowMapper);
    }

    @Override
    public List<ScheduleGetResponseDTO> findByWriterID(Long writerID) {
        String sql = "select * from schedule where writerID = :writerID";
        Map<String, Object> params = new HashMap<>();
        params.put("writerID", writerID);

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
    public List<ScheduleGetResponseDTO> findByWriterIDAndUpdatedAt(Long writerID, LocalDate updatedAt) {
        String sql = "select * from schedule where writerID = :writerID and updatedAt > :updatedAt";
        Map<String, Object> params = new HashMap<>();
        params.put("writerID", writerID);
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
    public int updateWriterID(String password, Long writerID) {
        String sql = "update schedule set writerID=:writerID, updatedAt = :updatedAt" +
            " where password = :password";
        Map<String, Object> params = new HashMap<>();
        params.put("writerID", writerID);
        params.put("updatedAt", LocalDateTime.now());
        params.put("password", password);

        return namedParameterTemplate.update(sql, params);
    }

    @Override
    public int updateWorksAndWriterID(String password, String works, Long writerID) {
        String sql = "update schedule set works=:works, writerID=:writerID, updatedAt = :updatedAt"
            + " where password = :password";
        Map<String, Object> params = new HashMap<>();
        params.put("works", works);
        params.put("writerID", writerID);
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
