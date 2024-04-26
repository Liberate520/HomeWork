package presenter;

import model.human.Gender;
import model.service.Service;
import model.writer.Writable;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void getTreeInfo() {
        String answer = service.getTreeInfo();
        view.printAnswerLn(answer);
    }

    public void addFirst() {
        if (service.addFirstHumanToFamily()) success();
        else error();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        getInfoById(service.addNewHumanToFamily(name, gender, birthDate));
    }

    public void setWedding(int id1, int id2) {
        if (service.setWedding(id1, id2)) success();
        else error();
    }

    public void setDivorce(int id1, int id2) {
        if (service.setDivorce(id1, id2)) success();
        else error();
    }

    public void addChild(int parentId, int childId) {
        if (service.addChild(parentId, childId)) {
            getInfoById(parentId);
            getInfoById(childId);
        } else error();
    }

    public void setBirthDate(int id, LocalDate birthDate) {
        if (service.setBirthDate(id, birthDate)) {
            getInfoById(id);
        } else error();
    }

    public void setDeathDate(int id, LocalDate deathDate) {
        if (service.setDeathDate(id, deathDate)) {
            getInfoById(id);
        } else error();
    }

    public void sortByAge() {
        service.sortByAge();
        getTreeInfo();
    }

    public void sortById() {
        service.sortById();
        getTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getTreeInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getTreeInfo();
    }

    public void saveTree() {
        view.printAnswerLn(service.save());
    }

    public void loadTree() {
        view.printAnswerLn(service.read());
    }

    public void getInfoById(int id) {
        view.printAnswerLn(service.infoByID(id));
    }

    public boolean checkId(int id) {
        return service.checkId(id);
    }

    private void success() {
        view.printAnswerLn("Данные успешно обновлены!\n");
    }

    private void error() {
        view.printAnswerLn("Данные не записаны!\n");
    }

    public void setWritable(Writable writable) {
        service.setWritable(writable);
    }
}