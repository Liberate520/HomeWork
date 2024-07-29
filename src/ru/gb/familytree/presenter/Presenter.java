package ru.gb.familytree.presenter;


import ru.gb.familytree.model.human.Gender;
import ru.gb.familytree.model.service.Service;
import ru.gb.familytree.view.View;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addPerson(String name, int age, Gender gender){
        service.addPerson(name, age, gender);
        viewTree();
    }

    public void viewTree(){
        String answer = service.getListOfHuman();
        view.printAnswers(answer);
    }

    public void sortTreeByName(){
        service.sortByName();
        viewTree();
    }

    public void sortTreeByAge(){
        service.sortByAge();
        viewTree();
    }

    public void saveTree(){
        service.saveTree();
    }

    public void loadTree(){
        service.loadTree();
    }

}
