package pages;

import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import org.openqa.selenium.By;

public class CityWeatherPage extends Form {

    private static final String PAGE_NAME = "Weather in ";

    public CityWeatherPage() {
        super(By.xpath(String.format(LocatorConstants.PARTICULAR_TEXT_XPATH, PAGE_NAME)), PAGE_NAME);
    }
}
