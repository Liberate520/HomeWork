package family_tree.pesenter;

import family_tree.model.help_classes.Gender;
import family_tree.model.program_classes.Human;
import family_tree.model.program_classes.HumanService;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.ArrayList;

public class HumanPresenter {
    private View view;
    private HumanService service;

    public HumanPresenter(View view) {
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
        if (service.loadDataFile(filePath)) {
            view.printAnswer("Данные загружены");
        }
        else {
            view.printAnswer("Не удалось загрузить данные");
        }
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
        Human human = service.findByDocument(doc);
        if (human != null) {
            ArrayList<String> answer = new ArrayList<>();
            answer.add(human.getNamesHeader());
            answer.add(human.toString());
            view.printTable(answer);
        }
        else {
            view.printAnswer("Не найдено");
        }
    }

    public void findByName(String name) {
        ArrayList<Human> humans = service.findByName(name);
        if (humans.isEmpty()) {
            view.printAnswer("Данные не найдены");
        }
        else {
            ArrayList<String> answer = new ArrayList<>();
            answer.add(humans.getFirst().getNamesHeader());
            for (Object o : humans) {
                answer.add(o.toString());
            }
            view.printTable(answer);
        }
    }

    public void getTreeInfo() {
        ArrayList<Human> humans = service.getTreeInfo();
        if ( humans.isEmpty()) {
            view.printAnswer("Данные не найдены");
        }
        else {
            ArrayList<String> answer = new ArrayList<>();
            answer.add(humans.getFirst().getNamesHeader());
            for (Object o :  humans) {
                answer.add(o.toString());
            }
            view.printTable(answer);
        }
    }
}
