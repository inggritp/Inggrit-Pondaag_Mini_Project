package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth_Login;

public class AuthLoginSteps {

    @Steps
    Auth_Login authlogin;

    @Given("I set login endpoint")
    public void iSetLoginEndpoint() {
        authlogin.setLoginEndpoint();
    }

    @When("I send post request with valid email and password")
    public void iSendPostRequestWithValidEmailAndPassword() {
        authlogin.validEmailPasword();
    }

    @Then("I validate the status code is {int} and data detail")
    public void iValidateTheStatusCodeIsAndDataDetail(int code) {
        authlogin.validateCodeAndDataDetail(code);
    }

    @When("I send post request with valid email but invalid password")
    public void iSendPostRequestWithValidEmailButInvalidPassword() {
        authlogin.validEmailInvalidPassword();
    }

    @When("I send post request with invalid email and password")
    public void iSendPostRequestWithInvalidEmailAndPassword() {
        authlogin.invalidEmailPassword();
    }
}
