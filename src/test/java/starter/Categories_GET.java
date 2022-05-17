package starter;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.RestRequests.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Categories_GET {

    String base_url = "https://be-qa.alta.id/api";

    @Step("Set endpoint for get all categories")
    public String getCategoriesEndPoint(){
        return base_url + "/categories";
    }
    @Step("request all categories")
    public void requestGetAllCategories(){
        given().when().get(getCategoriesEndPoint());
    }
    @Step("verify status code for get all categories")
    public void verifyGetStatusCode(int code){
        SerenityRest.then().statusCode(equalTo(code));
    }
}
