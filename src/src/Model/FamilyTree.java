package src.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyObject<E>> implements Serializable, Iterable<E> {

    private List<E> listPersons;
    private Writable writable;

    public FamilyTree() {
        this.listPersons = new ArrayList<>();
        this.writable = new FileHandler();
    }

    
    
    public List<E> getFamilyTree() {
        return listPersons;
    }

    public void setFamilyTree(List<E> listPersons) {
        this.listPersons = listPersons;
    }
    
    public boolean addPerson(E person) {
        if (!listPersons.contains(person)) {
            listPersons.add(person);
            parentalAddition(person);
            childAddition(person);
            return true;
        } else {
            return false;
        }

    }

    private void parentalAddition(E person) {
        if (person.getChildren() != null) {
            for (E child : person.getChildren()) {
                if (listPersons.contains(child)) {
                    child.getParent(person);
                }
            }
        }
    }

    private void childAddition(E person) {
        if (person.getFather() != null) {
            person.getFather().setChild(person);
        } else if (person.getMother() != null) {
            person.getMother().setChild(person);
        }
    }

    public String printList() {
        StringBuilder fTree = new StringBuilder();
        for (E person : listPersons) {
            fTree.append(person.getPersCard(person));
        }
        return fTree.toString();
    }

    // public String toString() {
    // return printList();
    // }
    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<>(listPersons);
    }

    public boolean sortByName() {
        listPersons.sort(new PersonComporatorByName<>());
        return true;
    }

    public boolean sortByAge() {
        Collections.sort(listPersons, new PersonComparatorByAge<>());
        return true;
    }

    @SuppressWarnings("unchecked")
    public void fileUpload(File file) throws FileNotFoundException, ClassNotFoundException, IOException {
        setFamilyTree ((List<E>) writable.fileUpload(file));
    }

    public void savingToFile(String file) throws FileNotFoundException, IOException {
        writable.savingToFile((Serializable) getFamilyTree(), file);
    }

    @SuppressWarnings("unchecked")
    public Person searchPerson(String name){
        List<Person> lP = (List<Person>) listPersons; 
        for (Person person: lP){
            if(person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }




}
