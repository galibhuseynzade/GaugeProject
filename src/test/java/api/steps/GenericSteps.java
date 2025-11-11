package api.steps;

import base.BaseTestAPI;
import com.thoughtworks.gauge.Step;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

public class GenericSteps extends BaseTestAPI {
    @Step("Status code must be <statusCode>")
    public void checkStatusCode(String statusCode) {
        response.then().assertThat().statusCode(Integer.parseInt(statusCode));
    }

    @Step("Content type must be <contentType>")
    public void checkContentType(String contentType) {
        contentType = contentType.toUpperCase();
        ContentType type;
        switch (contentType) {
            case "JSON" -> type = ContentType.JSON;
            case "XML" -> type = ContentType.XML;
            case "TEXT" -> type = ContentType.TEXT;
            case "HTML" -> type = ContentType.HTML;
            default -> throw new IllegalArgumentException("Invalid content type: " + contentType);
        }
        response.then().assertThat().contentType(type);
    }

    @Step("Response time must be under <ms>")
    public void checkResponseTime(Long ms) {
        response.then().assertThat().time(lessThan(ms));
    }

    @Step("Field <field> cannot be null")
    public void checkFieldIsNotNull(String field) {
        response.then().body(field, notNullValue());
    }
}
