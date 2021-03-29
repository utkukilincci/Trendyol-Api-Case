package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    RequestSpecification requestSpecification;
    private String baseUrl = "https://api.spotify.com";
    private String token = "BQCtsFiTfqm-QhdEC9nceFYUB-pjMbe9WmdWMkimxpG01tlq" +
            "V68ms7Ob1dxiG2CY97mpt5mMdwTnJQdQMOD7kUySAJYLwa3xxiEPKy8gdo9jysDMOt2b" +
            "y8brIzEZm8se-vb_ngh9riHyTLpsNiJ7ginRmMbubW3NT1dyiDdueWk9HxZWotfjEiMlu" +
            "v0vQD75smTNFJpXrtVUVia0Gth9IXQvGxRh5wWK4JIwR" +
            "hWFijQHK1qGYU6OnR92kSBwwvrQcTihwxIda3Wd1S1On_Js-2Go8OKiPeb6w1RJQ86n";

    public RequestSpec(String endPoint){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl+endPoint)
                .addHeader("Authorization","Bearer " +token)
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
