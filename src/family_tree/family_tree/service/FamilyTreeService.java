package family_tree.family_tree.service;

import family_tree.family_tree.model.FamilyTreeModel;
import family_tree.human.Gender;
import family_tree.human.Human;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public class FamilyTreeService {
    private FamilyTreeModel model;

    public FamilyTreeService(FamilyTreeModel model) {
        this.model = model;
    }

    public void addNewFamilyMember(String name, LocalDate dob, Gender gender) {
        Human newMember = new Human(name, dob, gender);
        model.addFamilyMember(newMember);
    }

    public void sortFamilyMembersByName() {
        model.sortFamilyMembersByName();
    }

    public void sortFamilyMembersByBirthDate() {
        model.sortFamilyMembersByBirthDate();
    }

    public List<Human> getFamilyMembers() {
        return model.getFamilyMembers();
    }

    public void saveFamilyTreeToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(model.getFamilyMembers());
        } catch (IOException e) {
            throw new RuntimeException("Error saving data to file: " + e.getMessage(), e);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFamilyTreeFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Human> familyMembers = (List<Human>) ois.readObject();
            model.setFamilyMembers(familyMembers);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error loading data from file: " + e.getMessage(), e);
        }
    }
}
