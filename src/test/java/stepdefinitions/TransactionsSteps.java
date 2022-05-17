package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Transactions_GET;
import starter.Transactions_POST;

public class TransactionsSteps {
    @Steps
    Transactions_POST transpost;

    @Steps
    Transactions_GET transget;

    @Given("I set an endpoint for create order")
    public void iSetAnEndpointForCreateOrder() {
        transpost.setTransactionsPOSTEndpoint();
    }

    @When("I send post detail for create order")
    public void iSendPostDetailForCreateOrder() throws Exception {
        transpost.postRequestForCrateNewOrder();
    }

    @Then("I validate the status code is {int} after create order and the detail")
    public void iValidateTheStatusCodeIsAfterCreateOrderAndTheDetail(int arg0) {
        transpost.validateAfterCreateOrderStatusCode(arg0);
        transpost.validateAfterCreateOrderDetail();
    }

    @Given("I set an endpoint for get all orders")
    public void iSetAnEndpointForGetAllOrders() {
        transget.setGetallOrdersEndpoint();
    }

    @When("I request to get all orders")
    public void iRequestToGetAllOrders() throws Exception {
        transget.sendGetRequestForGetAllOrders();
    }

    @Then("I validate the status code is {int} and detail")
    public void iValidateTheStatusCodeIsAndDetail(int arg0) {
        transget.validateGetAllOrders(arg0);
    }

    @When("I send invalid post detail for create order")
    public void iSendInvalidPostDetailForCreateOrder() throws Exception {
        transpost.postRequestWithInvalidDAta();
    }


    @Then("I validate the status code for invalid request is {int}")
    public void iValidateTheStatusCodeForInvalidRequestIs(int arg0) {
        transpost.validatePostWithInvalidDataStatusCode(arg0);
    }
}
