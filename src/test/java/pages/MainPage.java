package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import constants.MainPageNavigation;
import org.openqa.selenium.By;

public class MainPage extends Form {

    private static final String NAV_LINK_XPATH = "//a[@class='site-nav__title' and text()='%s']";

    public MainPage() {
        super(By.xpath(String.format(LocatorConstants.PRECISE_TEXT_XPATH, "Current Time")), "Main Page");
    }

    private ILink getNavigationLink(MainPageNavigation section) {
        return AqualityServices.getElementFactory()
                .getLink(By.xpath(String.format(NAV_LINK_XPATH, section.getLabel())), section.getLabel());
    }

    public void navigateTo(MainPageNavigation section) {
        getNavigationLink(section).click();
    }
}
