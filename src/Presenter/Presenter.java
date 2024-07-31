package Presenter;

import Model.Human.Gender;
import Model.Service.Service;
import View.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender){
        String answer;
        if (service.addHumanToTree(name, birthDate, gender)){
            answer = "Добавление прошло успешно";
        } else answer = "Добавление не состоялось";
        view.answer(answer);
    }

    public void getFamilyTreeInfo() {
        String answer = service.familyTreeInfo();
        view.answer(answer);
    }

    public void sortByName() {
        service.sortByNameFamilyTree();
        getFamilyTreeInfo();
    }

    public void sortByAge() {
        service.sortByBirthDayFamilyTree();
        getFamilyTreeInfo();
    }

    public boolean saveToFile() throws IOException{
        return service.writeToFileTree(service.getFamilyTree());

    }

    public Object readFileFamilyTree() throws IOException, ClassNotFoundException{
        return service.readTreeInFile();
    }

    public boolean addParent(long idParent, long idChild){
        return service.addParent(idParent, idChild);
    }
    public boolean addChild(long idParent, long idChild){
        return service.addChild(idParent, idChild);
    }
}
