package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class LoginPage extends Form {

    private final ITextBox usernameTextBox = getElementFactory().getTextBox(By.id("username"), "Username");
    private final ITextBox passwordTextBox = getElementFactory().getTextBox(By.id("password"), "Password");
    private final IButton loginButton = getElementFactory().getButton(By.cssSelector("button[type='submit']"), "Login");

    public LoginPage() {
        super(By.id("login"), "Form Authentication Page");
    }

    public void login(String username, String password) {
        usernameTextBox.clearAndType(username);
        passwordTextBox.clearAndType(password);
        loginButton.click();
    }

    public void fillInPassword(String password){
        passwordTextBox.clearAndType(password);
    }
}
