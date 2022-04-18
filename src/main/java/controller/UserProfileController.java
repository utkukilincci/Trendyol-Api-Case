package controller;

import serviceBase.GeneralApiController;
import serviceBase.ReadableResponse;

import static base.Keywords.*;
import static base.Keywords.token;

public class UserProfileController extends GeneralApiController {

    public UserProfileController() {
        super(BASE_URL);
        getSpec().header(AUTHORIZATION,"Bearer " + token);
    }

    public ReadableResponse getUserId() {
        return getRequest("/me");
    }
}
