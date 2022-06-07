package matchers;

import models.PlayList;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import serviceBase.ReadableResponse;

import static java.lang.String.format;

public class UsersEndpointMatchers {
    public static Matcher<ReadableResponse> shouldCreatedPlaylist(PlayList playlist) {
        return new BaseMatcher<ReadableResponse>() {

            @Override
            public boolean matches(final Object item) {
                ReadableResponse response = (ReadableResponse) item;

                return !response.getBodyMessage("id").isEmpty() &&
                        response.getBodyMessage("name").equals(playlist.getName()) &&
                        response.getBodyMessage("description").equals(playlist.getDescription()) &&
                        response.getBodyMessage("public").equals(playlist.getIsPublic().toString());
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("Response should have created playlist info, ")
                        .appendValue(
                                format("playlist name: %s. description: %s. isPublic: %s.",
                                        playlist.getName(), playlist.getDescription(), playlist.getIsPublic())
                        );
            }

            @Override
            public void describeMismatch(Object item, Description description) {
                description.appendText("not found!");
            }
        };
    }
}
