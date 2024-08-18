package family_tree.pesenter;

import family_tree.model.help_classes.Gender;
import family_tree.model.program_classes.Human;
import family_tree.model.saving_data.FileHandler;
import family_tree.model.services.HumanService;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;

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
        Human child  = service.findByDocument(childDoc);
        Human parent  = service.findByDocument(parentDoc);
        if (child == null || parent == null) {
            view.printAnswer("Один или несколько членов семьи не найдены");
        }
        else {
            service.addFamilyLink(child, parent);
            view.printAnswer("Данные добавлены");
        }
    }

    public void registerDeath(String doc, LocalDate date) {
        Human human  = service.findByDocument(doc);
        if (human == null) {
            view.printAnswer("Запись не найдена");
        }
        else {
            service.registerDeath(human, date);
            view.printAnswer("Данные добавлены");
        }
    }

    public void findByDocument(String doc) {
        StringBuilder answer = new StringBuilder();
        Human human = service.findByDocument(doc);
        if (human != null) {
            answer.append(createHeader());
            answer.append(service.findByDocument(doc).toString());
        }
        else {
            answer.append("Не найдено");
        }
        view.printAnswer(answer.toString());
    }

    public void findByName(String name) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Human> list = service.findByName(name);
        if (list.isEmpty()) {
            answer.append("Данные не найдены");
        }
        else {
            answer.append(createHeader());
            for (Human human : list) {
                answer.append(human);
                answer.append("\n");
            }
        }
        view.printAnswer(answer.toString());
    }

    public void getTreeInfo() {
        StringBuilder answer = new StringBuilder();
        answer.append(createHeader());
        answer.append(service.getTreeInfo());
        view.printAnswer(answer.toString());
    }

    private String createHeader() {
        StringBuilder header = new StringBuilder();
        Formatter formatter = new Formatter(header);
        formatter.format("|%13s | " +
                        "%13s |" +
                        "%13s |" +
                        "%14s |" +
                        "%13s |" +
                        "%13s |" +
                        "%13s |" +
                        "%50s |"
                , "Документ",
                "Имя",
                "Пол",
                "Дата рождения",
                "Дата смерти",
                "Мать",
                "Отец",
                "Дети");
        String header_line = "";
        for (int i = 0; i < header.length(); i++) {
            header_line += "-";
        }
        StringBuilder answer = new StringBuilder();
        answer.append(header_line);
        answer.append("\n");
        answer.append(header);
        answer.append("\n");
        answer.append(header_line);
        answer.append("\n");
        return answer.toString();
    }
}
