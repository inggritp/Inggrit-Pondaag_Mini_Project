package starter.pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class TransactionPage extends PageObject {

    private By selectRowToShow(){
        return By.className("v-input__control");
    }

    private By banyaknya(){
        return By.xpath("//*[span = 'Banyaknya']");
    }

    @Step
    public boolean selectRowAppears(){
        return $(selectRowToShow()).isDisplayed();
    }

    @Step
    public boolean BanyaknyaAppears(){
        return $(banyaknya()).isDisplayed();
    }


}
