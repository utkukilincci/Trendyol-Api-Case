package serviceBase;


import base.Keywords;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import static helpers.LogUtils.logInfo;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class GeneralApiController {
    private RequestSpecification spec;

    public GeneralApiController() {
    }

    public GeneralApiController(String baseUrl) {
        this.spec = new RequestSpecBuilder().setBaseUri(baseUrl).setBasePath("/").build();
    }

    public GeneralApiController(String baseUrl, String basePath) {
        this.spec = new RequestSpecBuilder().setBaseUri(baseUrl).setBasePath(basePath).build();
    }

    protected ReadableResponse getRequest() {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .when()
                .get()
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s", basePath, "get"));

        return new ReadableResponse(response);
    }

    protected ReadableResponse getRequest(String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s", endPoint, "get"));

        return new ReadableResponse(response);
    }

    protected ReadableResponse getRequest(JSONObject jsonObject, String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .body(jsonObject.toString())
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "get", jsonObject.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse getRequest(List<QueryParam> queryParams, String endPoint) {
        RequestSpecification requestSpecification = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON);

        for (QueryParam queryParam : queryParams) {
            requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
        }

        Response response = requestSpecification
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "get", queryParams.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse getRequest(RequestSpecification headerSpec, String endPoint) {
        Response response = given()
                .spec(headerSpec)
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Header Spec: %s ", endPoint, "get", headerSpec.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse postRequest(String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .when()
                .post(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s", endPoint, "post"));

        return new ReadableResponse(response);
    }

    protected ReadableResponse postRequest(JSONObject jsonObject, String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .body(jsonObject.toString())
                .when()
                .post(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "post", jsonObject.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse postRequest(JSONObject jsonObject, List<QueryParam> queryParams, String endPoint) {
        RequestSpecification requestSpecification = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON);

        for (QueryParam queryParam : queryParams) {
            requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
        }

        Response response = requestSpecification
                .when()
                .body(jsonObject.toString())
                .post(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "put", queryParams.toString()));

        return new ReadableResponse(response);
    }


    protected ReadableResponse postRequest(JSONArray jsonArray, String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .body(jsonArray.toString())
                .when()
                .post(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "post", jsonArray.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse postRequest(List<QueryParam> queryParams, String endPoint) {
        RequestSpecification requestSpecification = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON);

        for (QueryParam queryParam : queryParams) {
            requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
        }

        Response response = requestSpecification
                .when()
                .post(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "post", queryParams.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse postRequest(RequestSpecification headerSpec, String endPoint) {
        Response response = given()
                .spec(headerSpec)
                .when()
                .post(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Header Spec: %s ", endPoint, "post", headerSpec.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse putRequest(String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .when()
                .put(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s", endPoint, "put"));

        return new ReadableResponse(response);
    }

    protected ReadableResponse putRequest(JSONObject jsonObject, String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .body(jsonObject.toString())
                .when()
                .put(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "put", jsonObject.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse putRequest(List<QueryParam> queryParams, String endPoint) {
        RequestSpecification requestSpecification = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON);

        for (QueryParam queryParam : queryParams) {
            requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
        }

        Response response = requestSpecification
                .when()
                .put(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "put", queryParams.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse putRequest(RequestSpecification headerSpec, String endPoint) {
        Response response = given()
                .spec(headerSpec)
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .when()
                .put(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Header Spec: %s ", endPoint, "put", headerSpec.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse putRequest(JSONObject jsonObject, String endPoint, List<QueryParam> queryParams) {
        RequestSpecification requestSpecification = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON);

        for (QueryParam queryParam : queryParams) {
            requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
        }

        Response response = requestSpecification
                .when()
                .body(jsonObject.toString())
                .put(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "put", queryParams.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse deleteRequest(String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .when()
                .delete(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s", endPoint, "delete"));

        return new ReadableResponse(response);
    }

    protected ReadableResponse deleteRequest(JSONObject jsonObject, String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .body(jsonObject.toString())
                .when()
                .delete(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "delete", jsonObject.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse deleteRequest(List<QueryParam> queryParams, String endPoint) {
        RequestSpecification requestSpecification = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON);

        for (QueryParam queryParam : queryParams) {
            requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
        }

        Response response = requestSpecification
                .when()
                .delete(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "delete", queryParams.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse deleteRequest(RequestSpecification headerSpec, String endPoint) {
        Response response = given()
                .spec(headerSpec)
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .when()
                .delete(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Header Spec: %s ", endPoint, "delete", headerSpec.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse patchRequest(String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .when()
                .patch(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s", endPoint, "patch"));

        return new ReadableResponse(response);
    }

    protected ReadableResponse patchRequest(JSONObject jsonObject, String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .body(jsonObject.toString())
                .when()
                .patch(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "patch", jsonObject.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse patchRequest(List<QueryParam> queryParams,JSONObject jsonObject, String endPoint) {
        RequestSpecification requestSpecification = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .body(jsonObject.toString());

        for (QueryParam queryParam : queryParams) {
            requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
        }

        Response response = requestSpecification
                .when()
                .patch(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "patch", queryParams.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse patchRequest(RequestSpecification headerSpec, String endPoint) {
        Response response = given()
                .spec(headerSpec)
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .when()
                .patch(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Header Spec: %s ", endPoint, "patch", headerSpec.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse headRequest(String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .when()
                .head(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s", endPoint, "head"));

        return new ReadableResponse(response);
    }

    protected ReadableResponse headRequest(JSONObject jsonObject, String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .body(jsonObject.toString())
                .when()
                .head(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "head", jsonObject.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse headRequest(List<QueryParam> queryParams, String endPoint) {
        RequestSpecification requestSpecification = given()
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON);

        for (QueryParam queryParam : queryParams) {
            requestSpecification.queryParam(queryParam.getKey(), queryParam.getValue());
        }

        Response response = requestSpecification
                .when()
                .head(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Body: %s ", endPoint, "head", queryParams.toString()));

        return new ReadableResponse(response);
    }

    protected ReadableResponse headRequest(RequestSpecification headerSpec, String endPoint) {
        Response response = given()
                .spec(headerSpec)
                .spec(spec)
                .header(Keywords.CONTENT_TYPE, Keywords.APPLICATION_JSON)
                .when()
                .head(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s, Header Spec: %s ", endPoint, "head", headerSpec.toString()));

        return new ReadableResponse(response);
    }

    public RequestSpecification getSpec() {
        return spec;
    }
}
