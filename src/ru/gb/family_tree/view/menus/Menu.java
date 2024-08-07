package ru.gb.family_tree.view.menus;

import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.commands.Command;

import java.util.List;
import java.util.ArrayList;

/**
 * Класс {@code Menu} представляет собой абстрактное меню, которое содержит список команд
 * и предоставляет методы для отображения меню и выполнения выбранной команды.
 *
 * <p>Меню инициализируется с помощью {@code ConsoleUI} и заполняется списком команд.
 * Предоставляет методы для отображения меню, выполнения команд и получения размера списка команд.</p>
 */
public class Menu {
    /**
     * Список команд, доступных в меню.
     */
    List<Command> commandList;

    /**
     * Конструктор класса {@code Menu}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     *                  Этот параметр не используется непосредственно в этом конструкторе, но необходим для инициализации команд.
     */
    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
    }

    /**
     * Возвращает строковое представление меню с перечнем доступных команд.
     *
     * <p>Каждая команда отображается с номером и описанием.</p>
     *
     * @return строка, представляющая меню.
     */
    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Выполняет команду по выбранному индексу.
     *
     * @param choice индекс команды для выполнения. Индексы начинаются с 1.
     * @throws IndexOutOfBoundsException если индекс выходит за границы списка команд.
     */
    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    /**
     * Возвращает количество команд в меню.
     *
     * @return количество команд.
     */
    public int getSize() {
        return commandList.size();
    }
}
