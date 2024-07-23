package ru.gb.family_tree.human;

import ru.gb.family_tree.human.enums.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


public class Human implements Serializable, Comparable<Human>{
    private int id;
    private String name, surname, patronymic;
    private Gender gender;
    private Human father, mother;
    private List<Human> children;
    private String profession, nationality;
    private LocalDate dateOfBirthday, dateOfDeath;
    private String birthPlace;
    private String notes;

    public Human(int id, String name, String patronymic, String surname,
                 Gender gender, Human father, Human mother,
                 List<Human> children, String profession,
                 String nationality, LocalDate dateOfBirthday, LocalDate dateOfDeath,
                 String birthPlace, String notes) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.profession = profession;
        this.nationality = nationality;
        this.dateOfBirthday = dateOfBirthday;
        this.dateOfDeath = dateOfDeath;
        this.birthPlace = birthPlace;
        this.notes = notes;
    }

    public Human(int id, String name, String patronymic, String surname,
                 Gender gender) {
        this(id, name, patronymic, surname, gender, null, null, null, null, null, null, null, null, null);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public String getProfession() {
        return profession;
    }

    public String getNationality() {
        return nationality;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setChildren(Human... children) {
        this.children = Arrays.asList(children);
    }

    public void setChildrenList(List<Human> children) {
        this.children = children;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    private String getChildrenAsString(List<Human> children) {
        String result = "";
        if (children == null) return "Отсутсвуют";
        for (Human child : children) {
            result += child.getName() + " " + child.getPatronymic() + " " +
                    child.getSurname() + "\n";
        }
        if (result == "") {
            return "Отсутсвуют";
        }
        return result;
    }

    private String getDodAsStringIfDead(Human human) {
        if (human.getDateOfDeath() == null) {
            return "";
        }
        return "Дата смерти: " + showRuDate(human.getDateOfDeath()) + '\n';
    }

    private String getFatherAsStringIfThere(Human human) {
        if (human.getFather() == null) {
            return "Неизвестен";
        }
        return human.getFather().getName() + " " + human.getFather().getPatronymic() + " " +
                human.getFather().getSurname() + " ";
    }

    private String getMotherAsStringIfThere(Human human) {
        if (human.getMother() == null) {
            return "Неизвестна";
        }
        return human.getMother().getName() + " " + human.getMother().getPatronymic() + " " +
                human.getMother().getSurname() + " ";

    }

    private String getNotesIfThere(Human human) {
        if (human.getNotes() == null) {
            return "---------------------------";
        }
        return human.getNotes() + '\n' + "---------------------------";
    }

    private String getProfessionIfThere(Human human) {
        if (human.getProfession() == null) {
            return "Неизвестна";
        }
        return human.getProfession();
    }

    private String getNationalityIfThere(Human human) {
        if (human.getNationality() == null) {
            return "Неизвестна";
        }
        return human.getNationality();
    }

    private String getDobAsStringIfThere(Human human) {
        if (human.getDateOfBirthday() == null) {
            return "Неизвестно";
        }
        return showRuDate(human.getDateOfBirthday());
    }

    private String getBirthPlaceIfThere(Human human) {
        if (human.getBirthPlace() == null) {
            return "Неизвестно";
        }
        return human.getBirthPlace();
    }

    private String getRuGender(Gender gender) {
        if (gender == Gender.Male) {
            return "Мужской";
        }
        return "Женский";
    }

    private String showRuDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return date.format(formatter);
    }

    private String generateStringAge(int age) {
        int lastChar = Integer.parseInt(("" + age).substring(("" + age).length() - 1, ("" + age).length()));
        String old = "";
        if (age == 11) old = "лет";
        else if (("" + age).endsWith("1")) old = "год";
        else if (age > 11 && age < 15) old = "лет";
        else if (lastChar > 1 && lastChar < 5) old = "года";
        else old = "лет";
        return old;
    }

    public int getAge(){
        Period period = Period.between(getDateOfBirthday(), LocalDate.now());
        return period.getYears();
    }

    private String showAgeAsStringIfAlive(Human human) {
        if (human.getDateOfBirthday() == null) {
            return "Дата рождения неизвестна";
        }
        int age = human.getAge();
        if (human.getDateOfDeath() != null) {
            Period period = Period.between(human.getDateOfBirthday(), human.getDateOfDeath());
            return "Умер в возрасте: " + period.getYears() + " " + generateStringAge(period.getYears()) + "\n" +
                    "Сейчас было бы: " +  age + " " + generateStringAge(age);
        }
        return age + " " + generateStringAge(age);
    }

    @Override
    public String toString() {
        return "---------------------------" + '\n' +
                "ID: " + id + '\n' +
                "ФИО: " + name + " " + patronymic + " " + surname + " " + '\n' +
                "Пол: " + getRuGender(gender) + '\n' +
                "Отец: " + getFatherAsStringIfThere(this) + '\n' +
                "Мать: " + getMotherAsStringIfThere(this) + '\n' +
                "Дети: " + '\n' + getChildrenAsString(children) + '\n' +
                "Профессия: " + getProfessionIfThere(this) + '\n' +
                "Национальность: " + getNationalityIfThere(this) + '\n' +
                "Дата рождения: " + getDobAsStringIfThere(this) + '\n' +
                getDodAsStringIfDead(this) +
                "Место рождения: " + getBirthPlaceIfThere(this) + '\n' +
                showAgeAsStringIfAlive(this) + '\n' +
                getNotesIfThere(this) + '\n';
    }


    @Override
    public int compareTo(Human anotherHuman) {
        return this.name.compareTo(anotherHuman.name);
    }
}
