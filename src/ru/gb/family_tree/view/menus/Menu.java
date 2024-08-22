package ru.gb.family_tree.view.menus;

import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.commands.Command;

import java.util.List;
import java.util.ArrayList;

/**
 * Класс {@code Menu} представляет собой меню команд для пользовательского интерфейса.
 * Он хранит список команд и предоставляет методы для отображения меню и выполнения выбранных команд.
 */
public class Menu {
    /**
     * Список команд, доступных в меню.
     */
    List<Command> commandList;

    /**
     * Конструктор класса {@code Menu}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, используемый для взаимодействия с пользовательским интерфейсом.
     */
    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
    }

    /**
     * Формирует строку с описанием всех команд в меню.
     *
     * @return строку, содержащую описание всех команд в формате "номер. описание".
     */
    public String menu(){
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
     * Выполняет команду, соответствующую выбранному номеру.
     *
     * @param choice номер выбранной команды.
     * @throws IndexOutOfBoundsException если {@code choice} выходит за пределы диапазона доступных команд.
     */
    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    /**
     * Возвращает количество команд в меню.
     *
     * @return количество команд в меню.
     */
    public int getSize(){
        return commandList.size();
    }
}
