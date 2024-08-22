package ru.gb.family_tree.view.menus;

import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.commands.GetNoSortTree;
import ru.gb.family_tree.view.commands.SortTreeByAge;
import ru.gb.family_tree.view.commands.SortTreeByName;

/**
 * Класс {@code SortMenu} представляет собой меню для сортировки дерева семейных данных.
 * Этот класс расширяет {@code Menu} и инициализирует список команд, связанных с сортировкой дерева.
 */
public class SortMenu extends Menu {

    /**
     * Конструктор класса {@code SortMenu}.
     * Инициализирует список команд, добавляя команды для получения неотсортированного дерева,
     * сортировки дерева по возрасту и сортировки дерева по имени.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, используемый для взаимодействия с пользовательским интерфейсом.
     */
    public SortMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetNoSortTree(consoleUI));
        commandList.add(new SortTreeByAge(consoleUI));
        commandList.add(new SortTreeByName(consoleUI));
    }
}
