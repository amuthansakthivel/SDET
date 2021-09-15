package com.tests.fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.utils.fixtures.Employee;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PostEmployeeTests {

    @BeforeSuite
    public void setUp() {
        FixtureFactoryLoader.loadTemplates("com.utils.templates");
    }

    @DataProvider(parallel = true)
    public static Object[][] getData() {
        Employee valid = Fixture.from(Employee.class).gimme("valid");
        Employee invalidid = Fixture.from(Employee.class).gimme("invalidid");
        Employee invalidfname = Fixture.from(Employee.class).gimme("invalidfname");
        return new Object[][]{
                {valid,201},
                {invalidid,500},
                {invalidfname,201}
        };
    }

    @Test(dataProvider = "getData")
    public void postEmployeeTestUsingFixture(Employee employee,int statuscode) {

        Response response = given().contentType(ContentType.JSON)
                .log()
                .all()
                .body(employee) //jackson
                .post("http://localhost:3000/employees");

        Assert.assertEquals(response.getStatusCode(),statuscode);

    }
}
