package model.services;

import java.io.IOException;
import java.util.Comparator;

import model.FamilyTree;
import model.Gender;
import model.Person;
import model.io.FileHandler;

public class FamilyTreeServiceImpl implements FamilyTreeService {
    private FamilyTree familyTree;
    private FileHandler fileHandler;

    public FamilyTreeServiceImpl(FamilyTree familyTree, FileHandler fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    @Override
    public void addPerson(String name, String birthDate, String genderStr, Integer fatherId, Integer motherId) {
        try {
            Gender gender = Gender.valueOf(genderStr.toUpperCase());
            Person person = new Person(name, birthDate, gender);
            if (fatherId != null) {
                Person father = familyTree.getMemberById(fatherId);
                if (father != null) {
                    father.addChild(person);
                    person.setFather(father);
                }
            }
            if (motherId != null) {
                Person mother = familyTree.getMemberById(motherId);
                if (mother != null) {
                    mother.addChild(person);
                    person.setMother(mother);
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
        if (promptSaveCurrentState()) {
            String newFilename = getNewFilenameFromUser();
            saveTree(newFilename);
            System.out.println("Данные сохранены в файл " + newFilename);
        }

        try {
            FamilyTree loadedTree = fileHandler.readFromFile(filename);
            familyTree = loadedTree;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean promptSaveCurrentState() {
        // Реализация логики для запроса пользователя о сохранении текущего состояния
        return true; // Например, здесь возвращается всегда true для упрощения
    }

    private String getNewFilenameFromUser() {
        // Реализация логики для получения нового имени файла от пользователя
        return "new_tree.ser"; // Например, здесь возвращается фиксированное имя файла для упрощения
    }
}
