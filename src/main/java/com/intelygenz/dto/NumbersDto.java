package com.intelygenz.dto;

import javax.validation.constraints.NotBlank;

public class NumbersDto {
    private Long id;

    @NotBlank(message = "Integers is mandatory")
    private String integers;
}
