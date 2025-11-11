package util;

import config.ConfigReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    private static final WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Integer.parseInt(ConfigReader.get("explicitWait"))));

    public static WebElement untilVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static WebElement untilClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static Alert untilAlertPresent() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
