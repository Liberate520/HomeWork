package View.Commands;

import View.Command;

import java.io.IOException;

public class SaveTreeToFile extends Command {
    public SaveTreeToFile(){
        super("Сохранить дерево в файл");
    }

    @Override
    public void execute() throws IOException {
        if (presenter.savetoFile()){
            System.out.println("Объект успешно сериализован в файл ");
        }
    }
}
