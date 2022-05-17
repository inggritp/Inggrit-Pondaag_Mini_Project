package starter;

import Utils.GeneralRandom;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class Auth_Regist {

    GeneralRandom random = new GeneralRandom();

    private static String base_url = "https://be-qa.alta.id/api";

    @Step
    public String setEndPointForRegist(){
        return base_url + "/auth/register";
    }
    @Step("Register with unregistered email")
    public void postRequestWithUnregisteredEmail(){
        JSONObject reqdata = new JSONObject();

        String email = random.RandomEmail();

        reqdata.put("fullname","jisoo");
        reqdata.put("email", email);
        reqdata.put("password","Dalgomiee12");

        SerenityRest.given().header("Content-Type","application/json").body(reqdata.toJSONString());
        SerenityRest.when().post(setEndPointForRegist());
    }

    @Step("validate code")
    public void ValidateCodeAfterCreateIs200(int code){
        SerenityRest.then().statusCode(equalTo(code));
    }

    @Step("Register with registered email")
    public void postRequestWithRegisteredEmail(){
        JSONObject reqdata = new JSONObject();

        reqdata.put("fullname","inggrit");
        reqdata.put("email","pondaaginggrit1@gmail.com");
        reqdata.put("password","Passwordtest321");

        SerenityRest.given().header("Content-Type","application/json").body(reqdata.toJSONString());
        SerenityRest.when().post(setEndPointForRegist());
    }

    @Step("validate code and error message")
    public void validateCodeAndErrorMessage(int code){
        SerenityRest.then().statusCode(equalTo(code));
        SerenityRest.then().body(containsString("duplicate key value"));
    }



}
