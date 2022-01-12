package com.utils.zerocell;

import com.creditdatamw.zerocell.converter.Converter;

import java.util.Arrays;
import java.util.List;

public class StringToListConverter implements Converter<List<String>> {
    @Override
    public List<String> convert(String strings, String s1, int i) {

        return Arrays.asList(strings.split(","));
    }
}
