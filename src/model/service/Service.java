package model.service;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writer.Writable;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> tree;

    public Service() {
        tree = new FamilyTree<>();
    }

    public void loadTree(FamilyTree<Human> loadedTree) {
        this.tree = loadedTree;
    }

    public FamilyTree<Human> getTree() {
        return tree;
    }

    public void saveTree(Writable fileHandler, String filePath) {
        fileHandler.save(tree, filePath);
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        Human human = new Human(name, gender, birthDate);
        tree.add(human);
    }

    public boolean setWedding(long id1, long id2) {
        return tree.setWedding(id1, id2);
    }

    public boolean setDivorce(long id1, long id2) {
        return tree.setDivorce(id1, id2);
    }

    public boolean addChild(long parentId, String name, Gender gender, LocalDate birthDate) {
        Human parent = tree.getById(parentId);
        if (parent == null) {
            System.out.println("Родитель с указанным ID не существует.");
            return false;
        }

        Human child = new Human(name, gender, birthDate);
        tree.add(child);

        // Устанавливаем связи между родителем и ребенком
        parent.addChild(child);
        child.addParent(parent);

        return true;
    }

    public Human getParentById(long id) {
        return tree.getById(id);
    }
}
