package Presenter.Commands.ForDatabase;

import Model.Writer.Writer;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import Presenter.Recipient;
import View.View;

import java.io.IOException;

public class open extends Command implements Performing {
    private final View view;
    private final Writer writer;
    private final Recipient presenter;

    public open(View view, Recipient presenter, Writer writer){
        super("open", "Открыть семейное древо");

        this.view = view;
        this.writer = writer;
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        this.view.println("\tfile name: ");
        String fileName = this.view.nextLine();

        if (fileName.isEmpty()){
            this.view.printMessage("ERROR", "String cant be empty");

        } else {
            try {
               this.presenter.setFamilyTree(this.writer.open(fileName));

               this.presenter.setCurrentCommands(this.presenter.getFamilyTreeCommands());

               this.view.setConsoleName("Family tree");

               this.view.printMessage("Result", "Successful");

            } catch (IOException | ClassNotFoundException e) {
                this.view.printMessage("ERROR", "Execution error");
            }
        }
    }
}
