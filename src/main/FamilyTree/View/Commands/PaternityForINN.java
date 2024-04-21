package FamilyTree.View.Commands;


import FamilyTree.View.ConsoleUI;

public class PaternityForINN extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public PaternityForINN(ConsoleUI consoleUI) {
        super("Родитель и ребенок есть в дереве -> добавление по ИНН", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().paternityForINN();
    }
}
