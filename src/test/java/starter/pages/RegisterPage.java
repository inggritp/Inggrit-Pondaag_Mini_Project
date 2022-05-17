package starter.pages;

import Utils.General;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class RegisterPage extends PageObject {

    General general = new General();


    private By namaLengkapField(){
        return By.xpath("//*[label[text() = 'Nama Lengkap']]/input");
    }
    private By emailFieldRegisterPage(){
        return By.xpath("//*[label[text() = 'Email']]/input");
    }
    private By passwordFiledRegisterPage(){
        return By.xpath("//*[label[text() = 'Password']]/input");
    }
    private By registerButton(){
        return By.xpath("//*[@class = 'v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary']");
    }
    private By alertSymbol(){
        return By.className("v-alert__content");
    }


    @Step
    public void openRegisURL(){
        openAt("/auth/register");
    }
    @Step
    public void inputNamaLengkap(String nama_lengkap){

        $(namaLengkapField()).type(nama_lengkap);
    }
    @Step
    public void inputEmailForRegist(String email){
        if (email.equals("new")){
            $(emailFieldRegisterPage()).type(general.randomNumForEmail(email));
        } else{
            $(emailFieldRegisterPage()).type(email);
        }
    }

    @Step
    public void inputPassForRegist(String password){
        $(passwordFiledRegisterPage()).type(password);
    }

    @Step
    public void clickRegisButton(){
        $(registerButton()).click();
    }

    @Step
    public boolean alertSymbolAppears(){
        return $(alertSymbol()).isDisplayed();

    }
    public void errorMessageEquals(String error){
        $(alertSymbol()).getText().equals(error);
    }



}
