package FamilyTree.view;

import FamilyTree.presenter.Presenter;

import java.io.IOException;

public interface View {
    void start() throws IOException, ClassNotFoundException;
    void printAnswer(String text);
    void createFamilyTree();
    void addElement();
}
