package com.utils.zerocell;

import com.creditdatamw.zerocell.converter.Converter;
import com.utils.enums.BrowserType;

public class StringToBrowserTypeConverter implements Converter<BrowserType> {
    @Override
    public BrowserType convert(String s, String s1, int i) {

        return BrowserType.valueOf(s.toUpperCase());
    }
}
