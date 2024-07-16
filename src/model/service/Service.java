package model.service;

import model.builder.Gender;
import model.builder.Human;
import model.family_tree.FamilyTree;
import model.writer.FileHandler;
import java.time.LocalDate;


public class Service {
    private FamilyTree<Human> tree;
    private FileHandler fileHandler;

    public Service() {
        tree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        Human human = new Human(name, gender, birthDate, deathDate, father, mother);
        addHumanToFamilyTree(human);
        return human;
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate) {
        Human human = new Human(name, gender, birthDate);
        addHumanToFamilyTree(human);
        return human;
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        Human human = new Human(name, gender, birthDate, father, mother);
        addHumanToFamilyTree(human);
        return human;
    }

    public void setWedding(Human human1, Human human2) {
        tree.setWedding(human1, human2);
        addHumanToFamilyTree(human1);
        addHumanToFamilyTree(human2);
    }

    public void addChild(Human parent, Human child) {
        if (parent.addChild(child)) {
            addHumanToFamilyTree(child); // Обновить информацию в дереве
        } else {
            System.out.println("Не удалось добавить ребёнка " + child.getName() + " к " + parent.getName());
        }
    }

    private void addHumanToFamilyTree(Human human) {
        tree.add(human);
    }

    /**
     * Возвращаем информацию о дереве
     * @return Object FamilyTree
     */
    public String getFamilyTreeInfo() {
        return tree.getInfo();
    }

    /**
     * Сохраняем дерево в файл
     */
    public void saveFamilyTree() {
        fileHandler.save(tree);
    }
}
