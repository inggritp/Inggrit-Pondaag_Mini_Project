package starter;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.*;

public class Auth_Login {

    String email;

    private static String base_url = "https://be-qa.alta.id/api";

    @Step("Set login endpoint")
    public String setLoginEndpoint(){
        return base_url + "/auth/login";
    }

    @Step("valid email and password")
    public void validEmailPasword(){
        JSONObject reqdata = new JSONObject();

        String email = "pondaaginggrit1@gmail.com";
        String password = "Passwordtest321";

        try(FileWriter file = new FileWriter("src/test/resources/filejson/email.json")){
            file.write(email);
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
        try(FileWriter file = new FileWriter("src/test/resources/filejson/password.json")){
            file.write(password);
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }

        reqdata.put("email",email);
        reqdata.put("password",password);

        SerenityRest.given().header("Content-Type","application/json").body(reqdata.toJSONString());
        SerenityRest.when().post(setLoginEndpoint());
    }

    @Step("valid email but invalid password")
    public void validEmailInvalidPassword(){
        JSONObject reqdata = new JSONObject();

        String email = "pondaaginggrit1@gmail.com";
        String password = "Password431";

        reqdata.put("email",email);
        reqdata.put("password",password);

        SerenityRest.given().header("Content-Type","application/json").body(reqdata.toJSONString());
        SerenityRest.when().post(setLoginEndpoint());

    }

    @Step("invalid email and password")
    public void invalidEmailPassword(){
        JSONObject reqdata = new JSONObject();

        String email = "halloo321@gmail.com";
        String password = "test321hallo";

        reqdata.put("email",email);
        reqdata.put("password",password);

        SerenityRest.given().header("Content-Type","application/json").body(reqdata.toJSONString());
        SerenityRest.when().post(setLoginEndpoint());
    }

    @Step("code and data detail")
    public void validateCodeAndDataDetail(int code){
        if (code == 200){
            SerenityRest.then().statusCode(equalTo(code));
            Response response = SerenityRest.lastResponse();
            String token =response.body().path("data");
            System.out.println(token);
            try(FileWriter file = new FileWriter("src/test/resources/filejson/token.json")){
                file.write(token);
                file.flush();
            } catch(IOException e){
                e.printStackTrace();
            }

        } else {
            SerenityRest.then().statusCode(equalTo(code));
        }
    }


}
