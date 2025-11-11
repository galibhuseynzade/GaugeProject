package base;

import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;
import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import ui.pages.LoginPage;
import util.DriverManager;

public class BaseTestUI {
    protected static WebDriver driver;

    @BeforeSpec
    public static void setup() {
        driver = DriverManager.getDriver();
        driver.get(ConfigReader.get("baseUrl") + "/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(ConfigReader.get("adminUser"));
        loginPage.enterPassword(ConfigReader.get("adminUser"));
        loginPage.clickLoginButton();
    }

    @AfterSpec
    public static void tearDown() {
        DriverManager.quitDriver();
    }
}
