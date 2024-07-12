package family_tree.model.service;

import family_tree.model.family_tree1.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.writer.FileHandler;
import family_tree.model.writer.Writer;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private FamilyTree<Human> familyTree;
    private Writer fileHandler;
    private final String FILE_PATH = "src/family_tree/model/writer/familyTree.ser";


    public Service () {
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FileHandler();
        this.familyTree = loadFamilyTree();
    }

    public Human addHuman(String name, LocalDate dob, Gender gender) {
        Human human = new Human(name, dob, null, gender, null, null, new ArrayList<>());
        familyTree.addHuman(human);
        saveFamilyTree();
        return human;
    }

    public void setParents(int childId, Integer fatherId, Integer motherId) {
        Human child = findHumanById(childId);
        if (child != null) {
            Human father = (fatherId != null) ? findHumanById(fatherId) : null;
            Human mother = (motherId != null) ? findHumanById(motherId) : null;
            child.setFather(father);
            child.setMother(mother);

            if (father != null) {
                father.getChildren().add(child);
            }

            if (mother != null) {
                mother.getChildren().add(child);
            }

            saveFamilyTree();
        }
    }

    public void sortByName () {
        familyTree.sortByName();
    }

    public void sortByDateBirth() {
        familyTree.sortByDateBirth();
    }

    public String getHumanListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");

        for (Object human : familyTree) {
            stringBuilder.append(human).append("\n");
        }

        return stringBuilder.toString();
    }

    public Human findHumanById(int searchId) {
        return familyTree.findHumanById(searchId);
    }

    public List<Human> findHumansByName(String searchInput) {
        return familyTree.findHumansByName(searchInput);
    }

    private void saveFamilyTree() {
        try {
            fileHandler.save(FILE_PATH, familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private FamilyTree<Human> loadFamilyTree() {
        try {
            FamilyTree<Human> loadedTree = fileHandler.load(FILE_PATH);
            if (loadedTree != null) {
                familyTree = loadedTree;

                // Код для определения максимального ID
                int maxId = 0;
                for (Human human : familyTree.getHumans()) {
                    if (human.getId() > maxId) {
                        maxId = human.getId();
                    }
                }
                Human.resetIdCounter(maxId);

                return loadedTree;
            }
            return new FamilyTree<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new FamilyTree<>();
        }
    }

    public void finish() {
        saveFamilyTree();
    }
}
