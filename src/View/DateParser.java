package src.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class DateParser {

    final List<String> dateFormats = Arrays.asList("yyyy, MM, dd", "yyyy-MM-dd", "yyyy MM dd", "yyyy-MM-dd",
            "yyyy/MM/dd");

    public LocalDate parseDate(String date) {
        for (String format : dateFormats) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            try {
                LocalDate parsed = LocalDate.parse(date, formatter);
                return parsed;
            } catch (DateTimeParseException e) {
            }
        }
        return null;
    }
}
