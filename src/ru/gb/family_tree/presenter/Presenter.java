package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.SpouseStatus;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

/**
 * Класс {@code Presenter} представляет собой контроллер для работы с данными семьи.
 * Он взаимодействует с моделью и представлением для управления семейным деревом.
 */
public class Presenter {
    private View view;
    private Service service;

    /**
     * Конструктор для создания экземпляра {@code Presenter}.
     *
     * @param view объект представления, который будет использоваться для отображения данных
     */
    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    /**
     * Добавляет нового члена семьи.
     *
     * @param name имя нового члена семьи
     * @param gender пол нового члена семьи
     * @param date дата рождения нового члена семьи в формате "yyyy-MM-dd"
     * @return {@code true}, если член семьи был успешно добавлен
     */
    public boolean addMember(String name, Gender gender, String date) {
        service.addMember(name, gender, date);
        return true;
    }

    /**
     * Устанавливает дату смерти для указанного члена семьи.
     *
     * @param personId идентификатор члена семьи
     * @param dod дата смерти в формате {@code LocalDate}
     * @return {@code true}, если дата смерти была успешно установлена, иначе {@code false}
     */
    public boolean setDeathDate(int personId, LocalDate dod) {
        if (service.checkById(personId)) {
            service.setDeathDate(personId, dod);
            return true;
        }
        return false;
    }

    /**
     * Устанавливает родителя для указанного члена семьи.
     *
     * @param memberId идентификатор члена семьи, для которого устанавливается родитель
     * @param parentId идентификатор родителя
     * @return {@code true}, если родитель был успешно установлен, иначе {@code false}
     */
    public boolean setParent(int memberId, int parentId){
        if (service.checkById(memberId) & service.checkById(parentId)){
            service.setParent(memberId,parentId);
            return true;
        }
        return false;
    }

    /**
     * Устанавливает супруга для двух членов семьи.
     *
     * @param firstMemberId идентификатор первого супруга
     * @param secondMemberId идентификатор второго супруга
     * @param spouseStatus статус супружеских отношений
     * @return {@code true}, если супруги были успешно установлены, иначе {@code false}
     */
    public boolean setSpouse(int firstMemberId, int secondMemberId, SpouseStatus spouseStatus) {
        if (service.checkById(firstMemberId) & service.checkById(secondMemberId)) {
            service.setSpouse(firstMemberId, secondMemberId, spouseStatus);
            return true;
        }
        return false;
    }

    /**
     * Получает информацию о семье и отображает ее через представление.
     */
    public void getAboutFamily() {
        view.printAnswer(service.getAboutFamily());
    }

    /**
     * Сортирует семейное дерево по возрасту и отображает результат через представление.
     */
    public void sortTreeByAge() {
        view.printAnswer(service.sortTreeByAge());
    }

    /**
     * Сортирует семейное дерево по имени и отображает результат через представление.
     */
    public void sortTreeByName() {
        view.printAnswer(service.sortTreeByName());
    }

    /**
     * Считывает данные семьи из файла.
     *
     * @param path путь к файлу
     * @return {@code true}, если данные были успешно считаны, иначе {@code false}
     */
    public boolean read(String path) {
        return service.read(path);
    }

    /**
     * Записывает данные семьи в файл.
     *
     * @param path путь к файлу
     * @return {@code true}, если данные были успешно записаны, иначе {@code false}
     */
    public boolean write(String path) {
        return service.write(path);
    }
}
