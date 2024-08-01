package src.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


import src.FamilyTree.FamilyTree;
import src.FileHandling.FileHandler;
import src.Human.Gender;
import src.Human.Human;
import src.Human.HumanBuilder;

public class Service {
    private HumanBuilder humanBuilder;
    private FamilyTree familyTree;
    
    public Service() throws SecurityException, IOException{
        humanBuilder = new HumanBuilder();
        familyTree = new FamilyTree();
    }

    public FamilyTree createTree(){
        return familyTree;
    }

    public Human addToTree(String name,LocalDate dateofbirth,LocalDate dateofdeath,Gender gender,Human mother,Human father,List<Human> children){
        Human member = humanBuilder.build(name, dateofbirth, dateofdeath, gender,mother,father, children);
        familyTree.addMember(member);
        return member;
    }

    public void addParent(Human c, Human p){
        if(p.getGender().equals(Gender.Male)){
            c.setFather(p);
        }
        if(p.getGender().equals(Gender.Female)){
            c.setMother(p);
        }
    }

    public void addChildren(Human c, Human p){
        p.setChildren(c);
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByBirthday(){
        familyTree.sortByBirthday();
    }

    public void sortByChildren(){
        familyTree.sortByChildren();
    }    

    public FamilyTree readTree() throws ClassNotFoundException, IOException {
        FileHandler fileHandler = new FileHandler();
        System.out.println("Family tree loaded succesfully!");
        return(FamilyTree) fileHandler.read();
    }

    public void writeTree (FamilyTree tree) throws FileNotFoundException, IOException {
        FileHandler fileHandler = new FileHandler();
        System.out.println("Family tree saved succesfully!");
        fileHandler.write(tree);
    }
}
