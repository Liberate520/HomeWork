package src.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Model {

    private FamilyTree<Person> family;
    
    public Model() {
        family = new FamilyTree<>();
        

    }

    public Model(FamilyTree<Person> family) {
        this.family = family;

    }

    public boolean addPerson(String name, Gender gender, LocalDate dateB) {
        Person person = new Person(name, null, null, gender, dateB, null, null, null);
        return family.addPerson(person);
    }

    public boolean sortByName() {
        return family.sortByName();
    }

    public boolean sortByAge() {
        return family.sortByAge();
    }

    private void childAddition(Person person) {
        if (person.getFather() != null) {
            person.getFather().setChild(person);
        }

        if (person.getMother() != null) {
            person.getMother().setChild(person);
        }
    }

    public boolean kinship(String familyMembers) {
        Person child = null;
        String[] fM = familyMembers.split(" ");
        child = family.searchPerson(fM[0]);
        child.setFather(family.searchPerson(fM[1]));
        child.setMother(family.searchPerson(fM[2]));
        childAddition(child);
        return true;
    }

    public String prinrtListInfo() {
        return family.printList();
    }

    @SuppressWarnings("unchecked")
    public void setFamilyTree(FamilyTree<Person> list) {
        List<Person> lst = (List<Person>) list;
        family.setFamilyTree(lst);
    }

    public List<Person> getFamilyTreeList() {
        List<Person> fT = family.getFamilyTree();
        return fT;
    }

    
    
    public void fileUpload(File file) throws FileNotFoundException, ClassNotFoundException, IOException {
        family.fileUpload(file);

    }

    public void savingToFile(String file) throws FileNotFoundException, IOException {
        family.savingToFile(file);
    }

}
