package starter.pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class OrderPage extends PageObject {
    private By orderIsEmpty(){
        return By.className("v-alert__content");
    }
    private By totalBayar(){
        return By.xpath("//*[@class = 'v-list-item__title' and text() = 'Total Bayar']");
    }
    private By addButton() {
        return By.xpath("//*[@class = 'v-btn__content' and text() = '+']");
    }
    private By reduceButton(){
        return By.xpath("//*[@class = 'v-btn__content' and text() = '-']");
    }
    private By bayarButton(){
        return By.id("button-bayar");
    }
    private By totalAfterAdd(){
        return By.xpath("//*[@id ='label-total-quantity' and text() = '2']");
    }
    private By totalAfterReduce(){
        return By.xpath("//*[@id ='label-total-quantity' and text() = '1']");
    }

    @Step
    public boolean verifyCartIsEmpty(){
        return $(orderIsEmpty()).isDisplayed();
    }
    @Step
    public boolean verifyTotalBayar(){
        return $(totalBayar()).isDisplayed();
    }
    @Step
    public void clickAddButton(){
        $(addButton()).click();
    }
    @Step
    public void clickReduceButton(){
        $(reduceButton()).click();
    }
    @Step
    public void clickBayarButton(){
        $(bayarButton()).click();
    }
    @Step
    public void totalAfterAddIsEqual(){
        $(totalAfterAdd()).isDisplayed();

    }
    @Step
    public boolean totalAfterReduceIsEqual(){
        return $(totalAfterReduce()).isDisplayed();
    }


}
