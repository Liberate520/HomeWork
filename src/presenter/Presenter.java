package presenter;

import model.human.Human;
import model.human.Gender;
import model.human.SpouseStatus;
import model.service.Service;
import view.View;
import model.save_and_load.FileHandler;

import java.time.LocalDate;


public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view){
        this.view = view;
        service = new Service(new FileHandler<Human>());
    }


    public boolean read(String file) {
        return service.read(file);
    }

    public boolean save(String file) {
        return service.save(file);
    }



    public boolean addHuman(String name, Gender gender, String birthDate){
        service.addHuman(name, gender, birthDate);
        return true;
    }

    public boolean setDeathDate(int personId, LocalDate deathDate) {
        if (service.checkById(personId)) {
            service.setDeathDate(personId, deathDate);
            return true;
        }
        return false;
    }

    public boolean setParent(int numanId, int parentId){
        if (service.checkById(numanId) & service.checkById(parentId)){
            service.setParent(numanId,parentId);
            return true;
        }
        return false;
    }


    public boolean setSpouse(int firstHumanId, int secondHumanId, SpouseStatus spouseStatus) {
        if (service.checkById(firstHumanId) & service.checkById(secondHumanId)) {
            service.setSpouse(firstHumanId, secondHumanId, spouseStatus);
            return true;
        }
        return false;
    }



    public void getFamilyTreeInfo() {
        view.printAnswer(service.getFamilyTreeInfo());
    }


    public void sortByName() {view.printAnswer(service.sortTreeByName());}

    public void sortByBirthDate() {view.printAnswer(service.sortTreeByAge());}
}
