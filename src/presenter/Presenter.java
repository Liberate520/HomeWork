package presenter;

import model.human.Human;
import model.human.Sex;
import model.service.Service;
import model.writer.MyWriter;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;
    private final static String ITEM_UPDATED = "Запись обновлена:";

    public Presenter(View view, MyWriter handler) {
        this.view = view;
        service = new Service(handler);
    }

    public void getFamilyTree() {
        String answer = service.printList(service.getFamilyTree());
        view.printAnswer(answer);
    }

    public void add(String name, LocalDate birthDate, LocalDate deathDate, Sex sex, Human father, Human mother) {
        service.add(name, birthDate, deathDate, sex, father, mother);
        view.printAnswer("Запись добавлена.");
        getFamilyTree();
    }

    public void findByName(String name) {
        String answer = service.printList(service.findByName(name));
        view.printAnswer(answer);
    }

    public Human findById(int id) {
        return service.findById(id);
    }

    public void sortByName() {
        service.sortByName();
        String answer = service.printList(service.getFamilyTree());
        view.printAnswer(answer);
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        String answer = service.printList(service.getFamilyTree());
        view.printAnswer(answer);
    }

    public void sortByAge() {
        service.sortByAge();
        String answer = service.printList(service.getFamilyTree());
        view.printAnswer(answer);
    }

    public void setBirthDate(Human human, LocalDate birthDate) {
        service.setBirthDate(human, birthDate);
        String answer = ITEM_UPDATED + human.toString();
        view.printAnswer(answer);
    }

    public void setDeathDate(Human human, LocalDate deathDate) {
        service.setDeathDate(human, deathDate);
        String answer = ITEM_UPDATED + human.toString();
        view.printAnswer(answer);
    }

    public void setParents(Human human, Human father, Human mother) {
        service.setParents(human, father, mother);
        String answer = ITEM_UPDATED + human.toString();
        view.printAnswer(answer);
    }

    public void save() {
        if (service.save())
            view.printAnswer("Данные сохранены.");
        else 
            view.printAnswer("Ошибка сохранения.");
    }

    public void load() {
        if (service.load())
            view.printAnswer("Данные загружены.");
        else 
            view.printAnswer("Ошибка загрузки.");
    }
}
