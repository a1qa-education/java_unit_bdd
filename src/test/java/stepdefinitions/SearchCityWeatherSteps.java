package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class SearchCityWeatherSteps {

    private static final String SEARCH_INPUT_XPATH = "//input[@class='picker-city__input']";
    private static final String SUGGESTION_XPATH = "//ul[@class='asu']//li/a";
    private static final String HEADLINE_XPATH = "//h1[@class='headline-banner__title']";

    private static String searchedCity;

    @Given("I open the url {string}")
    public void openUrl(String url) {
        AqualityServices.getBrowser().goTo(url);
        AqualityServices.getBrowser().waitForPageToLoad();
    }

    @Then("I click the link with class {string} and text {string}")
    public void clickLinkWithClassAndText(String cssClass, String text) {
        ILink link = AqualityServices.getElementFactory().getLink(
                By.xpath(String.format("//a[@class='%s' and text()='%s']", cssClass, text)), text);
        link.click();
        AqualityServices.getBrowser().waitForPageToLoad();
    }

    @When("I verify the page title contains {string}")
    public void verifyPageTitleContains(String expected) {
        Assert.assertTrue(AqualityServices.getBrowser().getDriver().getTitle().contains(expected),
                String.format("Page title '%s' does not contain '%s'",
                        AqualityServices.getBrowser().getDriver().getTitle(), expected));

        Assert.assertTrue(AqualityServices.getBrowser().getCurrentUrl().contains("/weather"),
                "Weather section was not opened");
    }

    @Given("I clear the input")
    public void clearInput() {
        ITextBox input = AqualityServices.getElementFactory().getTextBox(
                By.xpath(SEARCH_INPUT_XPATH), "search input");
        input.state().waitForDisplayed();
        input.clear();
    }

    @And("I type {string} into the input with class {string}")
    public void typeIntoInputWithClass(String value, String cssClass) {
        searchedCity = value;

        ITextBox input = AqualityServices.getElementFactory().getTextBox(
                By.xpath(String.format("//input[@class='%s']", cssClass)), "search input");
        input.click();
        input.type(value);
    }

    @When("I wait {int} seconds for the dropdown to appear")
    public void waitForDropdown(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        AqualityServices.getConditionalWait()
                .waitFor(() -> !AqualityServices.getBrowser().getDriver()
                                .findElements(By.xpath(SUGGESTION_XPATH)).isEmpty(),
                        "Suggestion dropdown did not appear");
    }

    @But("I click element number {int} in the list")
    public void clickElementNumberInList(int number) {
        List<ILink> suggestions = AqualityServices.getElementFactory()
                .findElements(By.xpath(SUGGESTION_XPATH), ElementType.LINK);
        suggestions.get(number - 1).click();
        AqualityServices.getBrowser().waitForPageToLoad();
    }

    @When("the text of element contains {string}")
    public void textOfElementContains(String expected) {
        ILabel headline = AqualityServices.getElementFactory().getLabel(By.xpath(HEADLINE_XPATH), "headline");

        Assert.assertTrue(headline.state().waitForDisplayed(), "City Weather page was not opened");
        Assert.assertTrue(headline.getText().contains(expected),
                String.format("Expected headline to contain '%s' but was '%s'", expected, headline.getText()));
        Assert.assertEquals(expected, searchedCity, "Headline city does not match the searched city");
    }
}
