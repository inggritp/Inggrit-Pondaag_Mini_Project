package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.LoginPage;
import starter.pages.ProductPage_Logout;

public class LogoutSteps {

    @Steps
    ProductPage_Logout orderlogout;

    @Steps
    LoginPage loginpage;
    @Given("I successfully login")
    public void iSuccessfullyLogin() {
        loginpage.openUrl();
        loginpage.inputEmail("inggrit@gmail.com");
        loginpage.inputPassword("Passwordtest321");
        loginpage.clickLoginButton();
    }

    @And("I directed to product page")
    public void iDirectedToProductPage() {
        orderlogout.firstProudctIsDisplayed();
    }

    @When("I click menu button")
    public void iClickMenuButton() {
        orderlogout.clickIconForLogout();
    }

    @And("I click logout button")
    public void iClickLogoutButton() throws Exception {
        Thread.sleep(600);
        orderlogout.clickLogoutButton();
    }

    @Then("I directed to login page")
    public void iDirectedToLoginPage() {
        orderlogout.loginButtonIsDisplayed();

    }

}
