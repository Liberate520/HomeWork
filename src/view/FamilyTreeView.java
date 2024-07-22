package view;

import java.util.List;

public interface FamilyTreeView<T> {
    void showMenu();
    void displayTree(List<T> nodes);
    void promptForPersonDetails();
    void showSaveSuccess(String fileName);
    void showLoadSuccess(String fileName);
    void showError(String message);
    String getInput();
    String getName();
    String getGender();
    String getBirthDate();
    String getDeathDate();
    String getFileName();
}
