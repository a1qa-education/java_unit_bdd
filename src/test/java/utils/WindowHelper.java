package utils;

import aquality.selenium.browser.AqualityServices;

public class WindowHelper {

    public static void switchToNewWindow() {
        String currentWindow = AqualityServices.getBrowser().getDriver().getWindowHandle();

        AqualityServices.getConditionalWait().waitFor(
                () -> AqualityServices.getBrowser().getDriver().getWindowHandles().size() > 1,
                "New window was not opened"
        );

        String newWindow = AqualityServices.getBrowser().getDriver().getWindowHandles().stream()
                .filter(handle -> !handle.equals(currentWindow))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("New window was not found"));

        AqualityServices.getBrowser().getDriver().switchTo().window(newWindow);
    }
}
