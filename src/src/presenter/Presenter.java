package src.presenter;

import java.time.LocalDate;


import src.model.Gender;
import src.model.Model;
import src.view.ConsoleUI;
import src.view.View;



public class Presenter {
    private View view;
    private Model model;
    private ConsoleUI consoleUI;

    public Presenter (View view){
        this.view=view;
        this.model= new Model();

    }

    

    



    public void addPerson(String name, Gender gender, LocalDate dateB){
        model.addPerson(name, gender,dateB);
        System.err.println("выполнено");
    }

    public void sortByName(){
        model.sortByName();
        System.err.println("выполнено");
    }

    public void sortByAge(){
        model.sortByAge();
        System.err.println("выполнено");
    }

    public void kinship(String txt){
        model.kinship(txt);
    }

    public void prinrtListInfo(){
        model.printList();
    }

    
}

    