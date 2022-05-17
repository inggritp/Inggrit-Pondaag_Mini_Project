package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Categories_GET;
import starter.Categories_POST;

public class CategoriesSteps {

    @Steps
    Categories_GET categoryget;

    @Steps
    Categories_POST categorypost;


    @Given("I set an endpoint for Get all categories")
    public void iSetAnEndpointForGetAllCategories() {
        categoryget.getCategoriesEndPoint();
    }

    @When("I send Get all categories request")
    public void iSendGetAllCategoriesRequest() {
        categoryget.requestGetAllCategories();
    }

    @Then("I validate the status code is {int}")
    public void iValidateTheStatusCodeIs(int arg0) {
        categoryget.verifyGetStatusCode(arg0);
    }

    @Given("I set an endpoint to create category")
    public void iSetAnEndpointToCreateCategory() {
        categorypost.setEndPointForCreateCat();
    }

    @When("I request POST detail for create new category")
    public void iRequestPOSTDetailForCreateNewCategory() {
        categorypost.requestPostDetailForCreateCategory();
    }

    @Then("I validate the status code after create category is {int}")
    public void iValidateTheStatusCodeAfterCreateCategoryIs(int arg0) {
        categorypost.validatePostDetailAfterCreateCat(arg0);
    }
}
