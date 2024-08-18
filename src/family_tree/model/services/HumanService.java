package family_tree.model.services;

import family_tree.model.help_classes.Gender;
import family_tree.model.program_classes.FamilyTree;
import family_tree.model.program_classes.Human;
import family_tree.model.saving_data.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;

public class HumanService {
    private FamilyTree<Human> my_family;

    public HumanService() {
        this.my_family = new FamilyTree<>();

    }

    public boolean saveDataFile(String filePath) {
        try {
            FileHandler fh = new FileHandler(filePath);
            fh.writeData(my_family);
            return true;
        }
        catch (RuntimeException e) {
            return false;
        }
    }

    public void loadDataFile(String filePath) {
        FileHandler fh = new FileHandler(filePath);
        my_family =  fh.readData();
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

    public void addFamilyLink(Human child, Human parent) {
        parent.addChild(child);
    }

    public void registerDeath(Human human, LocalDate date) {
        human.setDeathDate(date);
    }

    public Human findByDocument(String doc) {
        return my_family.findByDocument(doc);
    }

    public ArrayList<Human> findByName(String name) {
        ArrayList<Human> list = my_family.findByName(name);
        return list;
    }

    public String getTreeInfo() {
        StringBuilder answer = new StringBuilder();
        for (Object human : my_family)
            if (human != null) {
                answer.append(human);
                answer.append("\n");
            }
        return answer.toString();
    }


}
