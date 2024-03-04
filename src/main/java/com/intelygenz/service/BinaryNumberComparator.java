package com.intelygenz.service;

import org.springframework.util.StringUtils;

import java.util.Comparator;

public class BinaryNumberComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer int1, Integer int2) {
        String bin1 = Integer.toBinaryString(int1);
        String bin2 = Integer.toBinaryString(int2);
        int count1 = StringUtils.countOccurrencesOf(bin1,"1");
        int count2 = StringUtils.countOccurrencesOf(bin2,"1");
        if(count1 == count2){
            return int1.compareTo(int2);
        }
        else{
            return ((Integer) count2).compareTo(count1);
        }
    }
}
