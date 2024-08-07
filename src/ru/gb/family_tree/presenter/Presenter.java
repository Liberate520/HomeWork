package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.SpouseStatus;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

/**
 * Класс {@code Presenter} представляет собой контроллер, который управляет взаимодействием
 * между {@code View} и {@code Service}. Он обрабатывает запросы от представления, выполняет
 * соответствующие операции через сервис и передает результаты обратно в представление.
 */
public class Presenter {
    private View view;
    private Service service;

    /**
     * Конструктор класса {@code Presenter}.
     *
     * @param view представление, которое будет использоваться для вывода информации.
     */
    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    /**
     * Добавляет нового члена семьи.
     *
     * @param name имя нового члена семьи.
     * @param gender пол нового члена семьи.
     * @param date дата рождения нового члена семьи в строковом формате.
     * @return {@code true}, если добавление прошло успешно; {@code false} в случае ошибки.
     */
    public boolean addMember(String name, Gender gender, String date) {
        service.addMember(name, gender, date);
        return true;
    }

    /**
     * Устанавливает дату смерти для члена семьи по его идентификатору.
     *
     * @param personId идентификатор члена семьи.
     * @param dod дата смерти.
     * @return {@code true}, если установка даты смерти прошла успешно; {@code false} в случае ошибки.
     */
    public boolean setDeathDate(int personId, LocalDate dod) {
        if (service.checkById(personId)) {
            service.setDeathDate(personId, dod);
            return true;
        }
        return false;
    }

    /**
     * Устанавливает родителя для члена семьи по его идентификатору.
     *
     * @param memberId идентификатор члена семьи.
     * @param parentId идентификатор родителя.
     * @return {@code true}, если установка родителя прошла успешно; {@code false} в случае ошибки.
     */
    public boolean setParent(int memberId, int parentId){
        if (service.checkById(memberId) & service.checkById(parentId)){
            service.setParent(memberId, parentId);
            return true;
        }
        return false;
    }

    /**
     * Устанавливает супруга для двух членов семьи.
     *
     * @param firstMemberId идентификатор первого члена семьи.
     * @param secondMemberId идентификатор второго члена семьи.
     * @param spouseStatus статус брака.
     * @return {@code true}, если установка супруга прошла успешно; {@code false} в случае ошибки.
     */
    public boolean setSpouse(int firstMemberId, int secondMemberId, SpouseStatus spouseStatus) {
        if (service.checkById(firstMemberId) & service.checkById(secondMemberId)) {
            service.setSpouse(firstMemberId, secondMemberId, spouseStatus);
            return true;
        }
        return false;
    }

    /**
     * Получает информацию о всей семье и передает её в представление.
     */
    public void getAboutFamily() {
        view.printAnswer(service.getAboutFamily());
    }

    /**
     * Сортирует членов семьи по возрасту и передает отсортированный список в представление.
     */
    public void sortTreeByAge() {
        view.printAnswer(service.sortTreeByAge());
    }

    /**
     * Сортирует членов семьи по имени и передает отсортированный список в представление.
     */
    public void sortTreeByName() {
        view.printAnswer(service.sortTreeByName());
    }

    /**
     * Считывает данные из файла и обновляет состояние сервиса.
     *
     * @param path путь к файлу, из которого нужно считать данные.
     * @return {@code true}, если чтение прошло успешно; {@code false} в случае ошибки.
     */
    public boolean read(String path) {
        return service.read(path);
    }

    /**
     * Записывает данные в файл.
     *
     * @param path путь к файлу, в который нужно записать данные.
     * @return {@code true}, если запись прошла успешно; {@code false} в случае ошибки.
     */
    public boolean write(String path) {
        return service.write(path);
    }
}
