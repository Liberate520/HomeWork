package familytree.io;

import familytree.model.FamilyTree;
import familytree.model.Person;

import java.io.*;
import java.util.List;

public class FamilyTreeFileIO implements FamilyTreeIO {

    @Override
    public void writeToFile(FamilyTree familyTree, String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(familyTree.getPeople());
        }
    }

    @Override
    public FamilyTree readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Person> people = (List<Person>) in.readObject();
            FamilyTree familyTree = new FamilyTree();
            for (Person person : people) {
                familyTree.addPerson(person);
            }
            return familyTree;
        }
    }
}
