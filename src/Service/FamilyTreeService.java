package Service;


import Model.FamilyTree;
import Model.FileHandler;
import Model.Gender;
import Model.Human;

import java.time.LocalDate;

public class FamilyTreeService implements FamilyService {
    private FamilyTree familyTree;
    private FileHandler fileHandler;

    public FamilyTreeService(FamilyTree familyTree, FileHandler fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    @Override
    public void addHuman(String name, LocalDate dob, Gender gender) {
        Human newHuman = new Human(name, dob, gender);
        if (familyTree.findByName(name) == null) {
            familyTree.addHuman(newHuman, null, null);
            System.out.println("Человек добавлен успешно.");
        } else {
            System.out.println("Человек с таким именем уже существует в дереве.");
        }
    }

    @Override
    public void addFather(String childName, String fatherName, LocalDate dob, Gender gender) {
        Human father = new Human(fatherName, dob, gender);
        Human child = familyTree.findByName(childName);
        if (child != null) {
            familyTree.addFather(child, father);
            System.out.println("Отец успешно добавлен");
        } else {
            System.out.println("Ребёнок не найден");
        }
    }

    @Override
    public void addMother(String childName, String motherName, LocalDate dob, Gender gender) {
        Human mother = new Human(motherName, dob, gender);
        Human child = familyTree.findByName(childName);
        if (child != null) {
            familyTree.addMother(child, mother);
            System.out.println("Мать успешно добавлена");
        } else {
            System.out.println("Ребёнок не найден");
        }
    }

    @Override
    public void printFamilyTree() {
        System.out.println(familyTree.toString());
    }

    @Override
    public void saveTree(String filePath) {
        fileHandler.save(familyTree, filePath);
        System.out.println("Семейное дерево успешно сохранено.");
    }

    @Override
    public void loadTree(String filePath) {
        FamilyTree loadedTree = (FamilyTree) fileHandler.read(filePath);
        if (loadedTree != null) {
            familyTree = loadedTree;
            System.out.println("Семейное дерево загружено.");
        } else {
            System.out.println("Ошибка при загрузке дерева.");
        }
    }
}
