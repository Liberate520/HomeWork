package model.format;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatUtils implements Serializable {
    public String getDatePointFormat(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return date.format(formatter);
    }

    public String getYearDeclension(int years) {
        if (years % 10 == 1 && years % 100 != 11) {
            return "год";
        } else if ((years % 10 >= 2 && years % 10 <= 4) && !(years % 100 >= 12 && years % 100 <= 14)) {
            return "года";
        } else {
            return "лет";
        }
    }
}
