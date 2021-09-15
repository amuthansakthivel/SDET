package com.utils.zerocell;

import com.creditdatamw.zerocell.annotation.Column;
import com.utils.enums.BrowserType;

import java.time.LocalDate;
import java.util.List;

public class TestData {

    //POJO
    @Column(name = "testcase", index=0 )
    private String testcase;

    @Column(name = "browser", index=1 ,convertorClass = StringToBrowserTypeConverter.class)
    private BrowserType browser;

    @Column(name = "firstname", index=2 )
    private String firstname;

    @Column(name = "isFTE", index=3,convertorClass = StringToBooleanConverter.class )
    private boolean isFTE;

    @Column(name="age",index = 4,convertorClass = StringToIntegerConverter.class)
    private int age;

    @Column(name="date",index = 5,convertorClass = StringToLocalDateConverter.class)
    private LocalDate date;

    @Column(name="date",index = 6,convertorClass = PhoneNumberProcessor.class )
    private String phonenumber;

    @Column(name="list",index = 7,convertorClass = StringToListConverter.class )
    private List<String> list;

    @Override
    public String toString() {
        return "TestData{" +
                "testcase='" + testcase + '\'' +
                ", browser='" + browser + '\'' +
                ", firstname='" + firstname + '\'' +
                ", isFTE=" + isFTE +
                ", age=" + age +
                ", date=" + date +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
    public List<String> getList() {
        return list;
    }

    public String getTestcase() {
        return testcase;
    }

    public BrowserType getBrowser() {
        return browser;
    }

    public String getFirstname() {
        return firstname;
    }

    public boolean isFTE() {
        return isFTE;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
}
