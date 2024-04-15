package model.service;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writer.Writable;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;
    private final Writable writable;
    private final String fileName = "src/model/writer/BackUp.txt";

    public boolean addFirst() {
        familyTree.getHuman("Ivan", Gender.Male, LocalDate.of(1945, 5, 28));
        familyTree.getHuman("Zoia", Gender.Female, LocalDate.of(1950, 1, 1));
        familyTree.getHuman("Kostia", Gender.Male, LocalDate.of(1973, 12, 13));
        familyTree.getHuman("Irina", Gender.Female, LocalDate.of(1975, 3, 6));
        familyTree.getHuman("Katia", Gender.Female, LocalDate.of(2001, 11, 29));

        setDeathDate(0, 2021, 8, 22);
        setDeathDate(1, 2021, 2, 19);
        addChild(0, 2);
        addChild(1, 2);
        addChild(2, 4);
        addChild(3, 4);
        setWedding(0, 1);
        setWedding(2, 3);
        return true;
    } //добавление "прородителей" в семейное древо

    public boolean addHuman(String name, String genderStr, LocalDate birthDate) {
        return switch (genderStr) {
            case "1" -> familyTree.getHuman(name, Gender.Male, birthDate);
            case "2" -> familyTree.getHuman(name, Gender.Female, birthDate);
            default -> {
                System.out.println("Введен неизвестный пол (1-Male, 2-Female)");
                yield false;
            }
        };
    } //добавление нового человека в семейное древо

    public boolean setWedding(int id1, int id2) { //свадьба
        return familyTree.setWedding(id1, id2);
    }

    public boolean setDivorce(int id1, int id2) { //развод
        return familyTree.setDivorce(id1, id2);
    }

    public boolean addChild(int parentId, int childId) {
        return familyTree.addChild(parentId, childId);
    }

    public boolean setBirthDate(int id, int year, int month, int day) {
        return familyTree.setBirthDate(id, LocalDate.of(year, month, day));
    }

    public boolean setDeathDate(int id, int year, int month, int day) {
        return familyTree.setDeathDate(id, LocalDate.of(year, month, day));
    }

    public boolean checkId(int id) {
        return familyTree.getById(id) != null;
    }

    public String infoByID(int id) {
        return familyTree.infoById(id);
    }

    public String getTreeInfo() {
        return familyTree.toString();
    }

    //  Writer:
    public Service(Writable writable) {
        familyTree = new FamilyTree<Human>();
        this.writable = writable;
    }

    public void save() {
        writable.save(familyTree, fileName);
    }

    public void read() {
        familyTree = (FamilyTree<Human>) writable.read(fileName);
    }

    //  Sorting:
    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void sortById() {
        familyTree.sortById();
    }
}