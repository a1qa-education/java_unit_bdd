package pages;

import aquality.selenium.forms.Form;
import constants.LocatorConstants;
import org.openqa.selenium.By;

public class WeatherPage extends Form {

    private static final String PAGE_NAME = "Weather Around The World";

    public WeatherPage() {
        super(By.xpath(String.format(LocatorConstants.PARTICULAR_TEXT_XPATH, PAGE_NAME)), PAGE_NAME);
    }
}
