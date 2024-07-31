package presenter;

import model.person.Gender;
import model.person.Human;
import model.service.Service;
import model.writer.Writer;
import view.View;

import java.time.LocalDate;

public class Presenter {
    View view;
    Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth) {
        service.addHuman(name, gender, dateOfBirth);
        getHumansListInfo();
    }

    public void addChildToParent(long idParent, long idChild) {
        service.addChildToParent(idParent, idChild);
        getHumansListInfo();
    }

    public void getHumansListInfo() {
        String answer = service.getHumansListInfo();
        view.printAnswer(answer);
    }

    public void getHumanBirthDate(long idHuman) {
        view.printAnswer(service.getBirthDate(idHuman).toString());
    }

    public void setDateOfDeath(long idHuman, LocalDate dateOfDeath) {
        service.setDateOfDeath(idHuman, dateOfDeath);
        getHumansListInfo();
    }

    public void setFather(long idChild, long idFather) {
        service.setFather(idChild, idFather);
        getHumansListInfo();
    }

    public void setMother(long idChild, long idMother) {
        service.setMother(idChild, idMother);
        getHumansListInfo();
    }

    public void setWedding(long humanId1, long humanId2) {
        service.setWedding(humanId1, humanId2);
        getHumansListInfo();
    }

    public void setDivorce(long humanId1, long humanId2) {
        service.setDivorce(humanId1, humanId2);
        getHumansListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumansListInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getHumansListInfo();
    }

    public void sortByChildrenQuantity() {
        service.sortByChildrenQuantity();
        getHumansListInfo();
    }

    public void sortById() {
        service.sortById();
        getHumansListInfo();
    }

    public Human getHumanById(long idHuman) {
        return service.getHumanById(idHuman);
    }

    public void saveFile() {
        service.saveFile();
    }

    public Object readFile() {
        return service.readFile();
    }

    public void setCustomPath(String path) {
        service.setCustomPath(path);
    }

    public String getPath() {
        return service.getPath();
    }
}
