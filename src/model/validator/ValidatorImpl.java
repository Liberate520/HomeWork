package model.validator;

import model.builder.Gender;
import java.time.LocalDate;

public class ValidatorImpl implements Validator {
    private LocalDate validatedBirthDate;
    private LocalDate validatedDeathDate;
    private LengthNameValidator lengthNameValidator = new LengthNameValidator();
    private BirthDateValidator birthDateValidator = new BirthDateValidator();
    private DeathDateValidator deathDateValidator = new DeathDateValidator();
    private NumericRangeValidator numericRangeValidator = new NumericRangeValidator();

    @Override
    public boolean validateName(String name) {
        return lengthNameValidator.validate(name);
    }

    @Override
    public String getNameErrorMessage() {
        return lengthNameValidator.getErrorMessage();
    }

    @Override
    public boolean validateBirthDate(String birthDateStr) {
        if (birthDateValidator.validate(birthDateStr)) {
            validatedBirthDate = birthDateValidator.getBirthDate();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public LocalDate getValidatedBirthDate() {
        return validatedBirthDate;
    }

    @Override
    public String getBirthDateErrorMessage() {
        return birthDateValidator.getErrorMessage();
    }

    @Override
    public boolean validateGender(int genderOption) {
        return genderOption == 1 || genderOption == 2;
    }

    @Override
    public Gender getValidatedGender(int genderOption) {
        return genderOption == 1 ? Gender.MALE : genderOption == 2 ? Gender.FEMALE : null;
    }

    @Override
    public boolean validateDeathDate(String deathDateStr) {
        if (deathDateValidator.validate(deathDateStr)) {
            validatedDeathDate = deathDateValidator.getDeathDate();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public LocalDate getValidatedDeathDate() {
        return validatedDeathDate;
    }

    @Override
    public String getDeathDateErrorMessage() {
        return deathDateValidator.getErrorMessage();
    }

    @Override
    public boolean validateNumericChoice(String choice, int min, int max) {
        return numericRangeValidator.validate(choice, min, max);
    }

    @Override
    public String getNumericChoiceErrorMessage() {
        return numericRangeValidator.getErrorMessage();
    }
}


