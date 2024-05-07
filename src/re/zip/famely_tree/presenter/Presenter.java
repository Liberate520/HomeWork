package re.zip.famely_tree.presenter;

import java.time.LocalDate;
import re.zip.famely_tree.model.human.Gender;
import re.zip.famely_tree.model.service.Service;
import re.zip.famely_tree.view.View;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHumanToFamelyTree(String firstName, String lastName, LocalDate localDate, Gender gender) {
        service.addHumanToFamelyTree(firstName, lastName, localDate, gender);
        getFamelyListInfo();
    }

    public void getFamelyListInfo() {
        String famelyListInfo = service.getFamelyListInfo();
        view.printAnswer(famelyListInfo);
    }

    public void sortByFamelyName() {
        service.sortByFamelyName();
        getFamelyListInfo();
    }

    public void sortByFirstName() {
        service.sortByFirstName();
        getFamelyListInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getFamelyListInfo();
    }

    public void saveToFile(String filePath) {
        service.saveToFile(filePath);
    }

    public void loadFromFile(String filePath) {
        service.loadFromFile(filePath);
        getFamelyListInfo();
    }

    public void setWeddding(Integer partner1ID, Integer partner2ID, Integer getFamelyName) {
        service.setWeddding(partner1ID, partner2ID, getFamelyName);
    }

    public void setChildParentRelationship(Integer parentID, Integer childID) {
        service.setChildParentRelationship(parentID, childID);
    }
}
