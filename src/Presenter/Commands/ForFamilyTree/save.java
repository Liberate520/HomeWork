package Presenter.Commands.ForFamilyTree;

import Model.FamilyTree.Tree;
import Model.Writer.Writer;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

import java.io.IOException;

public class save extends Command implements Performing {
    private final View view;
    private final Tree familyTree;
    private final Writer writer;

    public save(View view, Tree familyTree, Writer writer){
        super("save", "Сохранение дерева");

        this.view = view;
        this.familyTree = familyTree;
        this.writer = writer;
    }

    @Override
    public void execute() {
        this.view.println("\tFile name: ");
        String fileName = this.view.nextLine();

        if (fileName.isEmpty()){
            this.view.printMessage("ERROR", "String cant be empty");

        } else {
            try {
                this.writer.save(this.familyTree, fileName);

                this.view.printMessage("Result", "Successful");

            } catch (IOException e){
                this.view.printMessage("ERROR", "Execution error");
            }
        }
    }
}
