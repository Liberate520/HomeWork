package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Команда {@code SortTreeByName} предназначена для вывода списка членов семьи, отсортированного по имени.
 *
 * <p>Этот класс расширяет абстрактный класс {@code Command} и реализует метод {@code execute},
 * который вызывает метод {@code sortTreeByName} в {@code ConsoleUI} для сортировки и отображения
 * членов семьи по имени.</p>
 */
public class SortTreeByName extends Command {

    /**
     * Конструктор класса {@code SortTreeByName}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     */
    public SortTreeByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список членов семьи в порядке сортировки по имени";
    }

    /**
     * Выполняет команду сортировки списка членов семьи по имени, вызывая метод {@code sortTreeByName}
     * в {@code ConsoleUI}.
     */
    @Override
    public void execute() {
        consoleUI.sortTreeByName();
    }
}
