package za.ac.cput.factory;

import za.ac.cput.domain.Feedback;
import za.ac.cput.util.Helper;

public class FeedbackFactory {

    public static Feedback createFeedback(String userName, String feedbackText, int rating) {
        if(Helper.isNullOrEmpty(userName) || Helper.isNullOrEmpty(feedbackText) || Helper.isNullOrEmpty(rating))
            return null;
        return new Feedback.Builder()
                .setUserName(userName)
                .setFeedbackText(feedbackText)
                .setRating(rating)
                .build();
    }
}
