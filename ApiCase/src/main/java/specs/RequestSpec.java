package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    RequestSpecification requestSpecification;
    private String baseUrl = "https://api.spotify.com";
    private String token = "BQB-re54EvB8_1qlQBAVQXDtyPsLniXuD-pB79SnfFUX_" +
            "-rHXIBkEaFSqFzGF4Ej1P7znhRaIsy50bs4AG_uR837Rm1zlbZH0qIVFoJ0nvYB_v-VNUA-aTO" +
            "wYI9BFNGjaNX9hA1vB5U3z88c5YZ4qIFh-WIz5LodXiGewK78HtQ5lVhYLQMRh" +
            "ihRHAudIvyZ5MGrU69sb91rKe6ExtBNHASFek83J-Sb" +
            "TIqBSI8tSE_hsuMbx1FSMRUZY3KFsaUV8XnwDcze4Zxp6bDDWOt_T3Rmx-LIboOw5gmNONFv";

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
