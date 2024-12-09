package com.example.calendarManager.level6.repository;

import com.example.calendarManager.level6.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level6.domain.Schedule;
import com.example.calendarManager.level6.mapper.ScheduleGetResponseDTORowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
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
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(schedule);

        return namedParameterTemplate.update("insert into schedule (works, writerID, password, createdAt, updatedAt)"
            + " values (:works, :writerID, :password, :createdAt, :updatedAt)", paramSource);
    }

    @Override
    public ScheduleGetResponseDTO findOne(Map<String, Object> param) {
        return namedParameterTemplate.queryForObject(
            "select * from schedule where scheduleID = :scheduleID", param, dtoRowMapper);
    }

    @Override
    public List<ScheduleGetResponseDTO> findAll() {
        return template.query("select * from schedule", dtoRowMapper);
    }

    @Override
    public List<ScheduleGetResponseDTO> findAll(Pageable pageable, Map<String, Object> param) {
        return namedParameterTemplate.query(
            "select * from schedule limit :limit offset :offset", param, dtoRowMapper);
    }

    @Override
    public List<ScheduleGetResponseDTO> findByWriterID(Map<String, Object> param) {
        return namedParameterTemplate.query(
            "select * from schedule where writerID = :writerID", param, dtoRowMapper);
    }

    @Override
    public List<ScheduleGetResponseDTO> findByUpdatedAt(Map<String, Object> param) {
        return namedParameterTemplate.query(
            "select * from schedule where updatedAt > :updatedAt", param, dtoRowMapper);
    }

    @Override
    public List<ScheduleGetResponseDTO> findByWriterIDAndUpdatedAt(Map<String, Object> param) {
        return namedParameterTemplate.query(
            "select * from schedule where writerID = :writerID and updatedAt > :updatedAt", param, dtoRowMapper);
    }

    @Override
    public int updateWorks(Map<String, Object> param) {
        return namedParameterTemplate.update(
            "update schedule set works = :works, updatedAt = :updatedAt" +
                " where password = :password", param);
    }

    @Override
    public int updateWriterID(Map<String, Object> param) {
        return namedParameterTemplate.update(
            "update schedule set writerID=:writerID, updatedAt = :updatedAt" +
                " where password = :password", param);
    }

    @Override
    public int updateWorksAndWriterID(Map<String, Object> param) {
        return namedParameterTemplate.update(
            "update schedule set works=:works, writerID=:writerID, updatedAt = :updatedAt"
                + " where password = :password", param);
    }

    @Override
    public int delete(Map<String, Object> param) {
        return namedParameterTemplate.update("delete from schedule " +
            "where scheduleID = :scheduleID and password = :password", param);
    }
}
