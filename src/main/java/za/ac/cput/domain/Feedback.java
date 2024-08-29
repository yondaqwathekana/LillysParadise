package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String feedbackText;
    private int rating;

    protected Feedback() {}

    public Feedback(Builder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.feedbackText = builder.feedbackText;
        this.rating = builder.rating;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Feedback feedback = (Feedback) object;
        return id == feedback.id &&
               rating == feedback.rating &&
               Objects.equals(userName, feedback.userName) &&
               Objects.equals(feedbackText, feedback.feedbackText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, feedbackText, rating);
    }

    @Override
    public String toString() {
        return "Feedback{" +
               "id=" + id +
               ", userName='" + userName + '\'' +
               ", feedbackText='" + feedbackText + '\'' +
               ", rating=" + rating +
               '}';
    }

    public static class Builder {
        private long id;
        private String userName;
        private String feedbackText;
        private int rating;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setFeedbackText(String feedbackText) {
            this.feedbackText = feedbackText;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder copy(Feedback feedback) {
            this.id = feedback.id;
            this.userName = feedback.userName;
            this.feedbackText = feedback.feedbackText;
            this.rating = feedback.rating;
            return this;
        }

        public Feedback build() {
            return new Feedback(this);
        }
    }
}
