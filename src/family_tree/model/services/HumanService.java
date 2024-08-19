package family_tree.model.services;

import family_tree.model.help_classes.Gender;
import family_tree.model.program_classes.FamilyTree;
import family_tree.model.program_classes.Human;

import java.time.LocalDate;
import java.util.ArrayList;

public class HumanService extends Service {
    private FamilyTree<Human> my_family;

    public HumanService()  {
        this.my_family = new FamilyTree<>();

    }

    public boolean saveData(String filePath) {
        return saveDataFile(filePath, my_family);
    }

    public boolean loadData(String filePath) throws ClassCastException {
        try {
            FamilyTree<Human> tree = (FamilyTree<Human>) loadDataFile(filePath);
            if (tree != null) {
                my_family = tree;
                return true;
            }
            return false;

        }
        catch (ClassCastException e) {
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
