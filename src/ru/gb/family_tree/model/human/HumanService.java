package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.writer.FileHandler;

import java.time.LocalDate;
import java.util.List;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class HumanService {

    private FamilyTree<Human> familyTree;
    private HumanBuilder builder;

    public HumanService() {
        familyTree = new FamilyTree();
        builder = new HumanBuilder();
    }

    public void addHuman(String humanName,
                         Gender humanGender,
                         LocalDate humanBirthday,
                         LocalDate humanDeathDate){
        Human human = builder
                .setHumanName(humanName)
                .setHumanGender(humanGender)
                .setHumanBirthDate(humanBirthday)
                .setHumanDeathDate(humanDeathDate)
                .build();
        familyTree.addHuman(human);
    }

    public void createDefaultFamilyTree() {
        addHuman("Екатерина",
                Gender.Female,
                LocalDate.of(1965, 05, 05),
                LocalDate.of(2008, 10, 15));
        addHuman("Александр",
                Gender.Male,
                LocalDate.of(1960, 10, 10),
                null);
        addHuman("Геннадий",
                Gender.Male,
                LocalDate.of(2015, 7, 7),
                null);
        addHuman("Михаил",
                Gender.Male,
                LocalDate.of(1985, 06, 15),
                null);
        addHuman("Евгения",
                Gender.Female,
                LocalDate.of(1990, 12, 25),
                null);
    }

    public void save(){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree);
    }

    public void read(){
        FileHandler fileHandler = new FileHandler();
        familyTree = (FamilyTree<Human>) fileHandler.read();
    }

    public void addHumans(List<Human> humans){
        familyTree.addHumans(humans);
    }

    public void sortById(){
        familyTree.sortById();
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByBirthDate(){familyTree.sortByBirthDate();}

    public List<Human> getHumans(){
        return familyTree.getHumans();
    }

    public String getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family tree:\n");
        for (Object human: familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
