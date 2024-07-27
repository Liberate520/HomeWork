package model.validator;

public class LengthValidator {
    private String errorMessage;

    public boolean validate(String input) {
        if (input.length() > 1) {
            return true;
        } else {
            errorMessage = "Длина имени должна быть больше одного символа.";
            return false;
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
