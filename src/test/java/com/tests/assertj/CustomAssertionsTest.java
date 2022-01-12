package com.tests.assertj;

import com.utils.assertj.entity.FavFoods;
import com.utils.assertj.entity.Person;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CustomAssertionsTest {

    @Test
    public void testName() {
        FavFoods foods = FavFoods.builder().breakfast("idly").dinner(List.of("chicken", "eggs")).build();
        Person person = Person.builder().firstname("abcdef").jobs(List.of("xyz", "qwe")).favFoods(foods).build();

        Response response = given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(person)
                .post("http://localhost:3000/person");

        response.prettyPrint();
        Person responsePerson = response.as(Person.class);

        ResponseAssert
                .assertThat(response)
                .isSuccessfulPostResponse()
                .hasHeaderApplicationJson()
                .hasHeaderCacheControlWithValueNoCache();

        PersonAssert.assertThat(responsePerson)
                .hasName("abcdef")
                .hasJobMatching(List.of("xyz", "qwe"));
    }
}
