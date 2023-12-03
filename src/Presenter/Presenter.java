package Presenter;

import Model.home_work_class.Human.Gender;
import Model.Model;
import Model.home_work_class.Human.Human;
import view.View;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model){
        this.view = view;
        this.model = model;
    }

    public void addHuman(String name, Gender gender, LocalDate bornDate, LocalDate diedDate){
        this.model.addHuman(name, gender, bornDate, diedDate);
        getHumansListInfo();
        view.printAnswer("Человек добавлен\n");
    }

    public void addChildrenToParent(String parent, List<String> names){
        List<Human> childrenList = model.getListChildren(names);
        for (String children: names) {
            view.printAnswer("Ребёнок " + children + " найден");
        }

        if (model.addChildrenToParent(parent, childrenList)){
            view.printAnswer("Для родителя " + parent + " дети добавлены\n");
        }
        else {view.printAnswer("Для родителя " + parent + " дети не добавлены\n");}
    }

    public void getHumansListInfo() {
        String info = model.getHumansListInfo();
        view.printAnswer(info);
    }

    public void fileWriter(String path){
        boolean res = this.model.fileWriter(path);
        if (res){
        this.view.printAnswer("Семейное дерево записано\n");}
        else {this.view.printAnswer("Семейное дерево не записано\n");}
    }

    public void fileReader(String path){
        boolean res = this.model.fileReader(path);
        if (res){
            getHumansListInfo();
            this.view.printAnswer("Семейное древо прочитано\n");
        }
        else {this.view.printAnswer("Семейное древо не прочитано\n");}
    }

    public void sortByName() {
        this.model.sortByName();
        getHumansListInfo();
        view.printAnswer("Дерево отсортировано по имени\n");
    }

    public void sortByAge() {
        this.model.sortByAge();
        getHumansListInfo();
        view.printAnswer("Дерево отсортировано по возрасту\n");
    }

    public void sortById() {
        this.model.sortById();
        getHumansListInfo();
        view.printAnswer("Дерево отсортировано по id\n");
    }
}
