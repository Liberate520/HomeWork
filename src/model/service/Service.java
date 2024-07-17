package model.service;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.builder.HumanBuilder;
import model.writer.FileHandler;
import model.writer.Writer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;
    private Writer fileHandler;

    public Service() {
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
        fileHandler = new FileHandler();
    }

    public void addHuman(String name, String genderStr, LocalDate birthDate) {
        Human human = humanBuilder.build();
        human.setName(name);
        setGenderFromStr(genderStr, human);
        human.setBirthDate(birthDate);
        familyTree.add(human);
    }

    private static void setGenderFromStr(String genderStr, Human human) {
        if (genderStr.equalsIgnoreCase("м")) {
            human.setGender(Gender.Male);
        } else if (genderStr.equalsIgnoreCase("ж")) {
            human.setGender(Gender.Female);
        }
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void sortById() {
        familyTree.sortById();
    }

    public String getHumanListInfo() {
        return familyTree.getInfo();
    }

    public void saveTree() {
        fileHandler.save(familyTree);
    }

    public void readTree() {
        if (fileHandler.read() != null) {
            familyTree = (FamilyTree) fileHandler.read();
        }
    }

    public void findByName(String name) {
        List<Human> foundHumans = familyTree.getByName(name);
        if (foundHumans.isEmpty()) {
            System.out.println("Не найдено ни одного человека.");
        } else {
            System.out.println("Список найденных людей:");
            for (Human human : foundHumans) {
                System.out.println(human);
            }
        }
    }

    public List<Integer> foundHumansId(String name) {
        List<Human> foundHumans = familyTree.getByName(name);
        List<Integer> foundHumansId = new ArrayList<>();
        for (Human human : foundHumans) {
            foundHumansId.add(human.getId());
        }
        return foundHumansId;
    }

    public void removeHuman(int id) {
        familyTree.remove(id);
    }
}
