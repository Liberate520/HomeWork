package model.services;

import model.FamilyTree;
import model.Gender;
import model.Person;
import model.io.FileHandler;

import java.io.IOException;
import java.util.Comparator;

public class FamilyTreeServiceImpl<T extends Person> implements FamilyTreeService<T> {
    private FamilyTree<T> familyTree;
    private FileHandler fileHandler;

    public FamilyTreeServiceImpl(FamilyTree<T> familyTree, FileHandler fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    @Override
    public void addPerson(String name, String birthDate, String genderStr, Integer fatherId, Integer motherId) {
        try {
            Gender gender = Gender.valueOf(genderStr.toUpperCase());
            @SuppressWarnings("unchecked")
            T person = (T) new Person(name, birthDate, gender);
            if (fatherId != null) {
                Person father = familyTree.getMemberById(fatherId);
                if (father != null) {
                    father.addChild(person);
                    person.setFather(father); // Установка отца
                }
            }
            if (motherId != null) {
                Person mother = familyTree.getMemberById(motherId);
                if (mother != null) {
                    mother.addChild(person);
                    person.setMother(mother); // Установка матери
                }
            }
            familyTree.addMember(person);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Неверный ввод пола. Пожалуйста, используйте MALE или FEMALE.");
        }
    }

    @Override
    public String showTree() {
        return familyTree.toString();
    }

    @Override
    public void sortByName() {
        familyTree.getMembers().sort(Comparator.comparing(Person::getName));
    }

    @Override
    public void sortByBirthDate() {
        familyTree.getMembers().sort(Comparator.comparing(Person::getBirthDate));
    }

    @Override
    public void saveTree(String filename) {
        try {
            fileHandler.writeToFile(filename, familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadTree(String filename) {
        try {
            FamilyTree<T> loadedTree = fileHandler.readFromFile(filename);
            mergeTrees(loadedTree);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void mergeTrees(FamilyTree<T> loadedTree) {
        for (T person : loadedTree.getMembers()) {
            if (familyTree.getMemberById(person.getId()) == null) {
                familyTree.addMember(person);
            }
        }
    }
}
