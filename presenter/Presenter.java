package OOP.SemDZ.homeWork.presenter;

import java.time.LocalDate;

import OOP.SemDZ.homeWork.model.Service.Service;
import OOP.SemDZ.homeWork.model.human.Gender;
import OOP.SemDZ.homeWork.view.View;

public class Presenter {
    private Service service;
    private View viev;

    public Presenter(View view){
        this.viev = view;
        service = new Service();
    }

    public void addHuman (String name, Gender gender, LocalDate birthday){
        service.addHuman(name, gender, birthday);
    }

    public String printFamilyTree(){
        return service.printFamilyTree();
    }
    
    public void sortByName(){
        service.sortByName();
    }

    public void sortByAge(){
        service.sortByAge();
    }
    
}
