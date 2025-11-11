package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.LocatorReader;
import util.Waiter;

import java.math.BigDecimal;
import java.util.List;

public class AccountPage {
    private final String page = "accountPage";
    private final WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By listAllAccountsButton = LocatorReader.get(page, "listAllAccountsButton");
    By listAccountsByCustomerButton = LocatorReader.get(page, "listAccountsByCustomerButton");
    By createAccountButton = LocatorReader.get(page, "createAccountButton");
    By accountList = LocatorReader.get(page, "accountList");
    By enterCustomerId = LocatorReader.get(page, "enterCustomerId");

    public List<WebElement> getAllAccounts() {
        Waiter.untilClickable(listAllAccountsButton).click();
        return driver.findElements(accountList);
    }

    public void enterCustomerId(String customerId) {
        Waiter.untilVisible(enterCustomerId).sendKeys(customerId);
    }

    public List<WebElement> getAccountsByCustomerId() {
        Waiter.untilClickable(listAccountsByCustomerButton).click();
        return driver.findElements(accountList);
    }

    public void clickCreateAccount() {
        Waiter.untilClickable(createAccountButton).click();
    }

    public void depositAccount(String accountId, BigDecimal amount) {
        By amountBox = By.xpath("//input[@id='amount-" + accountId + "']");
        By depositButton = By.xpath("//button[@onclick=\"depositAccount('" +
                accountId +
                "')\"]");
        Waiter.untilVisible(amountBox).sendKeys(String.valueOf(amount));
        Waiter.untilClickable(depositButton).click();
    }

    public void activateAccount(String accountId) {
        By activateButton = By.xpath("//button[@onclick=\"activateAccount('" +
                accountId +
                "')\"]");
        Waiter.untilClickable(activateButton).click();
    }
}
