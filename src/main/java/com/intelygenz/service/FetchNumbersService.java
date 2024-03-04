package com.intelygenz.service;

import com.intelygenz.model.Numbers;

import java.util.List;

public interface FetchNumbersService {
    List<List<Integer>> getSortedNumbers();
    List<List<Integer>> getSortedNumbersById(List<Long> ids);
    void deleteById(Long id);
    Numbers save(Numbers numbers);
}
