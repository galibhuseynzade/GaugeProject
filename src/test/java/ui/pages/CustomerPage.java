package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.LocatorReader;
import util.Waiter;

import java.util.List;

public class CustomerPage {
    private final String page = "customerPage";
    private final WebDriver driver;

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By createCustomerButton = LocatorReader.get(page, "createCustomerButton");
    By customerList = LocatorReader.get(page, "customerList");

    public void clickCreateCustomer() {
        Waiter.untilClickable(createCustomerButton).click();
    }

    public List<WebElement> getCustomerList() {
        return driver.findElements(customerList);
    }
}
