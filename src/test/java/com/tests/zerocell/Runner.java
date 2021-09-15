package com.tests.zerocell;

import com.creditdatamw.zerocell.Reader;
import com.utils.zerocell.TestData;

import java.io.File;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<TestData> testdatas = Reader.of(TestData.class)
                .from(new File("testdata.xlsx"))
                .sheet("Sheet1")
                .skipHeaderRow(true)
                .list();

        testdatas.forEach(System.out::println);
    }
}
