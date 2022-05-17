package starter;

import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.equalTo;

public class Transactions_POST {

    private String base_url = "https://be-qa.alta.id/api";

    String token;

    public String setTransactionsPOSTEndpoint(){
        return base_url + "/orders";
    }

    @Step("new order detail")
    public List<JSONObject> postOrdeDetail(){
        List<JSONObject> body = new ArrayList<>();
        JSONObject data = new JSONObject();

        data.put("product_id",1137);
        data.put("quantity",4);

        body.add(data);

        return body;


    }

    @Step("request for create new order using bearer token")
    public void postRequestForCrateNewOrder() throws Exception{
        this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/token.json"),
                StandardCharsets.UTF_8);

        given().header("Content-Type","application/json")
                .header("Authorization","Bearer " + this.token)
                .body(postOrdeDetail());
        when().post(setTransactionsPOSTEndpoint());
    }

    public void validateAfterCreateOrderStatusCode(int code){
        then().statusCode(equalTo(code));
    }

    public void validateAfterCreateOrderDetail(){
        then().body("data[0].Quantity", equalTo(4));
    }

    @Step("create order with invalid format")
    public List<JSONObject> postOrderWithInvalidData(){
        List<JSONObject> body = new ArrayList<>();
        JSONObject data = new JSONObject();

        data.put("product_id",1137);
        data.put("quantity","");

        body.add(data);

        return body;

    }
    @Step("request for create new order using bearer token")
    public void postRequestWithInvalidDAta() throws Exception{
        this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/token.json"),
                StandardCharsets.UTF_8);

        given().header("Content-Type","application/json")
                .header("Authorization","Bearer " + this.token)
                .body(postOrderWithInvalidData());
        when().post(setTransactionsPOSTEndpoint());
    }

    public void validatePostWithInvalidDataStatusCode(int code){
        then().statusCode(equalTo(code));

    }

    }



