package pages.frames;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.FrameHelper;

public class TopFrameForm extends Form {

    private static final By LEFT_FRAME = By.name("frame-left");
    private static final By RIGHT_FRAME = By.name("frame-right");

    public TopFrameForm() {
        super(By.tagName("body"), "Left Frame");
    }

    public LeftFrameForm switchToLeftFrame() {
        return FrameHelper.switchToFrame(LEFT_FRAME, LeftFrameForm.class);
    }

    public RightFrameForm switchToRightFrame() {
        return FrameHelper.switchToFrame(RIGHT_FRAME, RightFrameForm.class);
    }
}
