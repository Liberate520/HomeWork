package family_tree.presenter;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.service.Service;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod, Gender gender, String fatherID, String matherID) {

        service.addHuman(name, dob, dod, gender, fatherID, matherID);


    }

    public void sortHumansByName() {
        service.sortByName();
    }

    public String getHumanInfo(int sortId) {
        return service.getHumansInfo(sortId);
    }

    public void sortHumansByDOB() {
        service.sortByDOB();
    }

    public List<String> searhHumansByName(String name) {
        List<String> foundHumans = new ArrayList<>();
        for (Human human : service.getFamilyTree()) {

            if (human.getName().startsWith(name)) {
                foundHumans.add(human.toString());
            }
        }
        return foundHumans;
    }


    public void saveTree() {
        service.saveTree();
    }

    public void readTree() {
        service.readTree();
    }

    public String searhHumansById(String line) {
        for (Human human : service.getFamilyTree()) {

            if (human.getId() == Integer.parseInt(line)) {
                return human.toString();
            }

        }
        return "false";
    }

    public List<String> searhHumansChild(String line) {
        List<String> foundHumansChild = new ArrayList<>();
        for (Human human : service.getFamilyTree()) {
            if (human.getFather() == null) {
            } else if (human.getFather().getId() == Integer.parseInt(line)) {
                foundHumansChild.add(human.toString());
            }
        }
        return foundHumansChild;
    }
}