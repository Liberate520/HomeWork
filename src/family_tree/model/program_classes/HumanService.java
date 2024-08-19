package family_tree.model.program_classes;

import family_tree.model.help_classes.Gender;
import family_tree.model.saving_data.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;

public class HumanService {
    private FamilyTree<Human> my_family;

    public HumanService()  {
        this.my_family = new FamilyTree<>();

    }

    public boolean saveDataFile(String filePath) {
        try {
            FileHandler<FamilyTree<Human>> fh = new FileHandler<>(filePath);
            fh.writeData(my_family);
            return true;
        }
        catch (RuntimeException e) {
            return false;
        }
    }

    public boolean loadDataFile(String filePath) {
        try {
            FileHandler<FamilyTree<Human>> fh = new FileHandler<>(filePath);
            my_family =  fh.readData();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public boolean addHuman(String doc, String name, Gender gender, LocalDate birth) {
        Human human = new Human(doc, name, gender, birth);
        return my_family.add(human);
    }

    public void sortByName() {
        my_family.sortByName();
    }

    public void sortByBirthDate() {
        my_family.sortByBirthDate();
    }

    public boolean addFamilyLink(String childDoc, String parentDoc) {
        Human child  = findByDocument(childDoc);
        Human parent  = findByDocument(parentDoc);
        if (child == null || parent == null) {
            return false;
        }
            parent.addChild(child);
            return true;
    }

    public boolean registerDeath(String doc, LocalDate date) {
        Human human = findByDocument(doc);
        if (human == null) {
            return false;
        }
        human.setDeathDate(date);
        return true;
    }

    public Human findByDocument(String doc) {
        return my_family.findByDocument(doc);
    }

    public ArrayList<Human> findByName(String name) {
        return my_family.findByName(name);
    }

    public ArrayList<Human> getTreeInfo() {
        return my_family.getfTree();
    }


}
