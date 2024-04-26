package model.service;

import model.human.HumanBuilder;
import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writer.Writable;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;
    private Writable writable;
    private Human human;

    public Service() {
        human = new Human();
        familyTree = new FamilyTree<>();
    }

    public boolean addFirstHumanToFamily() {

        human = new HumanBuilder()
                .setBirthDate(LocalDate.of(1945, 5, 28))
                .setDeathDate(LocalDate.of(2021, 8, 22))
                .setName("Ivan")
                .setGender(Gender.Male)
                .build();
        familyTree.add(human);

        human = new HumanBuilder()
                .setBirthDate(LocalDate.of(1950, 1, 1))
                .setDeathDate(LocalDate.of(2021, 2, 19))
                .setSpouse(familyTree.getById(0))
                .setName("Zoia")
                .setGender(Gender.Female)
                .build();
        familyTree.add(human);

        human = new HumanBuilder()
                .setBirthDate(LocalDate.of(1973, 12, 13))
                .addParent(familyTree.getById(0))
                .addParent(familyTree.getById(1))
                .setName("Kostia")
                .setGender(Gender.Male)
                .build();
        familyTree.add(human);

        human = new HumanBuilder()
                .setBirthDate(LocalDate.of(1975, 3, 6))
                .setSpouse(familyTree.getById(2))
                .setName("Irina")
                .setGender(Gender.Female)
                .build();
        familyTree.add(human);

        human = new HumanBuilder()
                .setBirthDate(LocalDate.of(2001, 11, 29))
                .addParent(familyTree.getById(2))
                .addParent(familyTree.getById(3))
                .setName("Katia")
                .setGender(Gender.Female)
                .build();
        familyTree.add(human);

        return true;
    } //добавление "прородителей" в семейное древо

    public int addNewHumanToFamily(String name, Gender gender, LocalDate birthDate) {

        human = new HumanBuilder()
                .setBirthDate(birthDate)
                .setName(name)
                .setGender(gender)
                .build();
        return familyTree.add(human);
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

    public boolean setBirthDate(int id, LocalDate birthDate) {
        return familyTree.setBirthDate(id, birthDate);
    }

    public boolean setDeathDate(int id, LocalDate deathDate) {
        return familyTree.setDeathDate(id, deathDate);
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
    public String save() {
        return writable.save(familyTree);
    }

    public String read() {
        familyTree = (FamilyTree<Human>) writable.read();
        if (familyTree != null) {
            return "File \"src/model/writer/BackUp.txt\" has been loaded\n";
        }
        return "Что-то пошло не так...\n";
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

    public void setWritable(Writable writable) {
        this.writable = writable;
    }
}