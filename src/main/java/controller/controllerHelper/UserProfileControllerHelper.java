package controller.controllerHelper;

import controller.UserProfileController;
import serviceBase.ReadableResponse;

import static matchers.BaseMatchers.shouldStatusCodeSameAs;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserProfileControllerHelper {
    UserProfileController userProfileController = new UserProfileController();

    public String getUserId() {
        ReadableResponse response = userProfileController.getUserId();

        assertThat("When a user tries to get user id, ", response, shouldStatusCodeSameAs(SC_OK));

        return response.getBodyMessage("id");
    }
}
