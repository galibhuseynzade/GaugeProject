package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.LocatorReader;
import util.Waiter;

public class HomePage {
    private final String page = "homePage";
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By logoutButton        = LocatorReader.get(page, "logoutButton");
    By settingsButton      = LocatorReader.get(page, "settingsButton");
    By customersButton     = LocatorReader.get(page, "customersButton");
    By accountsButton      = LocatorReader.get(page, "accountsButton");
    By cardsButton         = LocatorReader.get(page, "cardsButton");
    By transactionsButton  = LocatorReader.get(page, "transactionsButton");
    By usersButton         = LocatorReader.get(page, "usersButton");
    By dashboardButton     = LocatorReader.get(page, "dashboardButton");

    public void clickLogoutButton() {
        Waiter.untilClickable(logoutButton).click();
    }
    public void clickSettingsButton() {
        Waiter.untilVisible(settingsButton).click();
    }
    public void clickCustomersButton() {
        Waiter.untilClickable(customersButton).click();
    }
    public void clickAccountsButton() {
        Waiter.untilClickable(accountsButton).click();
    }
    public void clickCardsButton() {
        Waiter.untilClickable(cardsButton).click();
    }
    public void clickTransactionsButton() {
        Waiter.untilClickable(transactionsButton).click();
    }
    public void clickUsersButton() {
        Waiter.untilClickable(usersButton).click();
    }
    public void clickDashboardButton() {
        Waiter.untilClickable(dashboardButton).click();
    }
}
