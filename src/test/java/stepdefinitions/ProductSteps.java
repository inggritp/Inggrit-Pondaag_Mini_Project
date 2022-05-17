package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import net.thucydides.core.annotations.Steps;
import starter.Product_GET;
import starter.Product_POST;

public class ProductSteps {

    @Steps
    Product_GET prodget;

    @Steps
    Product_POST prodpost;

    @Given("I set an endpoint to get all products")
    public void iSetAnEndpointToGetAllProducts() {
        prodget.GetProductsEndPoint();
    }

    @When("I send GET all products request")
    public void iSendGETAllProductsRequest() {
        prodget.SendGetAllProductsReq();
    }

    @Then("I validate the status code for product is {int}")
    public void iValidateTheStatusCodeForProductIs(int arg0) {
        prodget.validateGetAllProductsStatusCode(arg0);
        prodget.validateGetProductByIdStatusCode(arg0);
    }

    @Given("I set an endpoint to get product by id")
    public void iSetAnEndpointToGetProductById()  {
        prodget.getProductByIdEndPoint();
    }

    @When("I send GET product by id request")
    public void iSendGETProductByIdRequest() throws Exception {
        prodget.SendGetProductByIdReq();
    }

    @Given("I set an endpoint to create new product")
    public void iSetAnEndpointToCreateNewProduct() {
        prodpost.setEndpointForCreateNewProduct();
    }

    @When("I request POST detail for create new product")
    public void iRequestPOSTDetailForCreateNewProduct() {
        prodpost.postRequestDetail();
    }

    @Then("I validate the status code is {int} and validate the product detail")
    public void iValidateTheAfterCreateNewProductDetail(int arg1) throws Exception {
        prodpost.validateDataAfterCreateProd(arg1);
        prodpost.getId();
    }

}
