package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static helpers.Data.*;

public class RequestSpec {

    RequestSpecification requestSpecification;

    public RequestSpec(String endPoint){
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL+endPoint)
                .addHeader("Authorization","Bearer " +token)
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
