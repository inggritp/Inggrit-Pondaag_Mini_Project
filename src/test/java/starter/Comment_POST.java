package starter;

import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.CoreMatchers.equalTo;

public class Comment_POST {

    String token;

    private String base_url = "https://be-qa.alta.id/api";

    public String postCommentEndPoint(){
        return base_url + "/products/{id}/comments";
    }

    public void postCommentDetail() throws Exception{
        JSONObject reqdata = new JSONObject();

        reqdata.put("content","to relieve symptoms of asthma");

        String id = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/id.json")
                , StandardCharsets.UTF_8);

        this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/test/resources/filejson/token.json"),
                StandardCharsets.UTF_8);

        given().pathParam("id",id)
                .header("Content-Type","application/json")
                .header("Authorization","Bearer " + this.token)
                .body(reqdata).when().post(postCommentEndPoint());
    }

    @Step("validate status code and comment")
    public void validateStatusCodeAFterWriteComment(int code){
        then().statusCode(equalTo(code));
        then().body("data.Content",equalTo("to relieve symptoms of asthma"));

    }
}
