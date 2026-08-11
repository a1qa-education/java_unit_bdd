package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
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

public class PersonalWorldClockSteps {

    private static final String ADD_CITY_MODAL_XPATH = "//div[contains(@class,'modal-content')][.//input[@id='addtxt']]";
    private static final String SUGGESTION_XPATH = "//ul[@class='asu']//li/a";
    private static final String CITY_NAME_XPATH = "//a[@class='c-city__name' and text()='%s']";

    private static String addedCity;

    @Given("I navigate to the page {string}")
    public void navigateToPage(String url) {
        AqualityServices.getBrowser().goTo(url);
        AqualityServices.getBrowser().waitForPageToLoad();
    }

    @And("I press the link with class {string}")
    public void pressLinkWithClass(String cssClass) {
        ILink link = AqualityServices.getElementFactory().getLink(
                By.xpath(String.format("//a[contains(@class,'%s')]", cssClass)), cssClass);
        link.state().waitForDisplayed();
        link.click();
    }

    @And("I verify the modal with title {string} is opened")
    public void verifyModalWithTitleIsOpened(String title) {
        ILabel modalTitle = AqualityServices.getElementFactory().getLabel(
                By.xpath(ADD_CITY_MODAL_XPATH + "//h2[contains(@class,'modal-title')]"), "modal title");

        Assert.assertTrue(modalTitle.state().waitForDisplayed(), "The dialog did not open");
        Assert.assertEquals(modalTitle.getText().trim(), title, "Unexpected dialog was opened");

        ITextBox input = AqualityServices.getElementFactory().getTextBox(
                By.xpath("//input[@id='addtxt']"), "city name input");
        Assert.assertTrue(input.getValue().isEmpty(), "City name field is not empty");
    }

    @When("I enter {string} into the input with id {string}")
    public void enterIntoInputWithId(String value, String id) {
        addedCity = value;

        ITextBox input = AqualityServices.getElementFactory().getTextBox(
                By.xpath(String.format("//input[@id='%s']", id)), "city name input");
        input.state().waitForDisplayed();
        input.click();
        input.type(value);
    }

    @But("I wait {int} seconds until the suggestion list is shown")
    public void waitUntilSuggestionListIsShown(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        AqualityServices.getConditionalWait()
                .waitFor(() -> !AqualityServices.getBrowser().getDriver()
                                .findElements(By.xpath(SUGGESTION_XPATH)).isEmpty(),
                        "Suggestion list did not appear");
    }

    @When("I click suggestion number {int} in dropdown")
    public void clickSuggestionNumberInDropdown(int number) {
        List<ILink> suggestions = AqualityServices.getElementFactory()
                .findElements(By.xpath(SUGGESTION_XPATH), ElementType.LINK);
        suggestions.get(number - 1).click();
    }

    @Then("I press the modal button with text {string}")
    public void pressModalButtonWithText(String text) {
        IButton button = AqualityServices.getElementFactory().getButton(
                By.xpath(String.format(ADD_CITY_MODAL_XPATH + "//button[text()='%s']", text)), text);
        button.state().waitForDisplayed();
        button.click();
    }

    @Then("word {string} is displayed")
    public void wordIsDisplayed(String word) {
        ILabel cityName = AqualityServices.getElementFactory().getLabel(
                By.xpath(String.format(CITY_NAME_XPATH, word)), "added city");

        Assert.assertTrue(cityName.state().waitForDisplayed(),
                String.format("Word '%s' was not displayed", word));
        Assert.assertEquals(cityName.getText(), addedCity, "Displayed city does not match the added city");
    }
}
