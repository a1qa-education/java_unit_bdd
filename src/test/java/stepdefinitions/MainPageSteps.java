package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.MainPage;
import org.testng.Assert;

public class MainPageSteps {

    private final MainPage mainPage = new MainPage();

    @Given("the main page is open")
    public void theMainPageIsOpen() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page is not open");
    }

    @When("I navigate to the {string} page")
    public void iNavigateToThePage(String pageName) {
        mainPage.clickNavigationLink(pageName);
    }
}
