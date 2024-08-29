package Homework4_OOP;

import Homework4_OOP.Services.FamilyTreeService;
import Homework4_OOP.WritersClasses.Presenter;
import Homework4_OOP.WritersClasses.UserInterface;

public class Main {
    public static void main(String[] args) {
        // Создание сервисного класса
        FamilyTreeService service = new FamilyTreeService();

        // Создание представления
        UserInterface ui = new UserInterface();

        // Создание презентера, который связывает представление и сервис
        Presenter presenter = new Presenter(ui, service);

        // Запуск приложения через презентер
        presenter.start();
    }
}
