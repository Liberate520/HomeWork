package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.SpouseStatus;
import ru.gb.family_tree.view.View;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.model.tools.writer.FileHandler;

import java.time.LocalDate;

/**
 * Класс Presenter служит связующим звеном между представлением (View) и моделью (Service).
 * Он обрабатывает ввод пользователя и направляет соответствующие команды в модель,
 * а также обновляет представление в соответствии с результатами выполнения этих команд.
 */
public class Presenter {
    private View view;
    private Service service;

    /**
     * Конструктор Presenter инициализирует объект с представлением и сервисом.
     *
     * @param view Объект представления (View) для взаимодействия с пользователем.
     */
    public Presenter(View view) {
        this.view = view;
        service = new Service(new FileHandler<Human>());
    }

    /**
     * Добавляет нового члена семьи в генеалогическое древо.
     *
     * @param name Имя нового члена семьи.
     * @param gender Пол нового члена семьи.
     * @param date Дата рождения нового члена семьи.
     * @return Возвращает true, если добавление прошло успешно.
     */
    public boolean addMember(String name, Gender gender, String date) {
        service.addMember(name, gender, date);
        return true;
    }

    /**
     * Устанавливает дату смерти для члена семьи.
     *
     * @param personId ID члена семьи.
     * @param dod Дата смерти.
     * @return Возвращает true, если дата смерти успешно установлена, иначе false.
     */
    public boolean setDeathDate(int personId, LocalDate dod) {
        if (service.checkById(personId)) {
            service.setDeathDate(personId, dod);
            return true;
        }
        return false;
    }

    /**
     * Устанавливает родительскую связь между двумя членами семьи.
     *
     * @param memberId ID члена семьи.
     * @param parentId ID родителя.
     * @return Возвращает true, если родительская связь успешно установлена, иначе false.
     */
    public boolean setParent(int memberId, int parentId) {
        if (service.checkById(memberId) & service.checkById(parentId)) {
            service.setParent(memberId, parentId);
            return true;
        }
        return false;
    }

    /**
     * Устанавливает супружеские отношения между двумя членами семьи.
     *
     * @param firstMemberId ID первого члена семьи.
     * @param secondMemberId ID второго члена семьи.
     * @param spouseStatus Статус супружеских отношений.
     * @return Возвращает true, если супружеские отношения успешно установлены, иначе false.
     */
    public boolean setSpouse(int firstMemberId, int secondMemberId, SpouseStatus spouseStatus) {
        if (service.checkById(firstMemberId) & service.checkById(secondMemberId)) {
            service.setSpouse(firstMemberId, secondMemberId, spouseStatus);
            return true;
        }
        return false;
    }

    /**
     * Выводит информацию о генеалогическом древе в представление.
     */
    public void getAboutFamily() {
        view.printAnswer(service.getAboutFamily());
    }

    /**
     * Сортирует генеалогическое древо по возрасту и выводит результат в представление.
     */
    public void sortTreeByAge() {
        view.printAnswer(service.sortTreeByAge());
    }

    /**
     * Сортирует генеалогическое древо по имени и выводит результат в представление.
     */
    public void sortTreeByName() {
        view.printAnswer(service.sortTreeByName());
    }

    /**
     * Читает генеалогическое древо из файла.
     *
     * @param path Путь к файлу.
     * @return Возвращает true, если чтение прошло успешно, иначе false.
     */
    public boolean read(String path) {
        return service.read(path);
    }

    /**
     * Записывает текущее генеалогическое древо в файл.
     *
     * @param path Путь к файлу.
     * @return Возвращает true, если запись прошла успешно, иначе false.
     */
    public boolean write(String path) {
        return service.write(path);
    }
}
