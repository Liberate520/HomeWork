package group.model.sevice;

import group.model.*;
import group.model.SaveReed.FileHandler;

import java.time.LocalDate;



public class Service {

    private int Id;
    private FamilyTree familyTree;
    private FileHandler fileHandler;




    public Service() {
        familyTree = new FamilyTree<>();



    }


    public String getHumansListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список Родственниов:\n");

        for (Object human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByDeathDate() {
        familyTree.sortByDeathDate();
    }

    public void addHuman(String name, Gender gender, Human parent1, Human parent2, LocalDate birthDate, LocalDate deathDate) {
        Human human = new Human(Id++,name,gender,parent1,parent2,birthDate, null);
        familyTree.add(human);
    }



    public void addWedding(int Id1,int Id2){
        familyTree.setWedding(Id1, Id2);
    }

    public  void getById (int Id){familyTree.getById(Id);}

    public void addToParents(Human human){
        familyTree.addToParents(human);
    }

    public void addToChildren(Human human){
        familyTree.addToChildren(human);
    }

    public static FamilyTree read(){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/group/model/SaveReed/Tree.txt";
        return (FamilyTree) fileHandler.read(filePath);
    }

    public static void save(FamilyTree familyTree){
        FileHandler fileHandler = new FileHandler();
        String filePath = "src/group/model/SaveReed/Tree.txt";
        fileHandler.save(familyTree,filePath);
    }





}