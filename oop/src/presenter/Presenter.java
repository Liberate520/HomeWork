package presenter;

import model.man.Gender;
import model.man.Man;
import model.service.Service;
import view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private Service<Man> service;
    private View view;

    public Presenter(View view){
        service = new Service<>();
        this.view = view;
    }

    public void addLivingItem(String name, Gender gender, LocalDate birthDate){
        service.addLivingItem(name, gender, birthDate);
    }

    public void addDeathItem(String name, Gender gender, LocalDate birthDate, LocalDate deathDate){
        service.addDeathItem(name, gender, birthDate, deathDate);
    }

    public void addItemWithParent (String name, Gender gender, LocalDate birthDate, long id1, long id2){
        service.addItemWithParent(name, gender, birthDate, id1, id2);
    }

    public String getInfoManForId(long id){
        return service.getInfoManForId(id);
    }

    public boolean addChildById(long id1,  long id2){
        return service.addChildById(id1, id2);
    }

    public boolean addParentById(long id1,  long id2){
        return service.addParentById(id1, id2);
    }

    public boolean removeById(long id){
        return service.removeById(id);
    }

    public List<Man> getParentById(long id){
        return service.getParentById(id);
    }

    public List<Man> getChildrensById(long id){
        return service.getChildrensById(id);
    }

    public List<Man> getByName(String name){
        return service.getByName(name);
    }

    public boolean setWeddingById(long id, long id2) {
        return service.setWeddingById(id, id2);
    }

    public boolean setDivorceById(long id, long id2) {
        return service.setDivorceById(id, id2);
    }

    public  void sortByName(){
        service.sortByName();
    }

    public  void sortByAge(){
        service.sortByAge();
    }

    public String getFamilyTreeInfo(){
        return service.getFamilyTreeInfo();
    }
    public void saveTree(){
        service.saveTree();
    }

    public void loadTree(){
        service.loadTree();
    }
}
