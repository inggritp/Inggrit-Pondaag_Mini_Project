package starter.pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.actions.Scroll.to;

public class LoginPage extends PageObject {

    private By emailField(){
        return By.xpath("//*[label[text() = 'Email']]/input");

    }
    private By passwordField(){
        return By.xpath("//*[label[text() = 'Password']]/input");
    }
    private By loginButton(){
        return By.xpath("//*[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary']");
    }
    private By errorMessaage(){
        return By.className("v-alert__content");
    }

    @Step
    public void openUrl(){
        openAt("/auth/login");
    }
    @Step
    public void inputEmail(String email){
        $(emailField()).type(email);
    }
    @Step
    public void inputPassword(String password){
        $(passwordField()).type(password);
    }
    @Step
    public void clickLoginButton(){
        $(loginButton()).click();
    }
    @Step
    public boolean errorMessageAppears(){
        return $(errorMessaage()).isDisplayed();
    }
    @Step
    public void errorMessageEquals(String text){
        $(errorMessaage()).getText().equals(text);
    }






}
