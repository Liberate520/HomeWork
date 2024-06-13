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

        //System.out.println(this.familyTree.humanList.get(0).getName());
        for(Human human: familyTree){
            //System.out.println(this.familyTree.humanList.get(0).getName());
            //System.out.println("==================================================");
            //System.out.println(this.familyTree.getAllInfo());
            //System.out.println("==================================================");

            stringBuilder.append(human.toString());
            stringBuilder.append("\n");
        }
        return  stringBuilder.toString();
    }
}
