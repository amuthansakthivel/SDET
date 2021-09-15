package com.tests.fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.utils.fixtures.Address;
import com.utils.fixtures.Employee;

import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        //Employee objects -->Create template --> Create an emp object using template

        /*Employee employee = new Employee(15, true, "testingminibytes", new Address("some st", "Chennai")
                , Arrays.asList("abcd"));*/



        Fixture.of(Employee.class).addTemplate("valid",new Rule(){{
            add("id",random(Integer.class,range(100,1000)));
            add("fname",random("testingminibytes","amuthan","udemy"));
            add("isFTE",random(true,false));
            add("roles",uniqueRandom(Arrays.asList("tester"),Arrays.asList("manager")));
            add("address",random(new Address("some str","Chennai")));
        }});

        List<Employee> valid = Fixture.from(Employee.class).gimme(10,"valid");
        valid.forEach(System.out::println);

    }
}
