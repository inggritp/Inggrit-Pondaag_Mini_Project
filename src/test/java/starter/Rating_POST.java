package starter;

import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.equalTo;

public class Rating_POST {

    String token;

    private String base_url = "https://be-qa.alta.id/api";

    public String postRatingEndpoint(){
        return base_url + "/products/{id}/ratings";
    }

    public void postRatingdetail() throws Exception{
        JSONObject reqdata = new JSONObject();

        reqdata.put("count",5);

        String id = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/id.json")
        , StandardCharsets.UTF_8);

        this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/token.json"),
                StandardCharsets.UTF_8);


        given().pathParam("id",id)
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + this.token)
                .body(reqdata).when().post(postRatingEndpoint());
    }

    @Step("validate status code and detail")
    public void validateStatusCodeAfterGiveRatings(int code){
        then().statusCode(equalTo(code));

    }

}
