package Presenter.Interface;

import Model.Interface.FamilyTreeInterface;

public interface FamilyTreeRecipient {
    void start();
    void acceptInput(String userInput);
    void setFamilyTree(FamilyTreeInterface<?> familyTree);
}