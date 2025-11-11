package base;

import api.models.response.AccountResponse;
import api.models.response.CustomerResponse;
import com.thoughtworks.gauge.BeforeSpec;
import config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BaseTestAPI {
    protected static RequestSpecification request;
    protected static Response response;
    protected static CustomerResponse customerResponse;
    protected static List<CustomerResponse> customerResponseList;
    protected static AccountResponse accountResponse;
    protected static List<AccountResponse> accountResponseList;

    protected RequestSpecification newRequest(){
        return given().spec(request);
    }

    @BeforeSpec
    public void setUp() {
        request = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("baseUrl"))
                .addHeader("Authorization", "Bearer " + getToken())
                .build();
    }

    private String getToken() {
        return given().contentType("application/x-www-form-urlencoded")
                .formParam("username", "admin")
                .formParam("password", "admin")
                .when()
                .post("/api/v1/auth/login")
                .then()
                .statusCode(200)
                .extract().body().jsonPath().getString("token");
    }
}
