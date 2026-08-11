package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WorldClockPage extends Form {

    public WorldClockPage() {
        super(By.xpath("//h1[contains(text(),'Personal World Clock')]"), "Personal World Clock");
    }
}
