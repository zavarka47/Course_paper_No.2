package Course_paper;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataTimeService {
    private static final String DATA_TIME_FORMAT = "dd.MM.yyyy HH:mm";
    private static final String DATA_FORMAT = "dd.MM.yyyy";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATA_TIME_FORMAT);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATA_FORMAT);



    public static LocalDateTime addLocalDateTime (String localDateTime) {
            LocalDateTime ldt = LocalDateTime.parse(localDateTime, DATE_TIME_FORMATTER);
            return ldt;

    }

    public static LocalDate addLocalDate (String localDate) throws DateTimeParseException{
        LocalDate ld = LocalDate.parse(localDate, DATE_FORMATTER);
        return ld;
    }

/*    public static String getDataFormat(){
        return DATA_FORMAT;
    }
    public static String getDataTimeFormat(){
        return DATA_TIME_FORMAT;
    }

    public static DateTimeFormatter getDataFormatter(){
        return DATE_FORMATTER;
    }
    public static DateTimeFormatter getDataTimeFormatter(){
        return DATE_TIME_FORMATTER;
    }*/

    public static String printDataTime (LocalDateTime localDateTime){
        return DATE_TIME_FORMATTER.format(localDateTime);
    }
}
