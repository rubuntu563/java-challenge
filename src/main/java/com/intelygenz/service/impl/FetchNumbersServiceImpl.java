package com.intelygenz.service.impl;

import com.intelygenz.model.Numbers;
import com.intelygenz.repository.NumbersRepository;
import com.intelygenz.service.BinaryNumberComparator;
import com.intelygenz.service.FetchNumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FetchNumbersServiceImpl implements FetchNumbersService {

    private final NumbersRepository numbersRepository;
    @Autowired
    public FetchNumbersServiceImpl(NumbersRepository numbersRepository){
        this.numbersRepository = numbersRepository;
    }

    @Cacheable("NumbersCache")
    public List<List<Integer>> getSortedNumbers(){
        List<Numbers> numbers = numbersRepository.findAll();
        return numbers.stream()
                .map(number -> sortByBinaryOnes(number))
                .collect(Collectors.toList());

    }

    public List<List<Integer>> getSortedNumbersById(List<Long> ids){
        List<Numbers> numbers = numbersRepository.findAllById(ids);
        return numbers.stream()
                .map(number -> sortByBinaryOnes(number))
                .collect(Collectors.toList());

    }
    private List<Integer> sortByBinaryOnes(Numbers numbers){

        List<Integer> integers = Arrays.stream(numbers.getIntegers().split(","))
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
        integers.sort(new BinaryNumberComparator());
        return integers;
    }

    @CacheEvict(value = "NumbersCache", key = "#id")
    public void deleteById(Long id) {
        numbersRepository.deleteById(id);
    }

    @CacheEvict(value = "NumbersCache", key = "#numbers.id")
    public Numbers save(Numbers numbers) {
        return numbersRepository.save(numbers);
    }
}
