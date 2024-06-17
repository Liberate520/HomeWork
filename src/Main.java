import Presenter.FamilyTreePresenter;
import model.*;
import model.FamilyTreeService;
import view.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляра TreeIO<Node> для операций ввода-вывода
        TreeIO<Node> ioOperations = new FileTreeIO();

        // Создание экземпляра FamilyTreeService с использованием ioOperations
        FamilyTreeService familyTreeService = new FamilyTreeService(ioOperations);

        // Создание экземпляра FamilyTreePresenter с передачей FamilyTreeService
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTreeService);

        // Создание экземпляра Scanner для ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Создание экземпляра UserInterface с передачей presenter и scanner
        UserInterface ui = new UserInterface(presenter, scanner);

        // Передача presenter в UserInterface (если необходимо)
        // ui.setPresenter(presenter); // Эта строка не нужна, так как presenter передается через конструктор

        // Запуск интерфейса пользователя
        ui.start();
    }
}