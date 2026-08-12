package pages.frames;

import aquality.selenium.forms.Form;
import utils.FrameHelper;
import org.openqa.selenium.By;

public class NestedFramesPage extends Form {

    private static final By TOP_FRAME = By.name("frame-top");

    public NestedFramesPage() {
        super(TOP_FRAME, "Nested Frames");
    }

    public String getLeftFrameText() {
        String text = switchToTopFrame().switchToLeftFrame().getText();
        FrameHelper.switchToDefaultContent();
        return text;
    }

    public String getRightFrameText() {
        // todo: Implement the method
        return "";
    }

    private TopFrameForm switchToTopFrame() {
        return FrameHelper.switchToFrame(TOP_FRAME, TopFrameForm.class);
    }
}
