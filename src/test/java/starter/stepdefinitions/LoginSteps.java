package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.LoginPage;
import starter.pages.ProductPage;

public class LoginSteps {

    @Steps
    LoginPage loginpage;

    @Steps
    ProductPage productpage;


    @Given("I am on qa.alta.id login page")
    public void iAmOnQaAltaIdLoginPage() {
        loginpage.openUrl();
    }

    @When("I input {string}")
    public void inputEmail(String Email) {
        loginpage.inputEmail(Email);
    }
    @And("Input {string}")
    public void input(String Password) {
        loginpage.inputPassword(Password);
    }

    @And("Click login button")
    public void clickLoginButton() {
        loginpage.clickLoginButton();
    }

    @Then("I get {string}")
    public void iGet(String result) {
        if(result.equals("product_page")){
            productpage.productNameAppears();
        }else{
            loginpage.errorMessageAppears();
            loginpage.errorMessageEquals(result);
        }
    }


}
