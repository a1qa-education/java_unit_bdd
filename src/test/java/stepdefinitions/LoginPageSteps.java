package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utils.TestDataReader;

public class LoginPageSteps {

    private final LoginPage loginPage = new LoginPage();

    @Then("the 'Form Authentication' page is open")
    public void theFormAuthenticationPageIsOpen() {
        Assert.assertTrue(loginPage.state().waitForDisplayed(), "Form Authentication page is not open");
    }

    @When("I log in with valid credentials")
    public void iLoginWithValidCredentials() {
        loginPage.login(TestDataReader.getUserData().getUsername(), TestDataReader.getUserData().getPassword());
    }
}
