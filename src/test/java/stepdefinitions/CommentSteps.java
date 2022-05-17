package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Comment_GET;
import starter.Comment_POST;

public class CommentSteps {

    @Steps
    Comment_POST commenpost;

    @Steps
    Comment_GET commenget;

    @Given("I set comment endpoint")
    public void iSetCommentEndpoint() {
        commenpost.postCommentEndPoint();
        commenget.getCommentEndPoint();

    }

    @When("I send post detail for write comment to a product")
    public void iSendPostDetailForWriteCommentToAProduct() throws Exception {
        commenpost.postCommentDetail();
    }

    @Then("I validate the status code after write comment is {int} and the detail")
    public void iValidateTheStatusCodeAfterWriteCommentIsAndTheDetail(int arg0) {
        commenpost.validateStatusCodeAFterWriteComment(arg0);
    }

    @When("I send get request to get product's comments")
    public void iSendGetRequestToGetProductSComments() throws Exception {
        commenget.sendGetCommentRequest();

    }

    @Then("I validate the status code is {int} and validate the comment")
    public void iValidateTheStatusCodeIsAndValidateTheComment(int arg0) {
        commenget.validateStatusCodeAndComment(arg0);
    }
}
