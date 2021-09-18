package com.utils.fixtures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
@Getter
@NoArgsConstructor
public class Employee {

    private int id;
    private boolean isFTE;
    private String fname;
    private Address address;
    private List<String> roles;


}
