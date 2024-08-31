package presenter;

import model.human.Gender;
import model.service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate){
        service.addHuman(name, gender, birthDate);
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, String motherName, String fatherName){
        service.addHuman(name, gender, birthDate, motherName, fatherName);
    }

    public void getPeopleInfo(){
        String info = service.getPeopleInfo();
        view.printAnswer(info);
    }

    public void sortByName(){
        service.sortByName();
    }

    public void sortByAge(){
        service.sortByAge();
    }

    public void setWedding(String human1, String human2){
        service.setWedding(human1, human2);
    }

    public void setFilePath(String filePath) {
        service.setFilePath(filePath);
    }

    public void save(){
        service.save();
    }

    public void load() {
        service.load();
    }
}
