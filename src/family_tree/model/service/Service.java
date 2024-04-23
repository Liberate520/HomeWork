package family_tree.model.service;

import family_tree.model.FamilyTree.FamilyTree;
import family_tree.model.Human.Gender;
import family_tree.model.Human.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {


    private final FamilyTree<Human> familyTree;
    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private Gender gender;
    private List<Human> children;
    private Human mother;
    private Human father;



    public Service(){
        familyTree = new FamilyTree<>();
        List<Human> children = new ArrayList<>();
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod, Gender gender, List<Human> children, Human mother, Human father){
        Human human = new Human(name, dob, dod, gender, children, mother, father);
        familyTree.addHuman(human);
    }

    public List<Human> getHumanChildren(Human human){
        return familyTree.getHumanChildren(human);
    }

    public void addChild(Human child, Human human) {
//
        human.addChild(child);
    }

    public void setMother(Human mother, Human human) {
        human.setMother(mother);
    }

    public void setFather(Human father, Human human) {
        human.setFather(father);
    }

    public String getHumanListInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное дерево:\n");
        for(Human human:familyTree){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();

    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByBirthday(){
        familyTree.sortByBirthday();
    }
}
