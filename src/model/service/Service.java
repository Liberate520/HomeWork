package model.service;

import model.family_tree.FamilyTree;
import model.human.Human;
import model.human.Sex;
import model.writer.FileHandler;
import view.commands.CommandList;

import java.time.LocalDate;
import java.util.List;

public class Service implements CommandList {
    private int id;
    private FamilyTree<Human> familyTree;
    FileHandler<Human> handler;

    public Service() {
        familyTree = new FamilyTree<>();
        handler = new FileHandler<>();
    }

    @Override
    public void add(String name, LocalDate birthDate, LocalDate deathDate, Sex sex, Human father, Human mother) {
        Human human = new Human(name, birthDate, deathDate, sex, father, mother);
        human.setId(id++);
        familyTree.add(human);
    }

    @Override
    public List<Human> getFamilyTree() {
        return familyTree.getFamilyTree();
    }

    public void setFamilyTree(List<Human> familyTree) {
        this.familyTree.setFamilyTree(familyTree);
    }

    @Override
    public List<Human> findByName(String name) {
        return familyTree.findByName(name);
    }

    public Human findById(int id) {
        return familyTree.findById(id);
    }

    @Override
    public void sortByName() {
        familyTree.sortByName();
    }

    @Override
    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    @Override
    public void sortByAge() {
        familyTree.sortByAge();
    }

    @Override
    public void setBirthDate(Human human, LocalDate birthDate) {
        human.setBirthDate(birthDate);
    }

    @Override
    public void setDeathDate(Human human, LocalDate deathDate) {
        human.setDeathDate(deathDate);
    }

    @Override
    public void setParents(Human human, Human father, Human mother) {
        human.setFamilyTies(father, mother);
    }

    @Override
    public String printList(List<Human> list) {
        return familyTree.printList(list);
    }

    @Override
    public void save() {
        handler.save(familyTree);
    }

    @Override
    public void load() {
        familyTree = handler.load();
    }
}
