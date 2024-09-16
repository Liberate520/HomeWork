package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.FT.*;
import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.model.Human.Human;
import ru.gb.family_tree.model.builder.HumanBuilder;
import ru.gb.family_tree.model.builder.HumanBuilderFileHandler;
import ru.gb.family_tree.model.builder.HumanBuilderInterface;

import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private FamilyTreeInterface<Human> familyTree;
    private HumanBuilderInterface humanBuilder;
    private FileHandler fileHandler;
    private String familyTreeFilePath;
    private String humanBuilderFilePath;

    public Service(FamilyTreeInterface<Human> familyTree, HumanBuilderInterface humanBuilder, String familyTreeFilePath, String humanBuilderFilePath) {
        this.familyTree = familyTree;
        this.humanBuilder = humanBuilder;
        this.fileHandler = new FileHandler();
        this.familyTreeFilePath = familyTreeFilePath;
        this.humanBuilderFilePath = humanBuilderFilePath;
    }

    public void addHuman(String lastName, String name, String genderInput, LocalDate birthDate) {
        Gender gender = Gender.valueOf(genderInput.toLowerCase());
        Human human = humanBuilder.build(lastName, name, gender, birthDate);
        familyTree.addHuman(human);
        saveFamilyTree();
    }

    public Human findHumanByName(String nameHuman) {
        return familyTree.findHumanByName(nameHuman);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public FamilyTreeInterface<Human> getFamilyTree() {
        return familyTree;
    }

    public void addChildById(long parentId, long childId) {
        familyTree.addChildById(parentId, childId);
        saveFamilyTree();
    }

    public void saveFamilyTree() {
        try {
            fileHandler.saveFamilyTree(familyTree, familyTreeFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFamilyTree() {
        try {
            this.familyTree = fileHandler.loadFamilyTree(familyTreeFilePath);
            long maxId = familyTree.findMaxId();
            humanBuilder.setStartId(maxId + 1); // Предположим, что у билдера есть метод setStartId
        } catch (IOException | ClassNotFoundException e) {
                        this.familyTree = new FamilyTree<>();
            this.humanBuilder = new HumanBuilder();
            saveFamilyTree();
        }
    }

    public Human findHumanById(long id) {
        return familyTree.findHumanById(id);
    }

    public boolean delHuman(long id) {
        boolean result = familyTree.removeHumanById(id);
        if (result) {
            saveFamilyTree();
        }
        return result;
    }
}
