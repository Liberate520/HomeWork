package Model;

import Model.TypeOfRelationship.TypeOfRelationship;
import Model.Рerson.Рerson;
import Model.WorkingWithFile.FileProcessing;
import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private FileProcessing writable;
    private final String fileAddress = "tree.txt";
    private TypeOfRelationship<Рerson> activeTree;

    public Service(TypeOfRelationship<Рerson> activeTree) {
        this.activeTree = activeTree;
    }

    public Service(){
        activeTree = new TypeOfRelationship<>();
    }

    public void save() throws IOException {
        writable.save(activeTree, fileAddress);
    }

    public TypeOfRelationship read() throws IOException, ClassNotFoundException {
        return activeTree = (TypeOfRelationship<Рerson>) writable.read(fileAddress);
    }

    public void addPerson(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate){
        activeTree.addРerson(new Рerson(firstName, lastName, birthDate, deathDate));
    }
    public void sortByName(){
        activeTree.sortByName();
    }

    public void sortByBirthday(){
        activeTree.sortByBirthday();
    }

    public String getInfo() {
        return activeTree.toString();
    }

}