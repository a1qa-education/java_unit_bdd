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

    @Then("the success message is displayed")
    public void theSuccessMessageIsDisplayed() {
        Assert.assertTrue(secureAreaPage.getSuccessMessageText().contains("You logged into a secure area!"), "Successful login message is not displayed");
    }

    @When("I log out")
    public void iLogOut() {
        secureAreaPage.clickLogout();
    }
}
