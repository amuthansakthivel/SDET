package com.utils.zerocell;

import com.creditdatamw.zerocell.annotation.Column;
import com.utils.enums.BrowserType;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
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

}
