package za.ac.cput.factory;

import za.ac.cput.domain.Feedback;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FeedbackFactoryTest {

    @Test
    @Order(1)
    void buildFeedbackWithValidDetails() {
        Feedback feedback = FeedbackFactory.createFeedback("JohnDoe", "Great service!", 5);
        assertNotNull(feedback);
        assertEquals("JohnDoe", feedback.getUserName());
        assertEquals("Great service!", feedback.getFeedbackText());
        assertEquals(5, feedback.getRating());
        System.out.println(feedback);
    }

    @Test
    @Order(2)
    void buildFeedbackWithInvalidUserName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FeedbackFactory.createFeedback("", "Great service!", 5);
        });
        assertEquals("User name is required", exception.getMessage());
    }

    @Test
    @Order(3)
    void buildFeedbackWithEmptyFeedbackText() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FeedbackFactory.createFeedback("JohnDoe", "", 5);
        });
        assertEquals("Feedback text is required", exception.getMessage());
    }

    @Test
    @Order(4)
    void buildFeedbackWithInvalidRating() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FeedbackFactory.createFeedback("JohnDoe", "Great service!", 6);
        });
        assertEquals("Rating must be between 1 and 5", exception.getMessage());
    }
}
