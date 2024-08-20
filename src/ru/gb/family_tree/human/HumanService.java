package ru.gb.family_tree.human;

import ru.gb.family_tree.family_tree.FamilyTree;

import java.time.LocalDate;
import java.util.List;

public class HumanService {
    private FamilyTree familyTree;
    private HumanBuilder builder;

    public HumanService() {
        familyTree = new FamilyTree();
        builder = new HumanBuilder();
    }

    public void addHuman(String humanName, int humanAge, LocalDate humanBirthday){
        Human human = builder
                .setHumanName(humanName)
                .setHumanBirthDate(humanBirthday)
                .build();
        familyTree.addHuman(human);
    }

    public void addHumans(List<Human> humans){
        familyTree.addHumans(humans);
    }

    public void sortById(){
        familyTree.sortById();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public List<Human> getHumans(){
        return familyTree.getHumans();
    }

    public String getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список человеков:\n");
        for (Human human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
