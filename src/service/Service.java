package service;

import family_tree.FamilyTree;
import family_tree.view.View;
import human.Gender;
import human.Human;
import writer.FileHandler;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Service {
    public Human human;
    public Human child;
    public Human person1;
    public Human person2;
    public FamilyTree<Human> familyTree;

    private String name;
    private Gender gender;
    private LocalDate date;

    public Service() {
        human = new Human(name,gender,date);
        familyTree = new FamilyTree<>();
    }

//    public
//
    public  void addHuman(String name, Gender gender, LocalDate date){
        Human human = new Human(name,gender,date);
        familyTree.add(human);
    }

    public String familyTreeList(){
        return familyTree.toString();

    }



    public void addParent(long humanId,long childId){
        human = familyTree.getById(humanId);
        child = familyTree.getById(childId);

        child.addParent(human);
        human.addChild(child);

    }
    public void addMarriage(long human1,long human2){
        person1 = familyTree.getById(human1);
        person2 = familyTree.getById(human2);

        familyTree.setWedding(person1,person2);

    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void saveToFile() throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree);
//        FileHandler.save(familyTree);
//        private static void saveTree (FamilyTree familyTree) throws IOException {
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.save(familyTree);
    }

    public FamilyTree readFromFile() throws IOException, ClassNotFoundException {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read();

    }
}
