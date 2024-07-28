package Family_tree.service;

import java.time.LocalDate;

import Family_tree.builder.HumanBuilder;
import Family_tree.family_tree.FamilyTree;
import Family_tree.human.Gender;
import Family_tree.human.Human;

public class Service {
    public FamilyTree tree;
    private HumanBuilder builder;

    public Service() {
        tree = new FamilyTree();
        builder = new HumanBuilder();
    }

    public Human addToTree(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human spouse, Human father, Human mother){
        Human human = builder.build(name, gender, dateOfBirth, dateOfDeath, spouse, father, mother);
        tree.addHuman(human);
        return human;
    }

    public Human addToTree(String name, Gender gender, LocalDate dateOfBirth){
        Human human = builder.build(name, gender, dateOfBirth);
        tree.addHuman(human);
        return human;
    }


    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family members list:\n");

        for (Human human: tree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return getHumanListInfo();
    }

    public void sortByName(){
        tree.sortByName();
    }

    public void sortByAge(){
        tree.sortByAge();
    }
}


