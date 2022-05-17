package starter;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class Transactions_GET {

    private String base_url = "https://be-qa.alta.id/api";

    String token;

    public String setGetallOrdersEndpoint(){
        return base_url + "/orders";
    }

    @Step("get request for get all orders")
    public void sendGetRequestForGetAllOrders() throws  Exception{
        this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/token.json")
        , StandardCharsets.UTF_8);

        given().header("Authorization", "Bearer " + token)
                .when().get(setGetallOrdersEndpoint());
    }

    @Step("Validate status code and data detail")
    public void validateGetAllOrders(int code){
        SerenityRest.then().statusCode(equalTo(code));
        SerenityRest.then().body(containsString("Inhaler"));
    }
}
