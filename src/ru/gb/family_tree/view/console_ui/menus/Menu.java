package ru.gb.family_tree.view.console_ui.menus;

public interface Menu {
    String showMenu();
    void execute(int choice);
    int size();
}
