package presenter;

import model.Service;
import model.human.Gender;
import model.human.Human;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;
    private int id;

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
    public Human getById(int id){
        return service.getHuman(id);
    }
}
