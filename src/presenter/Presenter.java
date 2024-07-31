package presenter;

import model.human.Gender;
import model.service.Service;
import model.writer.DataHandler;
import view.View;

import java.io.Serializable;
import java.time.LocalDate;

public class Presenter {
    private String filePath;
    private View view;
    private Service service;
    private DataHandler dataHandler;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
        dataHandler = new DataHandler();
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
        this.filePath = filePath;
        dataHandler.setPath(filePath);
    }

    public void save(){
        dataHandler.setPath(filePath);
        dataHandler.save(service);
    }

    public Serializable load(){
        dataHandler.setPath(filePath);
        service = (Service) dataHandler.read();
        return service;

//        dataHandler.setPath(filePath);
//        Serializable loadedData = (Serializable)dataHandler.read();
//        service = (Service) loadedData;
//        return service;
    }
}
