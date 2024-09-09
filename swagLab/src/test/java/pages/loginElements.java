package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefs.Hooks;

public class loginElements {
    private WebDriver driver;
    public loginElements() {
        this.driver = Hooks.getDriver();
        if (this.driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }
    }
    public WebElement getUsernameField() {
        return driver.findElement(By.id("user-name"));
    }
    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }
    public WebElement getLoginButton() {
        return driver.findElement(By.id("login-button"));
    }
    public WebElement getMenuButton() {

        return driver.findElement(By.id("react-burger-menu-btn"));
    }
    public WebElement getLogoutButton() {
        return driver.findElement(By.id("logout_sidebar_link"));
    }
    public WebElement getErrorMessage() {
        return driver.findElement(By.cssSelector(".error-message-container.error"));
    }
    public void enterUsername(String username) {

        getUsernameField().sendKeys(username);
    }
    public void enterPassword(String password) {
        getPasswordField().sendKeys(password);
    }
    public void clickLogin() {
        getLoginButton().click();
    }
    public boolean logoutButtonIsDisplayed() {
        getMenuButton().click();
        return getLogoutButton().isDisplayed();
    }
    public String errorMessageIsShown() {
        return getErrorMessage().getText();
    }
}
