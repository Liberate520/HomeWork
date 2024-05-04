package re.zip.famely_tree.model.service;

import re.zip.famely_tree.model.famely_tree.FamelyTree;
import re.zip.famely_tree.model.human.Gender;
import re.zip.famely_tree.model.human.Human;
import re.zip.famely_tree.model.service.writer.FileHandler;

import java.time.LocalDate;

public class Service{
    private FamelyTree<Human> simpleTree;
    private final FileHandler fileHandler;
//     // private int genId;


    public Service() {
        this.simpleTree = new FamelyTree<>();
        this.fileHandler = new FileHandler();
    }


    public void addHumanToFamelyTree(String firstName, String lastName, LocalDate localDate, Gender gender) {
//        FamelyTreeElement<E> famelyTreeElement1 = new FamelyTreelement<Human>(firstName, lastName, localDate, gender);
        Human human = new Human(firstName, lastName, localDate, gender);
        simpleTree.addToFamely(human);

    }

    public String getFamelyListInfo() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("\nСуществ семье: ");
//        stringBuilder.append(simpleTree.size());
//        stringBuilder.append("\n");
//        for (Human human : simpleTree){
//            stringBuilder.append(human);
//            stringBuilder.append("\n");
//        }
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

    public void loadFromFile(String filePath) {
        FileHandler fileHandler = new FileHandler();
        simpleTree = (FamelyTree<Human>) fileHandler.readFromFile(filePath);
    }

    public void setWeddding(Integer partner1ID, Integer partner2ID, Integer getFamelyName) {
        simpleTree.setWeddding(partner1ID, partner2ID, getFamelyName);
    }
}