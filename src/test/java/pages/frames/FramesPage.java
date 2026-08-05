package pages.frames;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FramesPage extends Form {
    private static final String NAME = "Frames";
    private final By NESTED_FRAMES_LINK_LOC = By.linkText("Nested Frames");
    private final ILink nestedFramesLink = getElementFactory().getLink(NESTED_FRAMES_LINK_LOC, "Frames");

    public FramesPage() {
        super(By.xpath("//*[contains(text(),'Frames')]"), NAME);
    }

    public void clickNestedFramesLink() {
        nestedFramesLink.click();
    }
}
