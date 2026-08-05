package pages.multiple_windows;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MultipleWindowsPage extends Form {

    private final ILink clickHereLink = getElementFactory().getLink(By.linkText("Click Here"),"Click Here");

    public MultipleWindowsPage() {
        super(By.tagName("h3"), "Multiple Windows Page");
    }

    public void clickHere() {
        clickHereLink.click();
    }
}
