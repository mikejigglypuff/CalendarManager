package com.example.calendarManager.level5.AOP;

import com.example.calendarManager.level5.DTO.responseDTO.ScheduleGetResponseDTO;
import com.example.calendarManager.level5.exception.NoMatchScheduleException;
import com.example.calendarManager.level5.exception.NoMatchWriterException;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class CheckNoSuchElementAOP {
    @AfterReturning(
        pointcut = "execution(* com.example.calendarManager.*.repository.JDBCTemplateScheduleRepository.find*(..))" +
            " && !execution(* com.example.calendarManager.*.repository.JDBCTemplateScheduleRepository.findOne(..))",
        returning = "result"
    )
    public void checkEmptyScheduleResult(List<ScheduleGetResponseDTO> result) throws NoMatchScheduleException{
        if(result.isEmpty()) throw new NoMatchScheduleException();
    }

    @AfterReturning(
        pointcut = "execution(* com.example.calendarManager.*.repository.JDBCTemplateWriterRepository.*(..))" +
            " && !execution(* com.example.calendarManager.*.service.ScheduleService.get*(..))",
        returning = "result"
    )
    public void hasAffectedSchedule(int result) throws NoMatchScheduleException {
        if(result == 0) throw new NoMatchScheduleException();
    }

    @AfterReturning(
        pointcut = "execution(* com.example.calendarManager.*.repository.JDBCTemplateWriterRepository.*(..))" +
            " && !execution(* com.example.calendarManager.*.service.ScheduleService.get*(..))",
        returning = "result"
    )
    public void hasAffectedWriter(int result) throws NoMatchWriterException {
        if(result == 0) throw new NoMatchWriterException();
    }

    @AfterThrowing(
        pointcut = "execution(* com.example.calendarManager.*.repository.JDBCTemplateScheduleRepository.findOne(..))",
        throwing = "e"
    )
    public void checkNotOneSchedule(IncorrectResultSizeDataAccessException e) throws NoMatchScheduleException {
        if(e.getActualSize() == 0) throw new NoMatchScheduleException();
        // 결과값이 2개 이상인 경우에 대해서 따로 처리하도록 구현하기
    }

    @AfterThrowing(
        pointcut = "execution(* com.example.calendarManager.*.repository.JDBCTemplateWriterRepository.findOne(..))",
        throwing = "e"
    )
    public void checkNotOneWriter(IncorrectResultSizeDataAccessException e) throws NoMatchWriterException {
        if(e.getActualSize() == 0) throw new NoMatchWriterException();
        // 결과값이 2개 이상인 경우에 대해서 따로 처리하도록 구현하기
    }
}
