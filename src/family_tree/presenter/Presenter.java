package family_tree.presenter;

import family_tree.model.human.Gender;
import family_tree.model.service.Service;
import family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate){
        service.addHuman(name, gender, birthDate);
        getFamilyTreeInfo();
    }

    public boolean addParent(int childId, int parentId){
        return service.addParent(childId, parentId);
    }

    public boolean addChild(int parentId, int childId){
        return service.addChild(parentId, childId);
    }

    public void sortByAge(){
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void sortByName(){
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo(){
        String info = service.getFamilyTree().toString();
        view.printAnswer(info);
    }

    public boolean saveToFile(String filename){
        return service.saveToFile(filename);
    }

    public boolean loadFromFile(String filename){
        return service.loadFromFile(filename);
    }

}
