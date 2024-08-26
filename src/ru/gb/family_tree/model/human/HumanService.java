package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.writer.FileHandler;

import java.time.LocalDate;
import java.util.List;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;

public class HumanService {
    final static String filePath = "src/ru/gb/family_tree/model/writer/tree.txt";

    private FamilyTree familyTree;
    private HumanBuilder builder;

    public HumanService() {
        familyTree = new FamilyTree();
        builder = new HumanBuilder();
    }

    public void addHuman(String humanName, LocalDate humanBirthday){
        Human human = builder
                .setHumanName(humanName)
                .setHumanBirthDate(humanBirthday)
                .build();
        familyTree.addHuman(human);
    }
    public void createDefaultFamilyTree() {
        addHuman("Екатерина", LocalDate.of(1965, 05, 05));
        addHuman("Александр", LocalDate.of(1960, 10, 10));
        addHuman("Геннадий", LocalDate.of(2015, 7, 7));
        addHuman("Михаил",  LocalDate.of(1985, 06, 15));
        addHuman("Евгения", LocalDate.of(1990, 12, 25));
    }

    public void save(){
        FileHandler fileHandler = new FileHandler(filePath);
        fileHandler.save(familyTree);
    }

    public void read(){
        FileHandler fileHandler = new FileHandler(filePath);
        familyTree = (FamilyTree) fileHandler.read();
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
