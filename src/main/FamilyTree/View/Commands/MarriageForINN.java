package FamilyTree.View.Commands;


import FamilyTree.View.ConsoleUI;

public class MarriageForINN extends Commands {
    private String description;
    private ConsoleUI consoleUI;

    public MarriageForINN(ConsoleUI consoleUI) {
        super("Оба партнера есть в дереве -> регистрация по ИНН", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().marriageForINN();
    }
}
