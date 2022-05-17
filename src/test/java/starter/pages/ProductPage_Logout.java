package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class ProductPage_Logout extends PageObject {

    private By firstProductButton(){
        return By.xpath("//*[@class = 'col-md-4 col-lg-3 col-6'][1]//span[text() = 'Beli']");
    }
    private By iconForGoToLogout(){
        return By.xpath("//*[@class = 'v-btn v-btn--icon v-btn--round theme--dark v-size--default'][2]");
    }
    private By logoutButton(){
        return By.xpath("//*[@tabindex = '0'][2]");

    }
    private By loginButton(){
        return By.xpath("//*[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary']");
    }

    @Step
    public boolean firstProudctIsDisplayed(){
        return $(firstProductButton()).isDisplayed();
    }

    @Step
    public void clickIconForLogout(){
        $(iconForGoToLogout()).click();
    }
    @Step
    public void clickLogoutButton(){
        $(logoutButton()).click();
    }
    @Step
    public boolean loginButtonIsDisplayed(){
        return $(loginButton()).isDisplayed();
    }




}
