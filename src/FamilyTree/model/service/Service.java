package FamilyTree.model.service;

import FamilyTree.model.builder.HumanBuilder;
import FamilyTree.model.familyTree.FamilyTree;
import FamilyTree.model.familyTree.Gender;
import FamilyTree.model.human.Human;
import FamilyTree.model.utility.FileHandler;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private HumanBuilder humanBuilder;
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;
//    private Gender gender;
    private Human lastAddedHuman;

//    public Service() {
//        this.familyTree = new FamilyTree<>();
//        this.humanBuilder = new HumanBuilder();
//        this.fileHandler = new FileHandler();
//    }

//    public Service(FileHandler fileHandler) {
//        this.familyTree = fileHandler.load();
//        if (this.familyTree == null) {
//            this.familyTree = new FamilyTree<>();
//        }
//    }

    public Service(FamilyTree<Human> familyTree) {
        if (familyTree == null) {
            throw new IllegalArgumentException("Семейное древо не может быть null");
        }
        this.familyTree = familyTree;
        this.humanBuilder = new HumanBuilder();
        this.fileHandler = new FileHandler();
    }

    public void saveFamilyTree() {
        fileHandler.save(familyTree);
    }

    public FamilyTree<Human> loadFamilyTree() {
        if (fileHandler == null) {
            throw new NullPointerException("FileHandler не инициализирован");
        }
        FamilyTree<Human> loadedFamilyTree = fileHandler.load();
        if (loadedFamilyTree != null) {
            this.familyTree = loadedFamilyTree;
        } else {
            this.familyTree = new FamilyTree<>();
        }
        return this.familyTree;
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
//        System.out.println("Ser_aH1_familyTree: " + familyTree);

        if (familyTree == null) {
            throw new NullPointerException("Семейное древо не может быть null");
        }
        Human human = humanBuilder.build(name, birthDate, gender);
//        System.out.println("Ser_aH11_familyTree: " + familyTree);
        if (human == null) {
            throw new NullPointerException("Не удалось создать объект 'Человек'");
        }
        lastAddedHuman = human;
        familyTree.addMember(human);
//        System.out.println("_член " + human);
//        System.out.println("Ser_aH111_familyTree: " + familyTree);
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender, Human father, Human mother) {
        if (familyTree == null) {
            System.out.println("Ошибка: familyTree не инициализирован");
            return;
        }
        if (humanBuilder == null) {
            System.out.println("Ошибка: humanBuilder не инициализирован");
            return;
        }
        if (name == null || birthDate == null || gender == null) {
            System.out.println("Ошибка: некорректные данные для добавления человека");
            return;
        }
        // Используем корректный конструктор
        Human newHuman = humanBuilder.build(name, birthDate, gender, father, mother);
        if (newHuman != null) {
            familyTree.addMember(newHuman);
            lastAddedHuman = newHuman;
        } else {
            System.out.println("Ошибка: не удалось создать человека");
        }
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender, String occupation,
                         String nationality, String placeOfBirth, Human father, Human mother) {
        Human human = humanBuilder.build(name, birthDate, gender, occupation, nationality, placeOfBirth, father, mother);
        lastAddedHuman = human;
        familyTree.addMember(human);
    }

    public Gender getMaleGender() {
        return Gender.Male;
    }

    public Gender getFemaleGender() {
        return Gender.Female;
    }

    public Gender chooseGender(int choice) {
        if (choice == 1) {
            return Gender.Male;
        } else if (choice == 2) {
            return Gender.Female;
        } else {
            throw new IllegalArgumentException("Неверный выбор пола");
        }
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public Human getLastAddedHuman() {
        return lastAddedHuman;
    }

    public boolean deleteHuman(Human humanToDelete) {
        if (familyTree == null || humanToDelete == null) {
            return false;
        }

        // Удаление всех связей человека
        for (Human member : familyTree.getMembers()) {
            if (member.getSpouse() == humanToDelete) {
                member.setSpouse(null);
            }
            member.removeChild(humanToDelete);
        }

        // Удаляем человека из дерева
        return familyTree.removeMember(humanToDelete);
    }

    public StringBuilder printFamilyTreeInfo() {
        StringBuilder info = familyTree.printFamilyTree();
//        System.out.println("Информация из service.printFamilyTreeInfo:");
//        System.out.println(info.toString());  // Печать строки на консоль
        return info;
    }

    public boolean isFamilyTreeEmpty() {
        return familyTree.getMembers().isEmpty();
    }

    public Human getMemberByName(String name){
       return familyTree.getMemberByName(name);
    }

    public List<Human> getFamilyTree() {
        return familyTree.getMembers();
    }

    public void getFTChildrenOfMember(long id) {
        Human human = familyTree.getMemberById(id);
        familyTree.printChildren(human);
    }
//    public void printSiblings(T person) {
//    public void printAncestors(T person) {
//    public void printGrandchildren(T person) {
//    public void printSpouse(T person) {
//    public void printAgeStatistics() {
}
