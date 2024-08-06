package Model.Builder;

import Model.Human.Human;
import Model.Human.Gender;

import java.time.LocalDate;
import java.util.List;

public class HumanBuilder {
    private int genId;
    private Human human;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate = null;
    private Human mother = null;
    private Human father = null;
    private List<Human> children = null;

    public HumanBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public HumanBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public HumanBuilder setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public HumanBuilder setDeathDate(LocalDate deathDate){
        this.deathDate = deathDate;
        return this;
    }

    public HumanBuilder setMother(Human mother) {
        this.mother = mother;
        return this;
    }

    public HumanBuilder setFather(Human father) {
        this.father = father;
        return this;
    }

    public HumanBuilder setChildren(List<Human> children){
        this.children = children;
        return this;
    }

    private void nextID(){
        human.setId(genId++);
    }
    private void createHuman(){
        human = new Human();
    }

    private void createName(){
        human.setName(name);
    }

    private void createGender(){
        human.setGender(gender);
    }

    private void createBirthDate(){
        human.setBirthDate(birthDate);
    }

    private void createDeathDate(){
        human.setDeathDate(deathDate);
    }

    private void createMother(){
        human.setMother(mother);
    }

    private void createFather(){
        human.setFather(father);
    }

    public Human build(){
        createHuman();
        createName();
        createGender();
        createBirthDate();
        createDeathDate();
        createMother();
        createFather();
        clear();
        return human;
    }

    private void clear(){
        name = null;
        gender = null;
        birthDate = null;
        deathDate = null;
        mother = null;
        father = null;
        children = null;
    }
}
