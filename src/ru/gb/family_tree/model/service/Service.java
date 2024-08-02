package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.FT.*;
import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.model.Human.Human;
import ru.gb.family_tree.model.builder.HumanBuilder;
import ru.gb.family_tree.model.builder.HumanBuilderFileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;
    private HumanBuilderFileHandler humanBuilderFileHandler;
    private FileHandler fileHandler;
    private String familyTreeFilePath;
    private String humanBuilderFilePath;

    public Service(FamilyTree<Human> familyTree, String familyTreeFilePath, String humanBuilderFilePath) {
        this.familyTree = familyTree;
        this.humanBuilder = new HumanBuilder();
        this.fileHandler = new FileHandler();
        this.familyTreeFilePath = familyTreeFilePath;
        this.humanBuilderFileHandler = new HumanBuilderFileHandler();
        this.humanBuilderFilePath = humanBuilderFilePath;
    }

    public void addHuman(String lastName, String name, Gender gender, LocalDate birthDate){
        Human human = humanBuilder.build(lastName, name, gender, birthDate);
        familyTree.addHuman(human);
        saveFamilyTree();
    }

    public Human findHumanByName(String nameHuman) {
        return familyTree.findHumanByName(nameHuman);
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByBirthDate(){
        familyTree.sortByBirthDate();
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public void addChildById(long parentId, long childId) {
        familyTree.addChildById(parentId, childId);
        saveFamilyTree();
    }

    public void saveFamilyTree() {
        try {
            fileHandler.saveFamilyTree(familyTree, familyTreeFilePath);
            humanBuilderFileHandler.saveHumanBuilder(humanBuilder, humanBuilderFilePath);
            System.out.println("FamilyTree и HumanBuilder сохранены в файлы: " + familyTreeFilePath + " и " + humanBuilderFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void loadFamilyTree() {
//        try {
//            FamilyTree<Human> loadedTree = fileHandler.loadFamilyTree(filePath);
//            HumanBuilder loadedBuilder = humanBuilderFileHandler.loadHumanBuilder(humanBuilderFilePath);
//            if (loadedTree != null) {
//                this.familyTree = loadedTree;
//            } else {
//                this.familyTree = new FamilyTree<>();
//            }
//            if (loadedBuilder != null) {
//                this.humanBuilder = loadedBuilder;
//            } else {
//                this.humanBuilder = new HumanBuilder();
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Файл не найден или поврежден, создаем новое семейное древо.");
//            this.familyTree = new FamilyTree<>();
//            this.humanBuilder = new HumanBuilder();
//            saveFamilyTree();
//        }
//    }

    public void loadFamilyTree() {
        try {
            this.familyTree = fileHandler.loadFamilyTree(familyTreeFilePath);
            this.humanBuilder = humanBuilderFileHandler.loadHumanBuilder(humanBuilderFilePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Файл не найден или поврежден, создаем новое семейное древо.");
            this.familyTree = new FamilyTree<>();
            this.humanBuilder = new HumanBuilder();
            saveFamilyTree();
        }
    }

    public void findHumanById(long id) {
        System.out.println("Поиск человека с ID: " + id);
        Human human = familyTree.findHumanById(id);
        if (human != null) {
            System.out.println("Найден человек: " + human);
        } else {
            System.out.println("Человек с ID " + id + " не найден.");
        }
    }

    public boolean delHuman(long id) {
        System.out.println("Попытка удаления человека с ID: " + id);
        boolean result = familyTree.removeHumanById(id);
        if (result) {
            System.out.println("Человек с ID " + id + " успешно удален.");
        } else {
            System.out.println("Человек с ID " + id + " не найден.");
            saveFamilyTree();
        }
        return result;
    }
}