package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SecureAreaPage;

public class SecureAreaPageSteps {

    private final SecureAreaPage secureAreaPage = new SecureAreaPage();

    @Then("the Secure Area page should be open")
    public void theSecureAreaPageShouldBeOpen() {
        Assert.assertTrue(secureAreaPage.state().waitForDisplayed(), "Secure area page is not open");
    }

    @Then("the successful login message {string} is displayed")
    public void theSuccessfulLoginMessageIsDisplayed(String message) {
        Assert.assertTrue(secureAreaPage.getSuccessMessageText().contains(message), "Successful login message is not displayed");
    }

    @When("I click logout")
    public void iClickLogout() {
        secureAreaPage.clickLogout();
    }
}
