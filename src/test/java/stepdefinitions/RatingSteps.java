package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Rating_GET;
import starter.Rating_POST;

public class RatingSteps {

    @Steps
    Rating_POST ratpost;

    @Steps
    Rating_GET ratget;


    @Given("I set an endpoint for ratings")
    public void iSetAnEndpointForRatings() {
        ratpost.postRatingEndpoint();
        ratget.getRatingEndpoint();

    }

    @When("I post give ratings detail")
    public void iPostGiveRatingsDetail() throws Exception {
        ratpost.postRatingdetail();
    }

    @Then("I validate the status code is {int} and ratings detail")
    public void iValidateTheStatusCodeIsAndRatingsDetail(int arg0) {
        ratpost.validateStatusCodeAfterGiveRatings(arg0);
    }

    @When("I send get product's ratings request")
    public void iSendGetProductSRatingsRequest() throws Exception {
        ratget.sendGetRatingRequest();
    }


    @Then("I validate the status code is {int} and data detail after get ratings")
    public void iValidateTheStatusCodeIsAndDataDetailAfterGetRatings(int arg0) {
        ratget.validateStatusCodeAndGetDetail(arg0);
    }
}
