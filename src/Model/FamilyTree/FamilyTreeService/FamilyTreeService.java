package Model.FamilyTree.FamilyTreeService;

import Model.FamilyTree.FamilyMember;
import Model.FamilyTree.FamilyTree;
import Model.FamilyTree.Sorter;
import Model.Human.Gender;
import Model.Human.Human;
import Model.Human.HumanBuilder.HumanBuilder;

import java.time.LocalDate;

public class FamilyTreeService {
    public HumanBuilder newHumanBuilder;
    public FamilyTree newFamilyTree;
    private static FamilyTreeService instance;

    private FamilyTreeService() {
        newHumanBuilder = new HumanBuilder();
        newFamilyTree = new FamilyTree();
    }
    public static FamilyTreeService getInstance() {
        if (instance == null) {
            System.out.println("Creating new instance of FamilyTreeService");
            instance = new FamilyTreeService();
        }
        return instance;
    }
    public Human addToTree(String name, Gender gender, LocalDate dateOfBirth){
        Human human = newHumanBuilder.build(name, gender, dateOfBirth);
        newFamilyTree.addHumantoTree(human);
        return human;
    }

    public Human addToTree(String name, Gender gender, LocalDate dateOfBirth, Human father, Human mother) {
        Human human = newHumanBuilder.build(name, gender, dateOfBirth, father, mother);
        newFamilyTree.addHumantoTree(human);
        return human;
    }
    public String getFamilyTreeInfo(){
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Семейное дерево:\n");
        for (Object human: newFamilyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
//    public void sortByName(){
//        newFamilyTree.sortByName();
//    }
//    public void sortByAmountOfChildren(){
//        newFamilyTree.sortByAmountOfChildren();
//    }
    public void sort(Sorter<Human> sorter){
        sorter.Sort(newFamilyTree.getListOfFamily());
    }

    public FamilyTree getFamilyTree(){
        return newFamilyTree;
    }

    public FamilyMember getById(Integer id) {
        return newFamilyTree.getbyId(id);
    }

    public boolean addSpouseToFamilyMember(Integer idMember, Integer idSpouse){
        newFamilyTree.addSpouseToFamilyMember(newFamilyTree.getbyId(idMember), newFamilyTree.getbyId(idSpouse));
        return true;
    }


}

