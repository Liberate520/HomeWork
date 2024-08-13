package model.human;

import java.time.LocalDate;
import java.util.List;

import model.places.Place;

public class HumanBuilder {
    private long genId;
    private Human human;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private String nationality;
    private Human father;
    private Human mother;
    private Human spouse;
    private List<Human> children;
    private Place place;

    public HumanBuilder() {
        createHuman();
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

    public HumanBuilder setFather(Human father) {
        this.father = father;
        return this;
    }

    public HumanBuilder setMother(Human mother) {
        this.mother = mother;
        return this;
    }

    public HumanBuilder setSpouse(Human spouse) {
        this.spouse = spouse;
        return this;
    }

    public HumanBuilder setChildren(List<Human> children) {
        this.children = children;
        return this;
    }

    public HumanBuilder setPlace(Place place) {
        this.place = place;
        return this;
    }

    private void createHuman() {
        human = new Human();
    }

    private void nextId() {
        human.setId(genId++);
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

    private void createFather() {
        human.setFather(father);
    }

    private void createMother() {
        human.setMother(mother);
    }

    private void createSpouse() {
        human.setSpouse(spouse);
    }

    private void createChildren() {
        human.setChildren(children);
    }

    private void createPlace() {
        human.setPlace(place);
    }

    public Human build() {
        nextId();
        createFirstName();
        createLastName();
        createPatronymic();
        createBirthDate();
        createDeathDate();
        createGender();
        createNationality();
        createFather();
        createMother();
        createSpouse();
        createChildren();
        createPlace();
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
        father = null;
        mother = null;
        spouse = null;
        children = null;
        place = null;
    }
}
