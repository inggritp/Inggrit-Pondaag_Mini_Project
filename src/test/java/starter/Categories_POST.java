package starter;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static org.hamcrest.CoreMatchers.equalTo;

public class Categories_POST {

    private static String base_url = "https://be-qa.alta.id/api";

    @Step("set endpoint for create categories")
    public String setEndPointForCreateCat(){
        return base_url + "/categories";
    }
    @Step("I request POST detail for create new user")
    public void requestPostDetailForCreateCategory(){
        JSONObject requestData = new JSONObject();

        requestData.put("name","Sport");

        SerenityRest.given().header("Content-Type","application/json").body(requestData.toJSONString());
        SerenityRest.when().post(setEndPointForCreateCat());
    }

    @Step("validate post detail after create category")
    public void validatePostDetailAfterCreateCat(int code){
        SerenityRest.then().statusCode(equalTo(code));
        SerenityRest.then().body("data.Name",equalTo("Sport"));


    }


}
