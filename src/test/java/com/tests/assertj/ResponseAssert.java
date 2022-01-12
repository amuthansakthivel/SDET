package com.tests.assertj;

import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {

    private ResponseAssert(Response response, Class<?> selfType) {
        super(response, selfType);
    }

    public static ResponseAssert assertThat(Response response){
        return new ResponseAssert(response,ResponseAssert.class);
    }

    public ResponseAssert isSuccessfulPostResponse(){ //response
        Assertions.assertThat(actual.getStatusCode())
                .as("Status code assertion")
                .withFailMessage(() -> "Status code is neither 200 nor 201")
                .isBetween(200, 201);

        return this;
    }
    public ResponseAssert hasHeaderApplicationJson(){
        Assertions
                .assertThat(actual.header("Content-Type"))
                .withFailMessage(()->"Header with Content Type as Application/json is not present")
                .contains("application/json");
        return this;
    }
    public ResponseAssert hasHeaderCacheControlWithValueNoCache(){
        Assertions
                .assertThat(actual.header("Cache-Control"))
                .withFailMessage(()->"Header with Cache-Control is not having no cache value")
                .contains("no-cache");
        return this;
    }
}
