package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SecureAreaPage extends Form {

    private final ILabel successMessage = getElementFactory().getLabel(By.id("flash"), "Success Message");
    private final IButton logoutButton = getElementFactory().getButton(By.cssSelector("a[href='/logout']"), "Logout");

    public SecureAreaPage() {
        super(By.cssSelector("a[href='/logout']"), "Secure Area Page");
    }

    public String getSuccessMessageText() {
        return successMessage.getText();
    }

    public void clickLogout() {
        logoutButton.state().waitForClickable();
        logoutButton.getJsActions().click();
    }
}
