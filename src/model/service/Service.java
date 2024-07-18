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

    private void setGenderFromStr(String genderStr, Human human) {
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

    public String findByName(String name) {
        StringBuilder sb = new StringBuilder();
        List<Human> foundHumans = familyTree.getByName(name);
        for (Human human : foundHumans) {
            sb.append(human).append("\n");
        }
        return sb.toString();
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
