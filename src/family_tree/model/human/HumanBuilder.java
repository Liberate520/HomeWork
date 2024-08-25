package family_tree.model.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanBuilder {
    private int humanId;
    private Human human;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private List<Human> children;

    public HumanBuilder(){
        createHuman();
    }

    public HumanBuilder setName(String name){
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

    public void setChildren() {
        human.setChildren(new ArrayList<>());
    }

    public void createHuman(){
        human = new Human();
    }

    private void nextId(){
        human.setId(humanId++);
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

    public Human build(){
        createHuman();
        createName();
        createGender();
        createBirthDate();
        nextId();
        setChildren();
        return human;
    }
}