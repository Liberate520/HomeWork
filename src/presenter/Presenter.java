package presenter;

import model.service.Service;
import model.writer.FileHandler;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service(new FileHandler());
    }

    public boolean addFirst() {
        if (service.addFirst()) {
            return true;
        }
        return false;
    }

    public boolean addHuman(String name, String genderStr, LocalDate birthDate) {
        return service.addHuman(name, genderStr, birthDate);
    }

    public boolean setWedding(int id1, int id2) {
        return service.setWedding(id1, id2);
    }

    public boolean setDivorce(int id1, int id2) {
        return service.setDivorce(id1, id2);
    }

    public boolean addChild(int parentId, int childId) {
        if (service.addChild(parentId, childId)) {
            getBodyInfoById(parentId);
            return true;
        } else return false;
    }

    public boolean checkId(int id) {
        return service.checkId(id);
    }

    public boolean setBirthDate(int id, int year, int month, int day) {
        if (service.setBirthDate(id, year, month, day)) {
            getBodyInfoById(id);
            return true;
        }
        return false;
    }

    public boolean setDeathDate(int id, int year, int month, int day) {
        if (service.setDeathDate(id, year, month, day)) {
            getBodyInfoById(id);
            return true;
        }
        return false;
    }

    public void getBodyInfoById(int id) {
        view.printAnswer(service.infoByID(id));
    }

    public void getTreeInfo() {
        String answer = service.getTreeInfo();
        view.printAnswer(answer);
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void sortById() {
        service.sortById();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
    }

    public void saveTree() {
        service.save();
    }

    public void loadSaveTree() {
        service.read();
    }
}