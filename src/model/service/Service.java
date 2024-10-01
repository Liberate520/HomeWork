
package model.service;

import model.FamilyTree.FamilyTree;
import model.human.Human;
import model.human.TreeNode;
import model.writer.FileHandler;

import java.io.Serializable;

public class Service {

    private FamilyTree<Human> tree;
    final static String filePath = "src/model/writer/tree.txt";

    public Service() {
        this.tree = (FamilyTree<Human>) load(); // Загрузка дерева при создании сервиса
        if (this.tree == null) {
            this.tree = new FamilyTree<>();
        }
    }

    public static FamilyTree<Human> load() {
        FileHandler fileHandler = new FileHandler(filePath);
        return (FamilyTree<Human>) fileHandler.read();
    }

    public void save() {
        FileHandler fileHandler = new FileHandler(filePath);
        fileHandler.save(tree);
    }

    public void addOrUpdateHuman(Human human) {
        if (human == null) {
            throw new IllegalArgumentException("Human cannot be null");
        }

        if (human.getId() == -1) {
            // Adding new human
            tree.add(human);
        } else {
            // Updating existing human
            for (Human existingHuman : tree) {
                if (existingHuman.getId() == human.getId()) {
                    existingHuman.setName(human.getName());
                    existingHuman.setGender(human.getGender());
                    existingHuman.setBirthDate(human.getBirthDate());
                    existingHuman.setDeathDate(human.getDeathDate());
                    existingHuman.setChildren(human.getChildren());
                    existingHuman.setMother(human.getMother());
                    existingHuman.setFather(human.getFather());
                    return;
                }
            }
            throw new IllegalArgumentException("Human with ID " + human.getId() + " not found");
        }
        save();
    }

    private void updateRelations(Human human) {
        // Обновляем связи с родителями и детьми
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи\n");
        for (Human human : tree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void addParentToHuman(long childId, Human parent) {
        Human child = findHumanById(childId);
        if (child != null && parent != null) {
            child.addParent(parent);
            parent.addChild(child);
            save();
        }
    }

    private Human findHumanById(long id) {
        for (Human human : tree) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void addChildToHuman(long parentId, Human child) {

            Human parent = findHumanById(parentId);
            if (parent != null && child != null) {
                parent.addChild(child);
                child.addParent(parent);
                save();
            }
        }
    }









