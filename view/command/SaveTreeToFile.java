package homeWork.view.command;

import homeWork.view.Console;

public class SaveTreeToFile extends Command{
     public SaveTreeToFile(Console console) {
        super("Сохранить дерево в файл", console);
    }

    public void execute(){
        console.saveTreeToFile();
    }
}
