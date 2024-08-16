package model.human;

import java.time.LocalDate;

public class HumanBuilder {
    private long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private String nationality;
    private Human human;

    public HumanBuilder() {
        createHuman();
    }

    public HumanBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public HumanBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public HumanBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public HumanBuilder setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public HumanBuilder setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public HumanBuilder setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
        return this;
    }

    public HumanBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public HumanBuilder setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    private void createHuman() {
        human = new Human();
    }

    private void nextId() {
        human.setId(id);
    }

    private void createFirstName() {
        human.setFirstName(firstName);
    }

    private void createLastName() {
        human.setLastName(lastName);
    }

    private void createPatronymic() {
        human.setPatronymic(patronymic);
    }

    private void createBirthDate() {
        human.setBirthDate(birthDate);
    }

    private void createDeathDate() {
        human.setDeathDate(deathDate);
    }

    private void createGender() {
        human.setGender(gender);
    }

    private void createNationality() {
        human.setNationality(nationality);
    }

    public Human build() {
        createHuman();
        nextId();
        createFirstName();
        createLastName();
        createPatronymic();
        createBirthDate();
        createDeathDate();
        createGender();
        createNationality();
        clear();
        return human;
    }

    private void clear() {
        firstName = null;
        lastName = null;
        patronymic = null;
        birthDate = null;
        deathDate = null;
        gender = null;
        nationality = null;
    }
}