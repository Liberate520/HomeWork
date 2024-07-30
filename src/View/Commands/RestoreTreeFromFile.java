package View.Commands;

import View.Command;

import java.io.IOException;

public class RestoreTreeFromFile extends Command {

    public RestoreTreeFromFile(){
        super("Загрузить дерево из файла");
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        presenter.RestoreTreeFromFile();
        System.out.println("Дерево загружено из файла FamilyTree.out");
    }
}
