package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utils.TestDataReader;

public class LoginPageSteps {

    private final LoginPage loginPage = new LoginPage();

    @Then("the Form Authentication page should be open")
    public void theFormAuthenticationPageShouldBeOpen() {
        Assert.assertTrue(loginPage.state().waitForDisplayed(), "Form Authentication page is not open");
    }

    @When("I login with valid credentials")
    public void iLoginWithValidCredentials() {
        loginPage.login(TestDataReader.getUserData().getUsername(), TestDataReader.getUserData().getPassword());
    }

    @Then("the Form Authentication page should be open after logout")
    public void theFormAuthenticationPageShouldBeOpenAfterLogout() {
        Assert.assertTrue(loginPage.state().waitForDisplayed(), "Form Authentication page is not open after logout");
    }
}
