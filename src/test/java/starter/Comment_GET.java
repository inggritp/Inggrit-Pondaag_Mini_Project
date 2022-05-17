package starter;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.equalTo;

public class Comment_GET {

    String token;

    private String base_url = "https://be-qa.alta.id/api";

    public String getCommentEndPoint(){
        return base_url + "/products/{id}/comments";
    }

    public void sendGetCommentRequest() throws Exception{
        String id = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/id.json")
                , StandardCharsets.UTF_8);

        this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/token.json"),
                StandardCharsets.UTF_8);

        given().pathParam("id",id)
                .header("Authorization","Bearer " + this.token)
                .header("Content-Type","application/json")
                .when().get(getCommentEndPoint());
    }

    public void validateStatusCodeAndComment(int code){
        then().statusCode(equalTo(code));
        then().body("data[0].Content",equalTo("to relieve symptoms of asthma"));
    }

}
