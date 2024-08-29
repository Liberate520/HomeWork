package GB_Homework.Presenter;

import GB_Homework.Model.Family_Tree.FamilyTree;
import GB_Homework.Model.Gender.Gender;
import GB_Homework.Model.Human.Human;
import GB_Homework.Model.Service.Service;
import GB_Homework.View.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender){
        service.addHuman(name,birthDate,deathDate,gender);
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
        service.addHuman(name,birthDate,gender);
    }

    public FamilyTree<Human> getFamilyTree(){
        return service.getFamilyTree();
    }

    public List<Human> getByName(String name){  //вернуть по имени
        return service.getByName(name);
    }

    public Human getById(int id){   // вернуть по id
        return service.getById(id);
    }

    public void addChild(Human human,Human child) { //добавить ребёнка

        service.addChild(human, child);
    }

    public void addMother(Human human,Human mother) {  //добавить мать
        service.addMother(human,mother);
    }


    public void addFather(Human human,Human father) {   //добавить отца
        service.addFather(human,father);
    }

    public void addSpouse(Human human,Human spouse) {   //добавить супруга,супругу
        service.addSpouse(human,spouse);
    }

    public  List<Human> getSiblings(int id) {   //найти братьев и сестёр
        return service.getSiblings(id);
    }

    public void getAge(Human human) {   //возвращает возраст либо годы жизни
        view.printAnswer(service.getAge(human));
    }

    public void printNameFamilyTree(){
        service.printNameFamilyTree();
    }

    public void sortByName(){
        service.sortByName();
    }

    public void sortByData(){
        service.sortByData();
    }

    public void saveFamilyTree(String file) throws IOException {service.saveFamilyTree(file);}
    public void readFamilyTree(String file) throws IOException, ClassNotFoundException {service.readFamilyTree(file);}
}
