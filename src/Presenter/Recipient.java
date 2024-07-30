package Presenter;

import Model.FamilyTree.Tree;
import Presenter.Commands.Performing;

import java.util.TreeMap;

public interface Recipient {
    void acceptInput(String userInput);

    void setFamilyTree(Tree familyTree);

    TreeMap<String, Performing> getDatabaseCommands();

    TreeMap<String, Performing> getFamilyTreeCommands();

    Tree getFamilyTree();

    void setCurrentCommands(TreeMap<String, Performing> currentCommands);
}