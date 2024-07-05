package main;

import presenters.Presenter;
import services.FamilyTreeService;
import services.FamilyTreeServiceImpl;
import views.ConsoleView;
import views.View;

/**
 * Класс Main является точкой входа в приложение для работы с генеалогическим древом.
 * В классе Main реализован паттерн MVP, где View запускается и пользователь взаимодействует с ней.
 */
public class Main {
    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Создание объектов представления, сервиса и презентера
        View view = new ConsoleView();
        FamilyTreeService familyTreeService = new FamilyTreeServiceImpl();
        Presenter presenter = new Presenter(view, familyTreeService);

        // Запуск приложения
        view.start(presenter);
    }
}