package starter;

import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.RestRequests.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.equalTo;

public class Product_GET {


    String base_url = "https://be-qa.alta.id/api";

    @Step
    public String GetProductsEndPoint(){
        return base_url + "/products";
    }
    @Step
    public void SendGetAllProductsReq(){
        given().when().get(GetProductsEndPoint());
    }

    @Step
    public void validateGetAllProductsStatusCode(int code){
        then().statusCode(equalTo(code));
    }


    @Step
    public String getProductByIdEndPoint(){
        return base_url + "/products/{id}";
    }

    @Step
    public void SendGetProductByIdReq() throws Exception{
        String id = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/id.json"),StandardCharsets.UTF_8);
        given().pathParam("id",id).when().get(getProductByIdEndPoint());


    }
    @Step
    public void validateGetProductByIdStatusCode(int code){
        then().statusCode(equalTo(code));
    }
}
