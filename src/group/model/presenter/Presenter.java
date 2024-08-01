package group.model.presenter;
import group.model.FamilyTree;
import group.model.Gender;
import group.model.Human;
import group.model.SaveReed.Writable;
import group.model.sevice.Service;
import group.model.view.View;

import java.time.LocalDate;


public class Presenter {
    private final View view;
    private final Service service;



    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }


    public void getHumansListInfo() {
        String info = service.getHumansListInfo();
        view.printAnswer(info);


    }

    public void sortByName() {
        service.sortByName();
        getHumansListInfo();
    }

    public void sortByDeathDate() {
        service.sortByDeathDate();
        getHumansListInfo();

    }

    public void addHuman(String name, Gender gender, Human parent1, Human parent2, LocalDate birthDate, LocalDate deathDate) {
        service.addHuman(name,gender,parent1,parent2,birthDate,null);
        getHumansListInfo();

    }
    public void addWedding(int Id1, int Id2){
        service.addWedding (Id1,Id2);
        getHumansListInfo();

    }

    public  void getById (int Id){
        service.getById(Id);
        getHumansListInfo();
    }

    public void addToParents(Human human){
        service.addToParents(human);
    }

    public void addToChildren(Human human){
        service.addToChildren(human);
    }

    public void save(FamilyTree familyTree) {
        service.save(familyTree);

    }

    public void read() {
        service.read();

    }


}
