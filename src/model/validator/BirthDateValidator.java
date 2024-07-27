package model.validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BirthDateValidator {
    private String errorMessage;
    private LocalDate birthDate;

    public boolean validate(String input) {
        try {
            birthDate = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);
            return true;
        } catch (DateTimeParseException e) {
            errorMessage = "Неверный формат даты. Попробуйте снова. (формат: YYYY-MM-DD)";
            return false;
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
