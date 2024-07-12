package model.service;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.builder.HumanBuilder;
import model.writer.FileHandler;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;
    private HumanBuilder humanBuilder;
    private FileHandler fileHandler;

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
        if (genderStr.equalsIgnoreCase("м")){
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

    public FamilyTree readTree() {
        return (FamilyTree) fileHandler.read();
    }
}
