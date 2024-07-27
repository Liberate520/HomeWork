package model.service;

import model.builder.Gender;
import model.validator.ValidatorImpl;

import java.time.LocalDate;

public class ServiceValidate {
    private ValidatorImpl validator;

    public ServiceValidate() {
        this.validator = new ValidatorImpl();
    }

    public boolean validateName(String name) {
        return validator.validateName(name);
    }

    public String getNameErrorMessage() {
        return validator.getNameErrorMessage();
    }

    public boolean validateBirthDate(String birthDateStr) {
        return validator.validateBirthDate(birthDateStr);
    }

    public LocalDate getValidatedBirthDate() {
        return validator.getValidatedBirthDate();
    }

    public String getBirthDateErrorMessage() {
        return validator.getBirthDateErrorMessage();
    }

    public boolean validateGender(int genderOption) {
        return validator.validateGender(genderOption);
    }

    public Gender getValidatedGender(int genderOption) {
        return validator.getValidatedGender(genderOption);
    }

    public boolean validateDeathDate(String deathDateStr) {
        return validator.validateDeathDate(deathDateStr);
    }

    public LocalDate getValidatedDeathDate() {
        return validator.getValidatedDeathDate();
    }

    public String getDeathDateErrorMessage() {
        return validator.getDeathDateErrorMessage();
    }

    public boolean validateNumericChoice(String choice, int min, int max) {
        return validator.validateNumericChoice(choice, min, max);
    }

    public String getNumericChoiceErrorMessage() {
        return validator.getNumericChoiceErrorMessage();
    }
}
