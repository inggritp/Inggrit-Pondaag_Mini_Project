package starter;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class Product_POST {

    private static String base_url = "https://be-qa.alta.id/api/";


    @Step
    public String setEndpointForCreateNewProduct(){
        return base_url + "products";
    }

    @Step
    public JSONObject postProductRequestDetail(){
        JSONObject reqdata = new JSONObject();
        List<Integer> data = new ArrayList<>();

        String Product = "Inhaler";

        try(FileWriter file = new FileWriter("src/test/resources/filejson/product.json")){
            file.write(Product);
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }

        reqdata.put("name",Product);
        reqdata.put("price",32000);
        data.add(4);
        data.add(6);

        reqdata.put("categories",data);
        return reqdata;

    }
    @Step("send post product detail")
    public void postRequestDetail(){


        SerenityRest.given().header("Content-Type","application/json").body(postProductRequestDetail());
        SerenityRest.when().post(setEndpointForCreateNewProduct());
    }

    @Step
    public void validateDataAfterCreateProd(int code){
        SerenityRest.then().statusCode(equalTo(code));
        SerenityRest.then().body("data.Name",equalTo("Inhaler"));

    }
    public void getId() {
        Response response = SerenityRest.lastResponse();
        Integer id = response.body().path("data.ID");
        try (FileWriter file = new FileWriter("src//test//resources//filejson//id.json")) {
            file.write(id.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
