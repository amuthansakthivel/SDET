package com.tests.optional;

import com.utils.assertj.entity.Person;
import org.testng.annotations.Test;

import java.util.Optional;

public class UseCase3Test {

    @Test
    public void testOptionalInGetters() {
        Person person = Person.builder().build(); //response --> reponse.as(Person.class);
        System.out.println(person.getFirstname());


    }
}
