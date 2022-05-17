package starter.stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.LoginPage;
import starter.pages.OrderPage;
import starter.pages.ProductPage;

public class ProductSteps {

    @Steps
    LoginPage loginPage;
    @Steps
    ProductPage productpage;
    @Steps
    OrderPage orderpage;


    @Given("I am on product page")
    public void iAmOnProductPage() {
        loginPage.openUrl();
        loginPage.inputEmail("inggrit@gmail.com");
        loginPage.inputPassword("Passwordtest321");
        loginPage.clickLoginButton();
    }

    @When("I click buy button on first product")
    public void iClickBuyButtonOnTensiDarahElektrik() {
        productpage.clickFirstProduct();
    }

    @Then("first product added to my shopping cart")
    public void tensiDarahElektrikAddedToMyShoppingCart() {
        productpage.clickShoppingCart();
        orderpage.verifyTotalBayar();
    }

    @When("I click buy button on second product")
    public void iClickBuyButtonOnTensiDarahManual() {
        productpage.clickSecondPRoduct();
    }

    @Then("second product added to my shopping cart")
    public void tensiDarahManualAddedToMyShoppingCart() {
        productpage.clickShoppingCart();
        orderpage.verifyTotalBayar();

    }

    @When("I dont click any buy button on product title")
    public void iDontClickAnyBuyButtonOnProductTitle() {
        productpage.productNameAppears();
        productpage.clickShoppingCart();
    }

    @Then("My shopping cart is empty")
    public void myShoppingCartIsEmpty() {
        orderpage.verifyCartIsEmpty();
    }

    @When("I click category bar")
    public void iClickCategoryBar() {
        productpage.clickCategoryBar();
    }

    @And("I click category that i want")
    public void iClickCategoryThatIWant() throws Exception {
        Thread.sleep(800);
        productpage.verifyFirstKesahatan();
        productpage.clickFirstKesehatan();


    }

    @Then("I can see is the category has items or not")
    public void iCanSeeIsTheCategoryHaveItemsOrNot() {
        productpage.verifyKesehatanIsEmpty();
    }
}
