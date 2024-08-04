package ru.gb2.family_tree7.presenter;

import ru.gb2.family_tree7.model.human.Gender;
import ru.gb2.family_tree7.model.human.Human;
import ru.gb2.family_tree7.model.service.Service;
import ru.gb2.family_tree7.view.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;
    private static int idCounter = 0; // Генерация ID

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    private int getNextId() {
        return ++idCounter;
    }

    public void addHuman(String name, String s, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        // Создаем новый объект Human
        Human newHuman = new Human(getNextId(), name, gender, birthDate, deathDate); // Генерация ID

        // Сохраняем нового человека в хранилище
        service.getHumanList().add(newHuman); // Добавляем в список людей

        // Устанавливаем родительские связи, если они указаны
        if (father != null) {
            father.addChild(newHuman); // Добавляем нового человека как ребенка к отцу
        }
        if (mother != null) {
            mother.addChild(newHuman); // Добавляем нового человека как ребенка к матери
        }

        getHumanListInfo(); // Обновляем вывод информации о людях
    }

    public void getHumanListInfo() {
        List<Human> humans = service.getHumanList(); // Предположим, что у вас есть метод, который возвращает список людей
        String info = service.getHumanInfo(); // Обновите метод, чтобы выводил информацию о всех людях
        view.printAnswer(info);
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void sortByGender() {
        service.sortByGender();
        getHumanListInfo();
    }

    public void sortByParents() {
        service.sortByPerents();
        getHumanListInfo();
    }

    public void sortByDeathDate() {
        service.sortByDeathDate();
        getHumanListInfo();
    }

    public void sortByChildren() {
        service.sortByChildren();
        getHumanListInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getHumanListInfo();
    }

    public Human findHumanById(int id) {
        return service.getHumanList().stream()
                .filter(human -> human.getId() == id)
                .findFirst()
                .orElse(null); // Используем стримы для поиска
    }
}
