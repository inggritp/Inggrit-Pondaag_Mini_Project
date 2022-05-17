package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.LoginPage;
import starter.pages.OrderPage;
import starter.pages.ProductPage;
import starter.pages.TransactionPage;

public class OrderSteps {

    @Steps
    OrderPage orderpage;
    @Steps
    LoginPage loginpage;
    @Steps
    TransactionPage transactionpage;
    @Steps
    ProductPage productpage;

    @Given("I am already on product page")
    public void onProductPageForOrder(){
        loginpage.openUrl();
        loginpage.inputEmail("inggrit@gmail.com");
        loginpage.inputPassword("Passwordtest321");
        loginpage.clickLoginButton();
    }
    @When("I click buy first product button on product page")
    public void iClickBuyFirstProductButtonOnProductPage() {
        productpage.clickFirstProduct();
    }

    @And("I click shopping cart button")
    public void iClickShoppingCartButton() {
        productpage.clickShoppingCart();
    }

    @And("I click + sign on the product")
    public void iClickAddSignOnTheProduct() {
        orderpage.clickAddButton();
    }

    @Then("The total quantity of the product is equal to 2")
    public void theTotalQuantityOfTheProductIncreases()  {
        orderpage.totalAfterAddIsEqual();
    }

    @When("I click buy second product button on product page")
    public void iClickBuySecondProductButton() {
        productpage.clickSecondPRoduct();
    }
    @And("I click - sign on the product")
    public void iClickReduceSignOnTheProduct(){
        orderpage.clickReduceButton();

    }

    @Then("The total quantity of the product is equal to 1")
    public void theTotalQuantityOfTheProductIsReduced() {
        orderpage.totalAfterReduceIsEqual();
    }

    @Then("I validate the product is removed")
    public void iValidateTheProductIsRemoved() {
        orderpage.verifyCartIsEmpty();
    }

    @And("I click Bayar button")
    public void iClickBayarButton() {
        orderpage.clickBayarButton();
    }

    @Then("I go to transactions page")
    public void iGoToTransactionsPage() throws Exception {
        Thread.sleep(600);
        transactionpage.selectRowAppears();
        transactionpage.BanyaknyaAppears();
    }
}
