package re.zip.famely_tree.model.service;

import java.time.LocalDate;
import re.zip.famely_tree.model.famely_tree.FamelyTree;
import re.zip.famely_tree.model.human.Gender;
import re.zip.famely_tree.model.human.Human;
import re.zip.famely_tree.model.service.writer.FileHandler;

public class Service{
    private FamelyTree<Human> simpleTree;
    private final FileHandler fileHandler;


    public Service() {
        this.fileHandler = new FileHandler();
        this.simpleTree = new FamelyTree<>();
    }


    public void addHumanToFamelyTree(String firstName, String lastName, LocalDate localDate, Gender gender) {
        Human human = new Human(firstName, lastName, localDate, gender);
        simpleTree.addToFamely(human);

    }

    public String getFamelyListInfo() {
        String famelyListInfo = simpleTree.getFamelyListInfo();
        return famelyListInfo;
    }

    public void sortByFamelyName() {
        simpleTree.sortByFamelyName();
    }


    public void sortByFirstName() {
        simpleTree.sortByFirstName();
    }

    public void sortByBirthDate() {
        simpleTree.sortByBirthDate();
    }

    public void saveToFile(String filePath) {
        fileHandler.saveToFile(simpleTree, filePath);
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String filePath) {
        simpleTree = (FamelyTree<Human>) fileHandler.readFromFile(filePath);
    }

    public void setWeddding(Integer partner1ID, Integer partner2ID, Integer getFamelyName) {
        simpleTree.setWeddding(partner1ID, partner2ID, getFamelyName);
    }


    public void setChildParentRelationship(Integer parentID, Integer childID) {
        simpleTree.setChildParentRelationship(parentID, childID);
    }
}