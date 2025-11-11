package ui.steps;

import base.BaseTestUI;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebElement;
import ui.pages.AccountPage;

import java.math.BigDecimal;
import java.util.List;

public class AccountSteps extends BaseTestUI {
    private final AccountPage accountPage = new AccountPage(driver);

    @Step("Print all accounts")
    public void printAllAccounts() {
        printSelectedAccounts(accountPage.getAllAccounts());
    }

    @Step("Print customer accounts")
    public void printCustomerAccounts() {
        printSelectedAccounts(accountPage.getAccountsByCustomerId());
    }

    @Step("Enter customer id <customerId>")
    public void enterCustomerId(String customerId) {
        accountPage.enterCustomerId(customerId);
    }

    @Step("Create new account for customer")
    public void createNewAccount() {
        accountPage.clickCreateAccount();
    }

    @Step("Deposit amount <amount> to account <accountId>")
    public void depositAmount(String amount, String accountId) {
        BigDecimal newAmount = new BigDecimal(amount);
        accountPage.depositAccount(accountId, newAmount);
    }

    @Step("Activate account <accountId>")
    public void activateAccount(String accountId) {
        accountPage.activateAccount(accountId);
    }

    private void printSelectedAccounts(List<WebElement> accountList) {
        for (WebElement account : accountList) {
            System.out.println(account.getText());
        }
    }

}
