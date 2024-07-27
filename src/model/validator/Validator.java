package model.validator;

import model.builder.Gender;

import java.time.LocalDate;

public interface Validator {
    boolean validateName(String name);
    String getNameErrorMessage();
    boolean validateBirthDate(String birthDateStr);
    LocalDate getValidatedBirthDate();
    String getBirthDateErrorMessage();
    boolean validateGender(int genderOption);
    Gender getValidatedGender(int genderOption);
    boolean validateDeathDate(String deathDateStr);
    LocalDate getValidatedDeathDate();
    String getDeathDateErrorMessage();
    boolean validateNumericChoice(String choice, int min, int max);
    String getNumericChoiceErrorMessage();
}
