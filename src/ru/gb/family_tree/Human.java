package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    String name, locationAddress;
    Gender gender;
    LocalDate dateBirthday, dateDeathday;
    List<String> phoneNumbers = new ArrayList<>();
    List<String> children = new ArrayList<>();
    Human mother, father;

    public Human(String name, String gender) {
        this.name = name;
        this.gender = Gender.valueOf(gender);
    }

    public void setBirthday(LocalDate dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public void setDeathday(LocalDate dateDeathday) {
        this.dateDeathday = dateDeathday;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public void addPhoneNumber(String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void addChild(Human child) {
        this.children.add(child.name);
    }

    public StringBuilder getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nДанные члена семьи " + this.name + ":\n");
        sb.append("пол - " + this.gender + ";\n");
        if (this.dateBirthday != null) sb.append("дата рождения - " + this.dateBirthday + ";\n");
        if (this.dateDeathday != null) sb.append("дата смерти - " + this.dateDeathday + ";\n");
        if (this.locationAddress != null) sb.append("адрес проживания - " + this.locationAddress + ";\n");
        if (this.phoneNumbers.size() > 0) sb.append("телефон - " + this.phoneNumbers + ";\n");
        if (this.mother != null) sb.append("мать - " + this.mother.name + ";\n");
        if (this.father != null) sb.append("отец - " + this.father.name + ";\n");
        if (this.children.size() > 0) sb.append("дети - " + this.children + ";\n");
        sb.append("На текущий момент это вся доступная информация!\n");
        return sb;

    }

}
