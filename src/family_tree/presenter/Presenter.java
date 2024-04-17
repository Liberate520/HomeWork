package family_tree.presenter;


import family_tree.model.person.Gender;
import family_tree.model.person.TreeNode;
import family_tree.model.service.Service;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter<T extends TreeNode<T>> {
    private View view;
    private Service service; //boss of model

    public Presenter(View view) {
        this.view = view;
        service = new Service<>();
    }

    public void addSubjectToFamilyTree(String name, LocalDate dob, LocalDate dod, Gender gender, Class clazz) {
        service.addSubjectToFamilyTree(name, dob,dod, gender, clazz);
        ArrayList<String> res = service.getListOfNamesFromFamilyTree();
        for(String str: res){
            view.getAnswer(str);
        }
    }

    public void getFamilyTree() {
        System.out.println(service.getFamilyTree());
    }

    public void sortByName() {
        ArrayList<String> res = service.getListOfNamesFromInputLIstOfSubjects(service.sortByName());
        for (String str : res) {
            view.getAnswer(str);
        }
    }

    public void sortByAge() {
        ArrayList<String> res = service.getListOfNamesFromInputLIstOfSubjects(service.sortByAge());
        for (String str : res) {
            view.getAnswer(str);
        }
    }

    public void sortByDateOfBirth() {
        ArrayList<String> res = service.getListOfNamesFromInputLIstOfSubjects(service.sortByDateOfBirth());
        for (String str : res) {
            view.getAnswer(str);
        }
    }


}
