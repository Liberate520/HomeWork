package com.javacourse.view;

import java.io.IOException;
import java.util.*;

import com.javacourse.presenter.Presenter;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private Boolean work;

    public ConsoleUI() throws IOException{
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
    }

    @Override
    public void start() throws IOException{
        System.out.println("Hello, World!");
        while(work){
            System.out.println("1. Add a person");
            System.out.println("2. Show the List");
            System.out.println("3. Sort the List by names");
            System.out.println("4. Sort the List by ages");
            System.out.println("5. To complete the process");
            System.out.println("Choose an action (enter the number)");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    add();
                    break;
                case 2:
                    listInfo();
                    break;
                case 3:
                    sort_name();
                    break;
                case 4:
                    sort_age();
                    break;
                case 5:
                    end();
                    break;
                default:
                    error();
            }
        }
    }

    public void add() throws IOException{
        System.out.println("Enter the full name");
        String name = scanner.nextLine();
        System.out.println("Enter the age");
        Integer age = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter the mom's full name");
        String mom_name = scanner.nextLine();
        System.out.println("Enter the dad's full name");
        String dad_name = scanner.nextLine();
        //System.out.println(parent.getName().equals(mom_name));
        presenter.addhuman(name, age, mom_name, dad_name);;
    }
    public void listInfo() {
        presenter.getListInfo();
    }
    public void sort_name(){
        presenter.sort_name();
    }
    public void sort_age(){
        presenter.sort_age();
    }
    public void end(){
        scanner.close();
        work = false;
    }
    private void error(){
        System.out.println("Ooops! Please, repeat your request");
    }

    @Override
    public void printAnswer(String answer){
        System.out.println(answer);
    }
    
}
