package model.service;

import model.builder.HumanBuilder;
import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writer.Writable;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;
    private final Writable writable;
    private final HumanBuilder builder;

    public Service(Writable writable) {
        familyTree = new FamilyTree<>();
        builder = new HumanBuilder();
        this.writable = writable;
    }

    public boolean addFirstHumanToFamily() {
        addNewHumanToFamily("Ivan", Gender.Male, LocalDate.of(1945, 5, 28));
        addNewHumanToFamily("Zoia", Gender.Female, LocalDate.of(1950, 1, 1));
        addNewHumanToFamily("Kostia", Gender.Male, LocalDate.of(1973, 12, 13));
        addNewHumanToFamily("Irina", Gender.Female, LocalDate.of(1975, 3, 6));
        addNewHumanToFamily("Katia", Gender.Female, LocalDate.of(2001, 11, 29));

        setDeathDate(0, LocalDate.of(2021, 8, 22));
        setDeathDate(1, LocalDate.of(2021, 2, 19));
        addChild(0, 2);
        addChild(1, 2);
        addChild(2, 4);
        addChild(3, 4);
        setWedding(0, 1);
        setWedding(2, 3);
        return true;
    } //добавление "прородителей" в семейное древо

    public int addNewHumanToFamily(String name, Gender gender, LocalDate birthDate) {
        Human human = builder.build(name, gender, birthDate);
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
}