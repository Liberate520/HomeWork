package family_tree.model.service;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;
import family_tree.model.builder.HumanBuilder;
import family_tree.model.human.enum_for_human.Gender;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {
    private HumanBuilder humanBuilder;
    private FamilyTree<Human> humanList;

    public Service() {
        humanList = new FamilyTree();
        humanBuilder = new HumanBuilder();
    }

    public void addHuman(String firstName, String patronymic, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father){
        Human human = humanBuilder.build(firstName,patronymic,lastName, gender, birthDate,deathDate, mother, father);
        humanList.add(human);
    }

    public void addHuman(String firstName, String patronymic, String lastName, Gender gender, LocalDate birthDate){
        Human human = humanBuilder.build(firstName, patronymic, lastName, gender, birthDate);
        humanList.add(human);
    }

    public String getFamilyTreeInfo(){
        return humanList.toString();
    }

    public Human getById(int id){
        return (Human) humanList.getById(id);
    }

    //Sort for parameters

    public void sortByName(){
        humanList.comparatorByName();
    }

    public void sortByBirthday(){
        humanList.comparatorByBirthDate();
    }


    public void saveTree(Service tree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);
    }

    public Service readTree() {
        FileHandler fileHandler = new FileHandler();
        return (Service) fileHandler.read();
    }
}