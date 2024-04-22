package family_tree.presenter;


import family_tree.model.person.BasicUnit;
import family_tree.model.person.Gender;
import family_tree.model.person.Human;
import family_tree.model.person.TreeNode;
import family_tree.model.service.Service;
import family_tree.model.tree.FamilyTree;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter {
    private View view;
    private Service service; //boss of model

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addSubjectToFamilyTree(String name, LocalDate dob, LocalDate dod, Gender gender) {
        service.addSubjectToFamilyTree(name, dob, dod, gender);
        ArrayList<String> res = service.getListOfNamesFromFamilyTree();
        for (String str : res) {
            view.getAnswer(str);
        }
    }

    public void getFamilyTree() {
        view.getAnswer(service.getFamilyTree().toString());
    }

    public void sortByName() {
        ArrayList<String> res = service.getListOfNamesFromInputListOfSubjects(service.sortByName());
        for (String str : res) {
            view.getAnswer(str);
        }
    }

    public void sortByAge() {
        ArrayList<String> res = service.getListOfNamesFromInputListOfSubjects(service.sortByAge());
        for (String str : res) {
            view.getAnswer(str);
        }
    }

    public void sortByDateOfBirth() {
        ArrayList<String> res = service.getListOfNamesFromInputListOfSubjects(service.sortByDateOfBirth());
        for (String str : res) {
            view.getAnswer(str);
        }
    }

    public void writeTreeAsByteCode() {
        if (service.writeTreeAsByteCode()) {
            view.getAnswer("The family successfully registered\n");
        } else {
            view.getAnswer("The family not registered\n");
        }
    }

    public void readTreeFromByteCodeFile() {
        FamilyTree tree = service.readTreeFromByteCodeFile(); // возможно расширение функционала до запррса файла от пользователя.
        if (tree != null) {
            service.setFamilyTree(tree);
            for (Object name : service.getListOfNamesFromFamilyTree()) {
                view.getAnswer((String) name); // можно лучше, но как?
            }
        } else {
            view.getAnswer("The file with a data about family tree is still empty");
        }
    }
}
