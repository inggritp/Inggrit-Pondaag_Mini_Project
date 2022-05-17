package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.LoginPage;
import starter.pages.RegisterPage;

public class RegisterSteps {

    @Steps
    RegisterPage registerpage;

    @Steps
    LoginPage loginpage;

    @Given("I am on register page")
    public void onRegisterPage(){
        registerpage.openRegisURL();

    }
    @When("I input fullname {string}")
    public void inputNamaLengkap(String fullname){
        registerpage.inputNamaLengkap(fullname);

    }
    @And("I input email {string}")
    public void iInputEmail(String email){
        registerpage.inputEmailForRegist(email);

    }
    @And("I input pass {string}")
    public void inputPass(String password){
        registerpage.inputPassForRegist(password);

    }
    @And("click register button")
    public void clickRegisterButton(){
        registerpage.clickRegisButton();

    }
    @Then("I get the {string}")
    public void iGetResult(String result){
        if (result.equals("login_page")){
            loginpage.openUrl();
        }else{
            registerpage.alertSymbolAppears();
            registerpage.errorMessageEquals(result);
        }

    }
}
