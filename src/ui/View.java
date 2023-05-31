package java_oop_homeWork.src.ui;

import java_oop_homeWork.src.presenter.Presenter;
import java_oop_homeWork.src.ui.menues.Menu;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
    void startTreeMenu();
    void startAddMenu();
    FullName inputKinsman();
    void addParent(int idperson);
    void addChild(int idperson);
    void getFamilyName();
    void getFamily();
    int getIdPerson();
    int getCommand();
    void finishMainMenu();
    void finishAddMenu();
    void createFamilyTree();
    void getAllTrees();
    void selectFamilyTree();
    void setSex(int sex);
    void finishTreeMenu();
    void implementationMenu(Menu menu);
    void errorSelectMenu(String error);
}
