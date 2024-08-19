package ru.gb.family_tree.human;

import ru.gb.family_tree.family_tree.FamilyTree;

public class HumanService {
    private FamilyTree familyTree;
    private HumanBuilder builder;

    public HumanService() {
        familyTree = new FamilyTree();
        builder = new HumanBuilder();
    }

    public void addHuman(String humanName, int humanAge){
        Human human = builder
                .setHumanName(humanName)
                .setHumanAge(humanAge)
                .build();
        familyTree.addHuman(human);
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByAge(){
        familyTree.sortByAge();
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
