package my_fam_tree.view;

import my_fam_tree.model.Human;
import java.util.List;

public interface FamTreeView {
    void menu();
    int menuChoice();
    String getInput(String prompt);
    void screenMess (String message);
    void screenHuman(Human human);
    void screenHumanList(List<Human> people);
}
