package homeWork.view.command;

import homeWork.view.Console;

public class LoadTreeFromFile extends Command{
    public LoadTreeFromFile(Console console) {
        super("Загрузить дерево из файла", console);
    }

    public void execute(){
        console.loadTreeFromFile();
    }
}
