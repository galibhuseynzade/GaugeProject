package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import util.LocatorReader;
import util.Waiter;

public class LoginPage {
    private final String page = "loginPage";
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By username = LocatorReader.get(page, "username");
    By password = LocatorReader.get(page, "password");
    By loginButton = LocatorReader.get(page, "loginButton");

    public void enterUsername(String username) {
        Waiter.untilVisible(this.username).sendKeys(username);
    }

    public void enterPassword(String password) {
        Waiter.untilVisible(this.password).sendKeys(password);
    }

    public void clickLoginButton() {
        Waiter.untilClickable(this.loginButton).click();
    }
}
