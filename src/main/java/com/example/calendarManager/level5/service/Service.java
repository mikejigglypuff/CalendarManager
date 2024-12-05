package com.example.calendarManager.level5.service;

import java.util.List;
import java.util.NoSuchElementException;

public interface Service<T> {
    public void checkEmptyResult(List<T> result) throws NoSuchElementException;
}
