package api.steps;

import api.models.request.CustomerRequest;
import api.models.response.CustomerResponse;
import util.DataConverter;
import base.BaseTestAPI;
import com.thoughtworks.gauge.Step;
import config.ConfigReader;
import io.restassured.http.ContentType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomerSteps extends BaseTestAPI {
    private final String endpoint = ConfigReader.get("customerEndpoint");

    @Step("Create customer <filename>")
    public void createCustomer(String filename) throws IOException {
        String file = Files.readString(Paths.get("src/test/resources/data/" + filename));

        CustomerRequest body = DataConverter.convertFromJson(file, CustomerRequest.class);

        response = newRequest()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint);

        customerResponse = DataConverter.convertToObject(response, CustomerResponse.class);
    }

    @Step("Get all customers")
    public void getAllCustomers() {
        response = newRequest()
                .when()
                .get(endpoint);

        customerResponseList = DataConverter.convertToList(response, CustomerResponse.class);
    }
}
