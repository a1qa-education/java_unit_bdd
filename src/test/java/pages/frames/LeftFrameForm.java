package pages.frames;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class LeftFrameForm extends Form {

    private final ILabel textLabel = getElementFactory().getLabel(By.tagName("body"), "Left text");

    public LeftFrameForm() {
        super(By.tagName("body"), "Left Frame");
    }

    public String getText() {
        return textLabel.getText();
    }
}
