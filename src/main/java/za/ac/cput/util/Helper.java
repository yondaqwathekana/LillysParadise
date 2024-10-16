package za.ac.cput.util;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

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
        if(object instanceof LocalDate) {return object.equals(LocalDate.MIN); }
        // validating for LocalTime
        if(object instanceof LocalTime) {return object.equals(LocalTime.MIN); }
        // validating for Collection
        if (object instanceof Collection) { return ((Collection<?>) object).isEmpty(); }
        // validating for Map
        if (object instanceof Map) { return ((Map<?, ?>) object).isEmpty(); }
        // validating for UUID
        if (object instanceof UUID) { return object.equals(new UUID(0, 0)); }

        return false;
    }

}
