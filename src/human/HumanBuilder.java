package human;

import family_tree.FamilyTreeItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanBuilder<E extends FamilyTreeItem<E>> {
    private int genId;
    private Human human;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private List<Human> children;

    public HumanBuilder(){
        createHuman();
    }

    public HumanBuilder<E> setName(String name){
        this.name = name;
        return this;
    }
    public HumanBuilder<E> setGender(Gender gender){
        this.gender = gender;
        return this;
    }
    public HumanBuilder<E> setBirthDate(LocalDate birthdate){
        this.birthDate = birthdate;
        return this;
    }
    private void setChildren(){
        human.setChildren(new ArrayList<>());
    }
    private void createHuman(){
        human = new Human();
    }
    private void nextId(){
        human.setId(genId++);
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
    public E build(){
        createHuman();
        createName();
        createGender();
        createBirthDate();
        nextId();
        setChildren();
        return (E) human;
    }
}
