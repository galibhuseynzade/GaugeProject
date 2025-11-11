package api.steps;

import api.models.response.AccountResponse;
import util.DataConverter;
import base.BaseTestAPI;
import com.thoughtworks.gauge.Step;
import config.ConfigReader;

import java.math.BigDecimal;

public class AccountSteps extends BaseTestAPI {
    private final String endpoint = ConfigReader.get("accountEndpoint");
    private static String accountId;

    @Step("Get all accounts")
    public void getAllAccounts() {
        response = newRequest()
                .when()
                .get(endpoint);

        accountResponseList = DataConverter.convertToList(response, AccountResponse.class);
    }

    @Step("Get all active accounts")
    public void getAllActiveAccounts() {
        response = newRequest()
                .when()
                .get(endpoint);

        accountResponseList = DataConverter.convertToList(response, AccountResponse.class);
    }

    @Step("Get accounts by customer id <customerId>")
    public void getAccountsByCustomerId(Integer customerId) {
        response = newRequest()
                .pathParam("customerId", customerId)
                .when()
                .get(endpoint + "/accountsByCustomerId/{customerId}");

        accountResponseList = DataConverter.convertToList(response, AccountResponse.class);
    }

    private AccountResponse createAccount(Integer customerId) {
        response = newRequest()
                .pathParam("customerId", customerId)
                .when()
                .post(endpoint + "/{customerId}");

        accountResponse = DataConverter.convertToObject(response, AccountResponse.class);
        accountId = accountResponse.getAccountNumber();
        return accountResponse;
    }

    private void activateAccount(String accountNumber) {
        accountId = accountNumber;

        response = newRequest()
                .pathParam("accountNumber", accountNumber)
                .when()
                .put(endpoint + "/activateAccount/{accountNumber}");
    }

    private void depositAccount(String accountNumber, BigDecimal amount) {
        accountId = accountNumber;
        response = newRequest()
                .pathParam("accountNumber", accountNumber)
                .queryParam("amount", amount)
                .when()
                .put(endpoint + "/depositAccount/{accountNumber}");
    }


    @Step("Create account for customer id <customerId>")
    public void createAccountByCustomerId(String customerId) {
        Integer customerIdInt = Integer.parseInt(customerId);
        accountResponse = createAccount(customerIdInt);
    }

    @Step("Create account for selected customer")
    public void createAccountForSelectedCustomer() {
        Integer customerId = customerResponse.getCustomerId();
        accountResponse = createAccount(customerId);
    }

    @Step("Activate account <accountNumber>")
    public void activateAccountByAccountId(String accountNumber) {
        accountId = accountNumber;
        activateAccount(accountId);
    }

    @Step("Activate selected account")
    public void activateAccountBySelectedAccount() {
        accountId = accountResponse.getAccountNumber();
        activateAccount(accountId);
    }

    @Step("Deposit <amount> amount to account <accountNumber>")
    public void depositAccountByAmount(String amount, String accountNumber) {
        accountId = accountNumber;
        BigDecimal amountInt = new BigDecimal(amount);
        depositAccount(accountId, amountInt);
    }

    @Step("Deposit <amount> to selected account")
    public void depositAccountBySelectedAccount(String amount) {
        accountId = accountResponse.getAccountNumber();
        BigDecimal amountInt = new BigDecimal(amount);
        depositAccount(accountId, amountInt);
    }

    @Step("Get last index of accounts")
    public void getLastIndexOfAccounts() {
        accountResponse = accountResponseList.get(accountResponseList.size() - 1);
        accountId = accountResponse.getAccountNumber();
    }

    @Step("Get first index of accounts")
    public void getFirstIndexOfAccounts() {
        accountResponse = accountResponseList.get(0);
        accountId = accountResponse.getAccountNumber();
    }
}

