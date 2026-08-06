package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utils.TestDataReader;

public class LoginPageSteps {

    private final LoginPage loginPage = new LoginPage();

    @Then("the {string} page is open")
    public void thePageIsOpen(String pageName) {
        if (pageName.equals("Form Authentication")) {
            Assert.assertTrue(loginPage.state().waitForDisplayed(), pageName + " page is not open");
        }
    }

    @When("I log in with valid credentials")
    public void iLoginWithValidCredentials() {
        loginPage.login(TestDataReader.getUserData().getUsername(), TestDataReader.getUserData().getPassword());
    }
}
