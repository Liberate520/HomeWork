package Presenter.Commands.ForDatabase;

import Model.FamilyTree.Tree;
import Model.Writer.Writer;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

import java.io.IOException;

public class set_description extends Command implements Performing {
    private final View view;
    private final Writer writer;

    public set_description(View view, Writer writer){
        super("set description", "Изменение описания семейного древа");

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
                Tree familyTree = this.writer.open(fileName);

                this.view.printMessage("Current description", familyTree.getDescription());

                this.view.println("\tNew Description: ");
                familyTree.setDescription(this.view.nextLine());

                writer.save(familyTree, fileName);

                this.view.printMessage("Result", "Successful");

            } catch (IOException | ClassNotFoundException e){
                this.view.printMessage("ERROR", "Execution error");
            }
        }
    }
}
