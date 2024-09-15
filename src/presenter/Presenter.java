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
    }

    public void printTree(){
        service.printTree();
    }
    public Human getById(int id){
        return service.getHuman(id);
    }
    public void setWedding(int h, int w){
        service.setWedding(h,w);
    }
    public void setDivorce(int h, int w){
        service.setDivorce(h,w);
    }
    public void setParent(int parent, int human){
        service.setParent(parent, human);
    }
    public void setChild(int child, int human){
        service.setChild(child, human);
    }
    public void removeHuman(int human){
        service.removeHuman(human);
    }
    public void saveTree(){
        service.saveTree();
    }
    public void loadTree(){
        service.restoreTree();
    }
    public void sortById(){
        service.sortById();
    }
    public void sortByName(){
        service.sortByName();
    }
    public void sortByAge(){
        service.sortByAge();
    }
    public void setDeathDay(int humanId, LocalDate deathDay){
        service.setDeathDay(humanId, deathDay);
    }

}
