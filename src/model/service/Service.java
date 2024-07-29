package model.service;

import model.Human.Gender;
import model.Human.Human;
import model.familyTree.FamilyTree;
import model.familyTree.ItemFamilyTree;
import model.handler.FileHandler;
import model.writer.Writer;

import java.io.IOException;
import java.time.LocalDate;

public class Service<E extends ItemFamilyTree> {
    private FamilyTree familyTree;
    Writer fileHandler = new FileHandler();

    public Service(){
        familyTree =  new FamilyTree<E>();

    }

    public void addFamilyMember(String name, LocalDate dateOfBirth, Gender gender){
        Human human = new Human(name, dateOfBirth, gender);
        familyTree.addPerson((E) human);
    }

    public void sortByName(){familyTree.sortByName();}

    public void sortByAge(){familyTree.sortByAge();}

    public String getInfo(){
        return familyTree.toString();
    }

    public void writeTree(String filename) throws IOException {
        fileHandler.WriteObject(familyTree, filename);
        }

    public void readTree(String filename) throws IOException, ClassNotFoundException {
        familyTree = fileHandler.ReadObject(filename);
    }


    public void setMother(String personName, String motherName) {
        familyTree.getPerson(personName).setMother(familyTree.getPerson(motherName));
    }

    public void setFather(String personName, String fatherName) {
        familyTree.getPerson(personName).setFather(familyTree.getPerson(fatherName));
    }

    public void addChild(String personName, String childName) {
        familyTree.getPerson(personName).addChild(familyTree.getPerson(childName));
    }
}

