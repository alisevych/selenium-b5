package helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    public static final String FORMAT_YYYYMMDDHHMM = "yyyyMMddHHmm";

    public  static String getCurrentDateTimeNoSeparators() {
        return LocalDateTime.now().format(getFormatterDateTimeNoSeparators());
    }

    public static DateTimeFormatter getFormatterDateTimeNoSeparators() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_YYYYMMDDHHMM);
        return formatter;
    }

}
