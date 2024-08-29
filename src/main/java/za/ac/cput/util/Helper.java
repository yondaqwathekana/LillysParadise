package za.ac.cput.util;


import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    public static boolean isNullOrEmpty(Object object){
        if(object == null)
            return true;
        // validating for string
        if(object instanceof String) {return ((String) object).trim().isEmpty(); }
        // validating for Integer, Long, Double
        if(object instanceof Number) { return ((Number) object).doubleValue() == 0; }
        // validating for Boolean
        if(object instanceof Boolean) {return false; }
        // validating for LocalDate
        if(object instanceof LocalDate) {return ((LocalDate) object).equals(LocalDate.MIN); }
        // validating for LocalTime
        if(object instanceof LocalTime) {return ((LocalTime) object).equals(LocalTime.MIN); }
        // validating for Collection
        if (object instanceof Collection) { return ((Collection<?>) object).isEmpty(); }
        // validating for Map
        if (object instanceof Map) { return ((Map<?, ?>) object).isEmpty(); }
        // validating for UUD
        if (object instanceof UUID) {
            return ((UUID) object).equals(new UUID(0, 0));
        }

        return false;
    }

    public static boolean isValidEmail(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

}
