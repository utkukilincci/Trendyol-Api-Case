package serviceBase;

import io.restassured.response.Response;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ReadableResponse {
    private int statusCode;
    private String statusLine;
    private Response response;

    public ReadableResponse(Response response) {
        this.response = response;
        this.statusCode = response.getStatusCode();
        this.statusLine = response.getStatusLine();
    }

    public String getBodyMessage(String path) {
        return response.path(path).toString()
                .replace("[", "")
                .replace("]", "");
    }

    public List<LinkedHashMap<String, Object>> getBodyMessageAsLinkedList(String path) {
        return response.body().jsonPath().getList(path);
    }

    public LinkedHashMap<String, Object> getBodyMessageAsLinkedHashMap(String path) {
        return response.path(path);
    }

    public List<String> getBodyMessageList(String path) {
        return response.body().jsonPath().getList(path);
    }

    public List<Integer> getBodyMessageListAsInteger(String path) {
        return response.body().jsonPath().getList(path);
    }

    public <T> List<T> getBodyMessageListAsObject(String path) {
        return response.body().jsonPath().getList(path);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusLine() {
        return statusLine;
    }

    public Response getResponse() {
        return this.response;
    }

    public String getFullBodyMessage() {
        return response.print();
    }

    public boolean isPathExist(String path) {
        return response.path(path) != null;
    }

    public LinkedHashMap<String, Object> searchAndGetData(String path, String searchedKey, Object searchValue) {
        List<LinkedHashMap<String, Object>> result = getBodyMessageAsLinkedList(path);

        return result.stream()
                .filter(eachResult -> String.valueOf(eachResult.get(searchedKey)).equals(String.valueOf(searchValue)))
                .findFirst().orElse(null);
    }

    public List<LinkedHashMap<String, Object>> searchAndGetDataList(String path, String searchedKey, Object searchValue) {
        List<LinkedHashMap<String, Object>> result = getBodyMessageAsLinkedList(path);
        return result.stream()
                .filter(eachResult -> String.valueOf(eachResult.get(searchedKey)).equals(String.valueOf(searchValue)))
                .collect(Collectors.toList());
    }


    public int getIndexOfObjectInPath(String path, Object indexOfObject) {
        return getBodyMessageList(path).indexOf(indexOfObject);
    }
}
