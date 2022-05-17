package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Auth_Regist;

public class AuthRegistSteps {

    @Steps
    Auth_Regist authregis;

    @Given("I set an endpoint for register new user")
    public void iSetAnEndpointForRegisterNewUser() {
        authregis.setEndPointForRegist();
    }

    @When("I send post detail with unregistered email")
    public void iSendPostDetailWithUnregisteredEmail() {
        authregis.postRequestWithUnregisteredEmail();
    }

    @Then("I validate the register status code is {int}")
    public void iValidateTheRegisterStatusCodeIs(int arg0) {
        authregis.ValidateCodeAfterCreateIs200(arg0);
    }



    @When("I send post detail with registered email")
    public void iSendPostDetailWithRegisteredEmail() {
        authregis.postRequestWithRegisteredEmail();
    }


    @Then("I validate the status code is {int} and message")
    public void iValidateTheStatusCodeIsAnd(int arg0) {
        authregis.validateCodeAndErrorMessage(arg0);
    }
}
