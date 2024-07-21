package presenter;

import java.time.LocalDate;

import model.human.Gender;
import model.human.Human;
import model.service.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate dateOfBirth) {
        service.addHuman(name, gender, dateOfBirth);
        getHumansListInfo();
    }

    public Human getHuman(int idHuman){
        return service.getHuman(idHuman);
    }

    public void setParent(int idChildren, int idParent){
        service.setParent(idChildren, idParent);
        getHumansListInfo();
    }
    
    public void setDateOfDeath(int idHuman, LocalDate dateOfDeath){
        service.setDateOfDeath(idHuman, dateOfDeath);
        getHumansListInfo();
    }

    public void getHumansListInfo() {
        String answer = service.getHumansListInfo();
        view.printAnswer(answer);
    }

    public void getFamilyTreeHuman(int idHuman) {
        String answer = service.getFamilyTreeHuman(idHuman);
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        getHumansListInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getHumansListInfo();
    }

    public void save() {
        service.save();
    }

    public boolean loading() {
        if (service.loading()) {
            return true;
        } else {
            return false;
        }
    }
}
