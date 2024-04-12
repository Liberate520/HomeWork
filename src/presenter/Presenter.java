package presenter;

import model.person.Gender;
import model.service.Service;
import model.writer.Writable;
import view.View;

import java.time.LocalDate;

public class Presenter {

    private View view;

    private Service service;


    public Presenter(View view, Writable writable) {
        this.view = view;
        service = new Service(writable);
    }

    public void addPerson (String fullName, Gender gender, LocalDate birthDate, LocalDate deathDate){
        service.addPerson(fullName,gender,birthDate,deathDate);
        getTreeInfo();
    }
    public void addKinship( String parentName, String childName){
        service.addKinship(parentName,childName);
        getTreeInfo();
    }

    public void getTreeInfo(){
        String info=service.getTreeInfo();
        view.printAnswer(info);
    }

    public void sortByName() {
        service.sortByName();
        getTreeInfo();
    }

    public void sortByDateOfBirth() {
        service.sortByDateOfBirth();
        getTreeInfo();
    }

    public void saveTree(){
        service.saveTree();
    }

    //Загрузка из файла с выводом в консоль
    public void printLoadedTree(){
        service.upLoadTree();
        getTreeInfo();
    }

}
