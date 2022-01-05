package com.tests.assertj;

import com.utils.assertj.entity.Person;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import java.util.List;

public class PersonAssert extends AbstractAssert<PersonAssert, Person> {

    private PersonAssert(Person person, Class<?> selfType) {
        super(person, selfType);
    }

    public static PersonAssert assertThat(Person person){
        return new PersonAssert(person,PersonAssert.class);
    }

    public PersonAssert hasName(String name){
        Assertions.assertThat(actual)
                .extracting(Person::getFirstname)
                .withFailMessage(()->"Name is not matching")
                .isEqualTo(name);
        return this;
    }
    public PersonAssert hasJobMatching(List<String> jobs){
        Assertions.assertThat(actual.getJobs())
                .withFailMessage(()->"Size is not matching")
                .hasSize(jobs.size())
                .isEqualTo(jobs);
        return this;
    }
}
