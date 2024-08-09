package ru.gb.family_tree.presenter;

import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.info_collector.InfoCollector;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.enums.Gender;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.model.writer.FileHandler;
import ru.gb.family_tree.model.writer.Writer;
import ru.gb.family_tree.view.Ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Presenter {
    private Ui ui;
    private Service service;

    public Presenter(Ui ui, Writer writer) {
        this.ui = ui;
        service = new Service(writer);
    }

    public void addHuman(boolean ignoreSuccessMessage, String name, String patronymic, String surname,
                    Gender gender, Human father, Human mother,
                    List<Human> children, String profession,
                    String nationality, LocalDate dateOfBirth, LocalDate dateOfDeath,
                    String birthPlace, String notes){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(" ");
        stringBuilder.append(patronymic);
        stringBuilder.append(" ");
        stringBuilder.append(surname);
        stringBuilder.append(" ");
        service.addHuman(name, patronymic, surname,
                gender, father, mother,
                children, profession,
                nationality, dateOfBirth, dateOfDeath,
                birthPlace, notes);
        if(!ignoreSuccessMessage){
            ui.printAnswer(stringBuilder.toString() + " успешно добавлен");
        }
    }

    public void editHuman(int id, InfoCollector infoCollector, List<CollectorItems> editedItems){
        if(service.editHuman(id, infoCollector, editedItems)){
            ui.printAnswer("Запись сохранена успешно!");
        } else {
            ui.printAnswer("Ошибка сохранения записи!");
        }
    }

    public void getFamilyTreeInfo(){
        String answer = service.getfamilyTreeInfo();
        ui.printAnswer(answer);
    }

    public Map<String, Integer> getInfoForChooseParents(Gender gender){
        return service.getInfoForChooseParents(gender);
    }

    public Map<String, Integer> getInfoForChooseChildren(LocalDate dateOfBirthday, LocalDate dateOfDeath){
        return service.getInfoForChooseChildren(dateOfBirthday, dateOfDeath);
    }

    public Map<String, Integer> getInfoForEdit(){
        return service.getInfoForEdit();
    }

    public void sortByName(){
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByAge(){
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void sortByBirthday(){
        service.sortByBirthday();
        getFamilyTreeInfo();
    }

    public void sortById(){
        service.sortById();
        getFamilyTreeInfo();
    }

    public void saveFamTreeToFile(String fileName){
        boolean success = service.saveFamTreeToFile(fileName);
        if(success){
            ui.printAnswer("Файл " + fileName + ".fmt успешно сохранен!");
        }
    }

    public void loadFamTreeFromFile(String fileName){
        boolean success = false;
        if(!service.IsEmpty()){
            if(ui.askForReload()){
                success = service.loadFamTreeFromFile(fileName);
            }
        } else {
            success = service.loadFamTreeFromFile(fileName);
        }
        if (success) ui.printAnswer("Файл " + fileName + " успешно загружен!");
    }

    public Human getHumanById(int id){
        return service.getHumanById(id);
    }

    public List<String> showSaveFiles(){
        return service.showSaveFiles();
    }

    public void searchHuman(String request){
        List<Human> searchResult = service.searchHuman(request);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Результаты поиска:");
        stringBuilder.append("\n");
        for(Human human : searchResult){
            stringBuilder.append(human.getName());
            stringBuilder.append(" ");
            stringBuilder.append(human.getPatronymic());
            stringBuilder.append(" ");
            stringBuilder.append(human.getSurname());
            stringBuilder.append(" ");
            stringBuilder.append(" ID: ");
            stringBuilder.append(human.getId());
            stringBuilder.append("\n");
        }
        ui.printAnswer(stringBuilder.toString());
    }
}
