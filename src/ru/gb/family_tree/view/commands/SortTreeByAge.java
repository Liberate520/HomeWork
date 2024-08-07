package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Команда {@code SortTreeByAge} предназначена для вывода списка членов семьи, отсортированного по возрасту.
 *
 * <p>Этот класс расширяет абстрактный класс {@code Command} и реализует метод {@code execute},
 * который вызывает метод {@code sortTreeByAge} в {@code ConsoleUI} для сортировки и отображения
 * членов семьи по возрасту.</p>
 */
public class SortTreeByAge extends Command {

    /**
     * Конструктор класса {@code SortTreeByAge}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     */
    public SortTreeByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список членов семьи в порядке сортировки по возрасту";
    }

    /**
     * Выполняет команду сортировки списка членов семьи по возрасту, вызывая метод {@code sortTreeByAge}
     * в {@code ConsoleUI}.
     */
    @Override
    public void execute() {
        consoleUI.sortTreeByAge();
    }
}
