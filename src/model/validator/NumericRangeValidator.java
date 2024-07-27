package model.validator;

public class NumericRangeValidator {
    private String errorMessage;

    public boolean validate(String input, int min, int max) {
        try {
            int value = Integer.parseInt(input);
            if (value >= min && value <= max) {
                return true;
            } else {
                errorMessage = "Введите число от " + min + " до " + max + ".";
                if(min == max) {
                    String strNum = "";
                    if(min < 10){
                        strNum = "цифру";
                    } else {
                        strNum = "число";
                    }
                    errorMessage = "Введите " + strNum + " " + min + ".";
                }
                return false;
            }
        } catch (NumberFormatException e) {
            errorMessage = "Введите только цифры.";
            return false;
        }
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

