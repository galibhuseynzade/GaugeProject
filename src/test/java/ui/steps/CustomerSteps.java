package ui.steps;

import base.BaseTestUI;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebElement;
import ui.models.CustomerData;
import ui.pages.CreateCustomerPage;
import ui.pages.CustomerPage;
import util.DataConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CustomerSteps extends BaseTestUI {
    private final CustomerPage customerPage = new CustomerPage(driver);
    private final CreateCustomerPage createCustomerPage = new CreateCustomerPage(driver);

    @Step("Click create customer button")
    public void clickCreateCustomerButton() {
        customerPage.clickCreateCustomer();
    }

    @Step("Create customer using data from <filename>")
    public void createCustomerUsingDataFrom(String filename) throws IOException {
        String file = Files.readString(Paths.get("src/test/resources/data/" + filename));
        CustomerData customerData = DataConverter.convertFromJson(file, CustomerData.class);
        createCustomerPage.createCustomer(
                customerData.getFirstName(),
                customerData.getLastName(),
                customerData.getBirthDate().toString(),
                customerData.getFinCode(),
                customerData.getPhoneNumber(),
                customerData.getEmail()
        );
    }

    @Step("Cancel customer creation")
    public void cancelCustomerCreation() {
        createCustomerPage.cancel();
    }

    @Step("Print all customers")
    public void printAllCustomers() {
        List<WebElement> customerList = customerPage.getCustomerList();
        for (WebElement customer : customerList) {
            System.out.println(customer.getText());
        }
    }
}
