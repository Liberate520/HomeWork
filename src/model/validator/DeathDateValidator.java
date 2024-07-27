package model.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DeathDateValidator {
    private LocalDate deathDate;
    private String errorMessage;

    public boolean validate(String input) {
        try {
            deathDate = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
            return true;
        } catch (DateTimeParseException e) {
            errorMessage = "Неверный формат даты смерти. Используйте формат YYYY-MM-DD.";
            return false;
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }
}
