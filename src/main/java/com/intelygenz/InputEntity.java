package com.intelygenz;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "numbers")
public class InputEntity {

    @Id
    private String id;

    private int[] integers;

    public int[] getIntegers() {
        return integers;
    }

    public void setIntegers(int[] integers) {
        this.integers = integers;
    }
}
