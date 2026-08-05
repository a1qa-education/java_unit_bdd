package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.MainPage;
import org.testng.Assert;

public class MainPageSteps {

    private final MainPage mainPage = new MainPage();

    @Given("I open main page")
    public void iOpenMainPage() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page is not open");
    }

    @Given("I navigate to {string} page")
    public void iNavigateToPage(String pageName) {
        mainPage.clickNavigationLink(pageName);
    }
}
