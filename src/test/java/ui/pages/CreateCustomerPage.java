package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.LocatorReader;
import util.Waiter;

public class CreateCustomerPage {
    private final String page = "createCustomerPage";
    private final WebDriver driver;


    public CreateCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, CreateCustomerPage.this);
    }

    By firstName = LocatorReader.get(page, "firstName");
    By lastName = LocatorReader.get(page, "lastName");
    By birthDate = LocatorReader.get(page, "birthDate");
    By finCode = LocatorReader.get(page, "finCode");
    By phoneNumber = LocatorReader.get(page, "phoneNumber");
    By email = LocatorReader.get(page, "email");
    By createButton = LocatorReader.get(page, "createButton");
    By cancelButton = LocatorReader.get(page, "cancelButton");

    public void createCustomer(
            String firstName,
            String lastName,
            String birthDate,
            String finCode,
            String phoneNumber,
            String email
    ) {
        Waiter.untilVisible(this.firstName).sendKeys(firstName);
        Waiter.untilVisible(this.lastName).sendKeys(lastName);
        Waiter.untilVisible(this.birthDate).sendKeys(birthDate);
        Waiter.untilVisible(this.finCode).sendKeys(finCode);
        Waiter.untilVisible(this.phoneNumber).sendKeys(phoneNumber);
        Waiter.untilVisible(this.email).sendKeys(email);
        Waiter.untilVisible(this.createButton).click();
    }

    public void cancel() {
        Waiter.untilClickable(this.cancelButton).click();
    }
}
