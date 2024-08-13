package family_tree.presentor;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.service.Service;
import family_tree.model.writer.FileHandier;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presentor {

    private View view;
    private FamilyTree<Human> familyTree;
    private Service model;

    public Presentor(View view){
        this.view = view;
        familyTree = new FamilyTree<Human>();
        model = new Service();
    }

    public void getFamily(){
        view.printAnswer(model.getFamily().toString());
    }

    public void addHuman(String first_name, String last_name, String patronymic, LocalDate dayofdeath, LocalDate birthday, int father, int mother, List<Integer> childrensId, String genderstr){
        model.addHuman(first_name, last_name, patronymic, dayofdeath, birthday, father, mother, childrensId, genderstr);
        view.printAnswer("Человек добавлен успешно!");
    }

    public void removeHuman(int id){
        model.removeHuman(id);
        view.printAnswer("Человек удален успешно!");
    }

    public void idFindHuman(int id){
        view.printAnswer(model.idFindHuman(id));
    }

    public void nameFindHuman(String first_name, String last_name, String patronymic){
        view.printAnswer(model.nameFindHuman(first_name, last_name, patronymic));
    }

    public void getAncestors(int id){
        ArrayList<String> arr = model.getAncestors(id);
        for (String human : arr) view.printAnswer(human);
    }

    public void getDescendants(int id){
        ArrayList<String> arr = model.getDescendants(id);
        for (String human : arr) view.printAnswer(human);
    }

    public void sortByname(){
        model.sortByname();
        view.printAnswer("Семейное дерево сортированно успешно!");
    }

    public void sortByDateOfBirthday(){
        model.sortByDateOfBirthday();
        view.printAnswer("Семейное дерево сортированно успешно!");
    }

    public void save(String way){
        model.save(way);
        view.printAnswer("Семейное дерево сохранено!");
    }

    public void load(String way){
        model.load(way);
        view.printAnswer("Семейное дерево загружено!");
    }
}
