package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.loginElements;

public class loginStepDefs {
    private loginElements loginElements;
    private String url = "https://www.saucedemo.com/";
    private String invalidCredsErrorMsg = "Username and password do not match";
    public loginStepDefs() {
        this.loginElements = new loginElements();
    }

    @Given("User navigates to the page")
    public void userNavigatesToThePage() {
        Hooks.getDriver().get(url);
        Assert.assertTrue(Hooks.getDriver().getCurrentUrl().contains(url));
    }

    @And("user click on login button")
    public void userClickOnLoginButton() {
        loginElements.clickLogin();
    }


    @When("user enters {string} and {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        loginElements.enterUsername(username);
        loginElements.enterPassword(password);
    }

    @Then("user is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        Assert.assertTrue(loginElements.logoutButtonIsDisplayed());
    }

    @Then("user cannot login")
    public void userCannotLogin() {
        Assert.assertTrue(loginElements.errorMessageIsShown().contains(invalidCredsErrorMsg));
    }

    @Then("error message shows that the user must fill the {string} field")
    public void errorMessageShowsThatTheUserMustFillTheField(String missingField) {
        Assert.assertTrue(loginElements.errorMessageIsShown().contains(missingField + " is required"));
    }
}
