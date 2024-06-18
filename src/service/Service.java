package service;


import human.Human;
import tree.FamilyTree;

public class Service {
    private FamilyTree familyTree;
    public Service(FamilyTree familyTree){
        this.familyTree = familyTree;


    }



    public String getHumanListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Person List\n");
        for(Human human: familyTree){
            stringBuilder.append(human.toString());
            stringBuilder.append("\n");
        }
        return  stringBuilder.toString();
    }

}
