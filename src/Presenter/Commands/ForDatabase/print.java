package Presenter.Commands.ForDatabase;

import Model.Writer.Writer;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

import java.io.IOException;

public class print extends Command implements Performing {
    private final View view;
    private final Writer writer;

    public print(View view, Writer writer){
        super("print", "Вывод описания семейного древа");

        this.view = view;
        this.writer = writer;
    }

    @Override
    public void execute() {
        this.view.println("\tFile name: ");
        String fileName = this.view.nextLine();

        if (fileName.isEmpty()){
            this.view.printMessage("ERROR", "String cant be empty");

        } else {
            try{
                this.view.printMessage("Description", this.writer.open(fileName).getDescription());

            } catch (IOException | ClassNotFoundException e){
                this.view.printMessage("ERROR", "Execution error");
            }
        }
    }
}
