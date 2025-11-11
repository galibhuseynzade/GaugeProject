package ui.steps;

import base.BaseTestUI;
import com.thoughtworks.gauge.Step;
import ui.pages.HomePage;

public class HomeSteps extends BaseTestUI {
    private final HomePage homePage = new HomePage(driver);

    @Step("Navigate to dashboard")
    public void navigateToDashboard() {
        homePage.clickDashboardButton();
    }

    @Step("Navigate to customers page")
    public void navigateToCustomersPage() {
        homePage.clickCustomersButton();
    }

    @Step("Navigate to accounts page")
    public void navigateToAccountsPage() {
        homePage.clickAccountsButton();
    }

    @Step("Logout")
    public void logout() {
        homePage.clickLogoutButton();
    }
}
