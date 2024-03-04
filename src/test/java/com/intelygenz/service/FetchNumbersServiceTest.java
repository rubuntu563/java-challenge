package com.intelygenz.service;

import com.intelygenz.model.Numbers;
import com.intelygenz.repository.NumbersRepository;
import com.intelygenz.service.impl.FetchNumbersServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {FetchNumbersService.class})
public class FetchNumbersServiceTest {

    @MockBean
    private NumbersRepository numbersRepository;

    private FetchNumbersService service;

    @BeforeEach
    void setUp(){
        this.service = new FetchNumbersServiceImpl(numbersRepository);
    }


    @Test
    void get_sorted_numbers_no_parameters_OK(){
        List<Numbers> numbers = new ArrayList<>();
        Numbers numbers1 = Numbers.builder().id(1L).integers("1,2,3,4").build();
        numbers.add(numbers1);
        when(numbersRepository.findAll()).thenReturn(numbers);
        List<List<Integer>> response = this.service.getSortedNumbers();
        Assertions.assertNotNull(response);
        List<Integer> listInt = response.get(0);
        Assertions.assertEquals(3, listInt.get(0));
        Assertions.assertEquals(1, listInt.get(1));
        Assertions.assertEquals(2, listInt.get(2));
        Assertions.assertEquals(4, listInt.get(3));

    }

    @Test
    void when_no_results_ok(){
        List<Numbers> numbers = new ArrayList<>();
        when(numbersRepository.findAllById(any())).thenReturn(numbers);
        List<List<Integer>> response = this.service.getSortedNumbersById(new ArrayList<>());
        Assertions.assertNotNull(response);
    }


}
