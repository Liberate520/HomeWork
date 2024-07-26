package familyTree.HumanBuilder;

import familyTree.human.Gender;
import familyTree.human.Human;

import java.time.LocalDate;
import java.util.List;


public class HumanBuilder {
    private long humID;
    private Human human;
    private String lastName;
    private String firstname;
    private String patronymic;
    private Gender gender;
    private LocalDate dayBirth;
    private LocalDate dayDeath;
    private Human father;
    private Human mother;
    private List<Human> children;
    private String placeBorn;


    public HumanBuilder() {
    }

    private void createHuman() {
        human = new Human();

    }

    private void createLastName() {

        human.setLastName(lastName);
    }

    private void createFirstName() {

        human.setFirstname(firstname);
    }

    private void createPatronymic() {
        human.setPatronymic(patronymic);
    }

    private void createGender() {
        human.setGender(gender);
    }

    private void createDayBirth() {
        try {
            human.setDayBirth(dayBirth);
        } catch (Exception ex) {
            human.setDayBirth(null);
        }
    }

    private void createDayDeath() {
        try {
            human.setDayDeath(dayDeath);
        } catch (Exception ex) {
            human.setDayDeath(null);
        }
    }

    private void createFather() {
        human.setFather(father);
    }

    private void createMother() {
        human.setMother(mother);
    }

    private void createChildren() {
        human.setChildren(children);
    }

    private void createPlaceBorn() {
        human.setPlaceBorn(null);
        human.setPlaceBorn(placeBorn);
    }

    public HumanBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public HumanBuilder setFirstname(String firstname) {
        this.firstname = null;
        this.firstname = firstname;
        return this;
    }

    public HumanBuilder setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public HumanBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public HumanBuilder setDayBirth(LocalDate dayBirth) {
        this.dayBirth = dayBirth;
        return this;
    }

    public HumanBuilder setDayDeath(LocalDate dayDeath) {
        this.dayDeath = dayDeath;
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

    public HumanBuilder setChildren(List<Human> children) {
        this.children = children;
        return this;
    }

    public HumanBuilder setPlaceBorn(String placeBorn) {
        this.placeBorn = null;
        this.placeBorn = placeBorn;
        return this;
    }

    private void setHumID(Human human) {
        human.setID(humID++);

    }

    private void clearData() {
        lastName = null;
        patronymic = null;
        gender = null;
        dayBirth = null;
        dayDeath = null;
        father = null;
        mother = null;
        children = null;
        placeBorn = null;
    }


    public Human build() {
        createHuman();
        createLastName();
        createFirstName();
        createPatronymic();
        createGender();
        createDayBirth();
        createDayDeath();
        createFather();
        createMother();
        createChildren();
        createPlaceBorn();
        setHumID(human);
        clearData();
        return human;
    }

}
