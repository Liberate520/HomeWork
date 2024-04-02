package presenter;

import View.View;
import model.Service;
import model.entity.Gender;
import model.entity.Person;
import model.tree.FamilyTree;

import java.time.LocalDate;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.service = new Service();
        this.view = view;
        this.service.prep();
    }

    public FamilyTree<Person> prep(){
        return service.prep();
    }

    public void addPerson(String name, Gender gender, LocalDate birthdate){
        service.addPerson(name,gender,birthdate);
    }

    public void addRelationship(String parentName, String childName){
        service.addRelationship(parentName, childName);
    }

    public void showTree(){
        service.displayFamilyTree();
    }

}
