package family_tree.pesenter;

import family_tree.model.help_classes.Gender;
import family_tree.model.services.HumanService;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter {
    private View view;
    private HumanService service;

    public Presenter(View view) {
        this.view = view;
        this.service = new HumanService();
    }

    public void saveDataFile(String filePath) {
        if (service.saveDataFile(filePath)) {
            view.printAnswer("Данные сохранены");
        }
        else {
            view.printAnswer("Не удалось сохранить");
        }
    }

    public void loadDataFile(String filePath) {
        service.loadDataFile(filePath);
    }

    public void addHuman(String doc, String name, Gender gender, LocalDate birth) {
        if (service.addHuman(doc, name, gender, birth)) {
            view.printAnswer("Запись успешно добавлена");
        }
        else {
            view.printAnswer("Не удалось добавить");
        }
    }

    public void sortByName() {
        service.sortByName();
        getTreeInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getTreeInfo();
    }

    public void addFamilyLink(String childDoc, String parentDoc) {
            if (service.addFamilyLink(childDoc, parentDoc)) {
                view.printAnswer("Данные добавлены");
            }
            else {
                view.printAnswer("Один или несколько членов семьи не найдены");
            }
    }

    public void registerDeath(String doc, LocalDate date) {
        if (service.registerDeath(doc, date)) {
            view.printAnswer("Запись не найдена");
        }
        else {
            view.printAnswer("Данные добавлены");
        }
    }

    public void findByDocument(String doc) {
        if (service.findByDocument(doc) != null) {
            ArrayList<String> answer = new ArrayList<>();
            answer.add(service.findByDocument(doc).getNamesHeader());
            answer.add(service.findByDocument(doc).toString());
            view.printTable(answer);
        }
        else {
            view.printAnswer("Не найдено");
        }
    }

    public void findByName(String name) {
        if (service.findByName(name).isEmpty()) {
            view.printAnswer("Данные не найдены");
        }
        else {
            ArrayList<String> answer = new ArrayList<>();
            answer.add(service.findByName(name).get(0).getNamesHeader());
            for (Object o : service.findByName(name)) {
                answer.add(o.toString());
            }
            view.printTable(answer);
        }
    }

    public void getTreeInfo() {
        if ( service.getTreeInfo().isEmpty()) {
            view.printAnswer("Данные не найдены");
        }
        else {
            ArrayList<String> answer = new ArrayList<>();
            answer.add(service.getTreeInfo().get(0).getNamesHeader());
            for (Object o :  service.getTreeInfo()) {
                answer.add(o.toString());
            }
            view.printTable(answer);
        }
    }
}
