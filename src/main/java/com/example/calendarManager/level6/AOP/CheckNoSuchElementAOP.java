package com.example.calendarManager.level6.AOP;

import com.example.calendarManager.level6.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level6.exception.NoMatchScheduleException;
import com.example.calendarManager.level6.exception.NoMatchWriterException;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
// 코드 분리: 퀴리 결과가 빈 값인지를 검증하는 로직
public class CheckNoSuchElementAOP {
    @AfterReturning(
        pointcut = "execution(* com.example.calendarManager.*.repository.JDBCTemplateScheduleRepository.find*(..))" +
            " && !execution(* com.example.calendarManager.*.repository.JDBCTemplateScheduleRepository.findOne(..))",
        returning = "result"
    )
    public void checkEmptyScheduleResult(List<ScheduleGetResponseDTO> result) throws NoMatchScheduleException {
        if (result.isEmpty()) throw new NoMatchScheduleException();
    }

    @AfterReturning(
        pointcut = "execution(* com.example.calendarManager.*.repository.JDBCTemplateScheduleRepository.*(..))" +
            " && !execution(* com.example.calendarManager.*.repository.JDBCTemplateScheduleRepository.find*(..))",
        returning = "result"
    )
    public void hasAffectedSchedule(int result) throws NoMatchScheduleException {
        if (result == 0) throw new NoMatchScheduleException();
    }

    @AfterReturning(
        pointcut = "execution(* com.example.calendarManager.*.repository.JDBCTemplateWriterRepository.*(..))" +
            " && !execution(* com.example.calendarManager.*.repository.JDBCTemplateWriterRepository.find*(..))",
        returning = "result"
    )
    public void hasAffectedWriter(int result) throws NoMatchWriterException {
        if (result == 0) throw new NoMatchWriterException();
    }

    @AfterThrowing(
        pointcut = "execution(* com.example.calendarManager.*.repository.JDBCTemplateScheduleRepository.findOne(..))",
        throwing = "e"
    )
    public void checkNotOneSchedule(IncorrectResultSizeDataAccessException e) throws NoMatchScheduleException {
        if (e.getActualSize() == 0) throw new NoMatchScheduleException();
    }

    @AfterThrowing(
        pointcut = "execution(* com.example.calendarManager.*.repository.JDBCTemplateWriterRepository.findOne(..))",
        throwing = "e"
    )
    public void checkNotOneWriter(IncorrectResultSizeDataAccessException e) throws NoMatchWriterException {
        if (e.getActualSize() == 0) throw new NoMatchWriterException();
    }
}
