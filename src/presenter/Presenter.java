package presenter;

import model.Service;
import model.human.Gender;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }
    public void addHuman(String name, Gender gender, LocalDate birthDay){
        service.addHuman(name, gender, birthDay);
        //TODO результат где?
    }
    public void printTree(){
        service.printTree();
    }
}
