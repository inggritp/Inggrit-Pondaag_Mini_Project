package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends PageObject {


    private By productName(){
        return By.className("v-toolbar__title");
    }
    private By firstProduct(){
        return By.xpath("//*[@class = 'col-md-4 col-lg-3 col-6'][1]//span[text() = 'Beli']");
    }
    private By secondProduct(){
        return By.xpath("//*[@class = 'col-md-4 col-lg-3 col-6'][2]//span[text() = 'Beli']");
        ///*[@id ='22']//button
    }

    private By categoryBar(){
        return By.xpath("//*[@class = 'v-input__slot']");
    }
    private By firstKesehatan(){
        return By.xpath("//*[@tabindex = '0'][1]");
        // //*[contains(@id, '-0')]
    }
    private By kesehatanEmpty(){
        return By.xpath("//*[@class = 'v-alert__content']");
    }
    private By shoppingCart(){
        return By.xpath("//*[@class = 'v-btn v-btn--icon v-btn--round theme--dark v-size--default']//*[@class = 'v-badge v-badge--bottom v-badge--left v-badge--overlap theme--dark']");
    }



    @Step
    public boolean productNameAppears(){
        return $(productName()).isDisplayed();
    }
    @Step
    public void clickFirstProduct(){
        $(firstProduct()).click();
    }
    @Step
    public void clickSecondPRoduct(){
    $(secondProduct()).click();
    }
    @Step
    public void clickCategoryBar(){
         $(categoryBar()).click();
    }
    @Step
    public void clickFirstKesehatan(){
        $(firstKesehatan()).click();
    }
    @Step
    public boolean verifyKesehatanIsEmpty(){
        return $(kesehatanEmpty()).isDisplayed();
    }
    @Step
    public void clickShoppingCart(){
        $(shoppingCart()).click();
    }
    @Step
    public boolean verifyFirstKesahatan(){
        return $(firstKesehatan()).isDisplayed();
    }

}
