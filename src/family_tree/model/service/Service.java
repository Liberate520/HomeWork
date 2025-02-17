package family_tree.model.service;

import family_tree.model.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import writer.FileHandler;
import writer.Writer;

import java.io.IOException;
import java.time.LocalDate;

public class Service {

    public Human human;
    public Human child;
    public Human person1;
    public Human person2;
    public FamilyTree<Human> familyTree;


    private Writer writer;

    public Service(Writer writer) {

        this.writer = writer;
        Human human = new Human.Builder().build();
        familyTree = new FamilyTree<>();
    }


    public  void addHuman(String name, Gender gender, LocalDate date){

       Human human = new Human.Builder()
                    .setName(name)
                    .setGender(gender)
                    .setBirthDate(date)
                    .build();


        familyTree.add(human);
    }

    public String familyTreeList(){
        return familyTree.toString();

    }



    public void addParent(long humanId,long childId){
//        family_tree.model.human = familyTree.getById(humanId);
        Human human = familyTree.getById(humanId);

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
        Writer fileHandler = new FileHandler();
       fileHandler.save(familyTree);

    }

    public FamilyTree readFromFile() throws IOException, ClassNotFoundException {
        Writer fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read();

    }
}
