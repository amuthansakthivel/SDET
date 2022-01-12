package com.tests.testdatasupplier;

import com.utils.testdatasupplier.entity.User;
import com.utils.zerocell.TestData;
import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.CsvReader;
import io.github.sskorol.data.XlsxReader;
import one.util.streamex.StreamEx;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import static io.github.sskorol.data.TestDataReader.use;

public class Runner {

    @Test(dataProvider = "getData")
    public void testDemo(int a, int b, int c) {
        System.out.println(a);
    }

    @DataSupplier(transpose = true)
    public Stream<Integer> getData(){
        return StreamEx.of(1,2,3); //3*1 -> 1*3
    }


    @Test(dataProvider = "getDataFromCSV")
    public void testCSV(User user) {
        System.out.println(user);
    }

    @DataSupplier(runInParallel = true)
    public StreamEx<User> getDataFromCSV() throws IOException {
        return use(CsvReader.class)
                .withTarget(User.class)
                .withSource("testdata.csv")
                .read()
                .limit(2);
    }

    @Test(dataProvider = "getDataAsFlatMap")
    public void supplyNestedArrayData(String data,String data1) {
        System.out.println(data);
        System.out.println(data1);
    }

    @DataSupplier(flatMap = true)
    public Stream<String[]> getDataAsFlatMap(){
        return Stream
                .of("Testing","Automation","Testingminibytes")
                .map(e->new String[]{e, e+"test"});
    }


    @Test(dataProvider = "getDataFromExcel")
    public void testcase2(TestData testData) {
        System.out.println(testData);
    }

    @DataSupplier
    public StreamEx<TestData> getDataFromExcel(Method method){
        return use(XlsxReader.class)
                .withTarget(TestData.class)
                .withSource("testdata.xlsx")
                .read();
    }
}
