package helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    public static final String FORMAT_YYYYMMDDHHMM = "yyyyMMddHHmm";
    public static final String FORMAT_YYYYMMDD = "dd/MM/yyyy";

    public  static String getCurrentDateTimeNoSeparators() {
        return LocalDateTime.now().format(getFormatterDateTimeNoSeparators());
    }

    public  static String getDateYearsFromNowWithSlashes(int plusYears){
        LocalDateTime date = LocalDateTime.now().plusYears(plusYears);
        return date.format(getFormatterDateTimeWithSlashes());
    }

    public static DateTimeFormatter getFormatterDateTimeNoSeparators() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_YYYYMMDDHHMM);
        return formatter;
    }

    public static DateTimeFormatter getFormatterDateTimeWithSlashes(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_YYYYMMDD);
        return formatter;
    }
}
