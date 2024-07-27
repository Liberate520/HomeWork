package model.validator;

public class LengthNameValidator {
    private String errorMessage;
    private LengthValidator lengthValidator;
    private AlphabeticValidator alphabeticValidator;

    public LengthNameValidator() {
        this.lengthValidator = new LengthValidator();
        this.alphabeticValidator = new AlphabeticValidator();
    }

    public boolean validate(String input) {
        boolean isLengthValid = lengthValidator.validate(input);
        boolean isAlphabeticValid = alphabeticValidator.validate(input);

        if (isLengthValid && isAlphabeticValid) {
            return true;
        } else {
            if (!isLengthValid) {
                errorMessage = lengthValidator.getErrorMessage();
            } else {
                errorMessage = alphabeticValidator.getErrorMessage();
            }
            return false;
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
