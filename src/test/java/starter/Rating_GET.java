package starter;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.equalTo;

public class Rating_GET {

    String token;

    private String base_url = "https://be-qa.alta.id/api";

    public String getRatingEndpoint() {
        return base_url + "/products/{id}/ratings";
    }

    public void sendGetRatingRequest() throws Exception {
        String id = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/id.json")
                , StandardCharsets.UTF_8);

        this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/token.json"),
                StandardCharsets.UTF_8);

        given().pathParam("id",id)
                .header("Authorization","Bearer " + this.token)
                .when().get(getRatingEndpoint());
    }

    public void validateStatusCodeAndGetDetail(int code){
        then().statusCode(equalTo(code));
        then().body("data",equalTo(5));
    }

}
