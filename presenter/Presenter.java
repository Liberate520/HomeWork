package homeWork.presenter;

import homeWork.view.View;

import java.io.Serializable;
import java.time.LocalDate;

import homeWork.model.gender.Gender;
import homeWork.model.human.Human;
import homeWork.model.service.Service;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view){
        this.view=view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate dob, LocalDate dod, Gender gender, Human mother, Human father){
        service.addHuman(name, dob, dod, gender, mother, father);
        getTree();
    }

    public void getTree(){
        String FamTree = service.toString();
        view.print(FamTree);
    }

    public void sortbyName(){
        service.sortbyName();
        getTree();
    }
    
    public void sortbyDate(){
        service.sortbyDate();
        getTree();
    }
    
    public void saveTreeToFile(Serializable serializable, String filename) {
        service.saveToFile(service.printTree(), filename);
    }

    public void loadTreeFromFile(String filename) {
        service = (Service) service.loadFromFile(filename);
    }
}
