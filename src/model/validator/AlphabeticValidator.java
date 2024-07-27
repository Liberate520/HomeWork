package model.validator;

public class AlphabeticValidator {
    private String errorMessage;

    public boolean validate(String input) {
        if (input.matches("[a-zA-Zа-яА-Я]+")) {
            return true;
        } else {
            errorMessage = "Имя должно содержать только буквы латиницы или кириллицы.";
            return false;
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
