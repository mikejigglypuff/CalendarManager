package com.example.calendarManager.level6.AOP;

import com.example.calendarManager.level6.exception.QueryException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;

@Aspect
@Slf4j
@Component
@Order(2)
public class RepositoryThrowableWrapperAOP {
    @AfterThrowing(
        pointcut = "execution(* com.example.calendarManager.level6.repository.*.*(..))",
        throwing = "e"
    )
    public void ThrowableWrapping(Throwable e) throws Throwable {
        // JDBC 쿼리 수행 시에 데이터 무결성 에러는 DataIntegrityViolationException로 처리되는 것이 일반적이기에
        // SQLIntegrityConstraintViolationException가 발생하는 경우 DataIntegrityViolationException로 래핑
        if (e instanceof SQLIntegrityConstraintViolationException || e instanceof DataIntegrityViolationException) {
            throw new DataIntegrityViolationException("데이터 일관성 에러");
        } else if (e instanceof SQLSyntaxErrorException se) {
            throw new QueryException("SQL 문법 에러");
        } else if (e instanceof SQLException)
            throw new QueryException("알 수 없는 에러");

        throw e;
    }
}
