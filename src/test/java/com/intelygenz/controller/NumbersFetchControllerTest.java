package com.intelygenz.controller;

import com.intelygenz.api.v1.controller.NumbersFetchController;
import com.intelygenz.service.FetchNumbersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@ExtendWith(SpringExtension.class)
@WebMvcTest(NumbersFetchController.class)
public class NumbersFetchControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FetchNumbersService fetchNumbersService;

    @Test
    void when_no_parameters_numbersorted_should_return_OK() throws Exception {
        when(fetchNumbersService.getSortedNumbers()).thenReturn(new ArrayList<>());

        this.mockMvc.perform(get("/api/v1/numbersSorted")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void when_invalid_id_should_return_not_found_error() throws Exception {

        when(fetchNumbersService.getSortedNumbersById((any()))).thenReturn(new ArrayList<>());

        this.mockMvc.perform(
                get("/api/v1/numbers")
                .param("numberIds", "KO")
                )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
