package re.zip.famely_tree.presenter;

import re.zip.famely_tree.model.human.Gender;
import re.zip.famely_tree.model.service.Service;
import re.zip.famely_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

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
}
