package Builder;

import Human.Human;
import Human.Gender;

import java.time.LocalDate;
import java.util.List;

public class HumanBuilder {
    private int genId;
    private Human human;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate = null;
    private List<Human> parents = null;
    private List<Human> children = null;

//    public HumanBuilder(String name, Gender gender, LocalDate birthDate) {
//        this.name = name;
//        this.gender = gender;
//        this.birthDate = birthDate;
//    }

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

    public HumanBuilder setParents(List<Human> parents){
        this.parents = parents;
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
        //human = new Human();
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

    private void createParents(){
        human.setParents(parents.get(0), parents.get(1));
    }

    public Human build(){
        createHuman();
        createName();
        createGender();
        createBirthDate();
        createDeathDate();
        createParents();
        clear();
        return human;
    }

    private void clear(){
        name = null;
        gender = null;
        birthDate = null;
        deathDate = null;
        parents = null;
        children = null;
    }
}
