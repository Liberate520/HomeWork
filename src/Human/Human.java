package Human;

import FamilyTree;

import java.time.LocalDate;
import java.util.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class Human implements FamilyTree<Human>, Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Human father;
    private Human mother;
    private List<Human> children;
    private String gender;
    private LocalDate dateOfBirth;

    public Human(String name, String gender, LocalDate dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Human getFather() {
        return father;
    }

    @Override
    public void setFather(Human father) {
        this.father = father;
    }

    @Override
    public Human getMother() {
        return mother;
    }

    @Override
    public void setMother(Human mother) {
        this.mother = mother;
    }

    @Override
    public List<Human> getChildren() {
        return children;
    }

    @Override
    public void addChild(Human child) {
        this.children.add(child);
    }

    public String getGender() {
        return gender;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return new String(String.format("%s (Пол: %s, Дата рождения: %s)", name, gender, dateOfBirth).getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }

    @Override
    public Iterator<Human> iterator() {
        return null;
    }
}