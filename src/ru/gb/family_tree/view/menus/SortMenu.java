package ru.gb.family_tree.view.menus;

import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.commands.GetNoSortTree;
import ru.gb.family_tree.view.commands.SortTreeByAge;
import ru.gb.family_tree.view.commands.SortTreeByName;

/**
 * Меню сортировки {@code SortMenu} предоставляет команды для сортировки списка членов семьи.
 *
 * <p>Этот класс расширяет абстрактный класс {@code Menu} и инициализирует список команд,
 * доступных в меню сортировки. Команды включают вывод неотсортированного списка, а также сортировку
 * списка по возрасту и по имени.</p>
 */
public class SortMenu extends Menu {

    /**
     * Конструктор класса {@code SortMenu}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     *                  Передается в конструктор родительского класса {@code Menu} и используется
     *                  для создания команд.
     */
    public SortMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetNoSortTree(consoleUI));
        commandList.add(new SortTreeByAge(consoleUI));
        commandList.add(new SortTreeByName(consoleUI));
    }
}
