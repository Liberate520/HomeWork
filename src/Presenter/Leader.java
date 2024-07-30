package Presenter;

import Model.FamilyTree.Tree;
import Model.Writer.Writer;
import Presenter.Commands.Command;
import Presenter.Commands.Common.*;
import Presenter.Commands.ForDatabase.*;
import Presenter.Commands.ForFamilyTree.*;
import Presenter.Commands.Performing;
import View.View;

import java.util.ArrayList;
import java.util.TreeMap;

public class Leader implements Recipient {
    private final Writer writer;
    private final View view;
    private Tree familyTree = null;

    private final TreeMap<String, Performing> databaseCommands = new TreeMap<>();
    private final TreeMap<String, Performing> familyTreeCommands = new TreeMap<>();
    private TreeMap<String, Performing> currentCommands;

    public Leader(View view, Writer writer){
        this.writer = writer;
        this.view = view;

        this.view.setPresenter(this);
        this.view.setConsoleName("Database");

        addCommand(new Presenter.Commands.ForDatabase.exit(this.view), this.databaseCommands);

        addCommand(new open(this.view, this, this.writer), this.databaseCommands);

        addCommand(new new_tree(this.view, this), this.databaseCommands);

        addCommand(new Presenter.Commands.ForDatabase.print(this.view, this.writer), this.databaseCommands);

        addCommand(new set_description(this.view, this.writer), this.databaseCommands);

        addCommand(new print_saves(this.view, this.writer.getDirName()), this.databaseCommands);

        addCommand(new commands(
                this.view,
                new ArrayList<>(this.databaseCommands.values())),
                this.databaseCommands
        );

        setCurrentCommands(this.databaseCommands);
    }

    public void acceptInput(String userInput){
        if (userInput.isEmpty())
            this.view.printMessage("ERROR", "String cant be empty");

        if (!this.currentCommands.containsKey(userInput))
            this.view.printMessage("ERROR", "Unknown command");

        else execute(userInput);
    }

    public void setFamilyTree(Tree familyTree){
        if (familyTree != null){
            this.familyTree = familyTree;

            this.familyTreeCommands.clear();

            addCommand(new Presenter.Commands.ForFamilyTree.exit(this.view, this), this.familyTreeCommands);

            addCommand(new save(this.view, this.familyTree, this.writer), this.familyTreeCommands);

            addCommand(new print_tree(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new add(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new del(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new set_name(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new set_surname(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new set_gender(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new set_spouse(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new set_mather(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new set_father(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new set_data_of_birth(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new set_data_of_death(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new add_kid(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new find(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new Presenter.Commands.ForFamilyTree.print(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new sort_by_name(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new sort_by_surname(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new sort_by_ID(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new sort_by_children(this.view, this.familyTree), this.familyTreeCommands);

            addCommand(new commands(
                    this.view,
                    new ArrayList<>(this.familyTreeCommands.values())),
                    this.familyTreeCommands
            );
        }
    }

    public TreeMap<String, Performing> getDatabaseCommands() {
        return databaseCommands;
    }

    public TreeMap<String, Performing> getFamilyTreeCommands() {
        return familyTreeCommands;
    }

    public void setCurrentCommands(TreeMap<String, Performing> currentCommands) {
        this.currentCommands = currentCommands;
    }

    public Tree getFamilyTree(){
        return this.familyTree;
    }

    private void execute(String commandName){
        this.currentCommands.get(commandName).execute();
    }

    private void addCommand(Command command, TreeMap<String, Performing> list) {
        list.put(command.getKey(), command);
    }
}
