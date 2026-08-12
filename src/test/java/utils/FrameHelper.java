package utils;

import aquality.selenium.browser.AqualityServices;
import org.openqa.selenium.By;

public class FrameHelper {

    public static <T> T switchToFrame(By locator, Class<T> pageClass) {
        AqualityServices.getBrowser()
                .getDriver()
                .switchTo()
                .frame(
                        AqualityServices.getBrowser()
                                .getDriver()
                                .findElement(locator)
                );

        try {
            return pageClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(String.format("Cannot create page %s", pageClass.getSimpleName()), e);
        }
    }

    public static void switchToDefaultContent() {
        AqualityServices.getBrowser()
                .getDriver()
                .switchTo()
                .defaultContent();
    }

    public static void switchToParentFrame() {
        AqualityServices.getBrowser()
                .getDriver()
                .switchTo()
                .parentFrame();
    }
}
