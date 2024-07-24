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
    Writer writer;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth) {
        service.addHuman(name, gender, dateOfBirth);
        getHumansListInfo();
    }

    public void addChildToParent(int idParent, int idChild) {
        service.addChildToParent(idParent, idChild);
        getHumansListInfo();
    }

    public void getHumansListInfo() {
        String answer = service.getHumansListInfo();
        view.printAnswer(answer);
    }

    public void getAge(long idHuman) {
        String answer = service.getAge(idHuman);
        view.printAnswer(answer);
    }

    public void setDateOfDeath(int idHuman, LocalDate dateOfDeath) {
        service.setDateOfDeath(idHuman, dateOfDeath);
        getHumansListInfo();
    }

    public void setFather(int idChild, int idFather) {
        service.setFather(idChild, idFather);
        getHumansListInfo();
    }

    public void setMother(int idChild, int idMother) {
        service.setMother(idChild, idMother);
        getHumansListInfo();
    }

    public void setWedding(long humanId1, long humanId2) {
        service.setWedding(humanId1, humanId2);
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

    public Human getHumanById(long idHuman) {
        return service.getHumanById(idHuman);
    }

    public void saveFile() {
        service.saveFile();
    }

    public void readFile() {
        service.readFile();
        getHumansListInfo();
    }
}
