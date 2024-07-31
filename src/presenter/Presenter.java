package presenter;

import model.human.Gender;
import model.service.Service;
import view.View;

import java.time.LocalDate;
import java.util.Scanner;

public class Presenter {
    private Scanner scanner;
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
        scanner = new Scanner(System.in);
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate){
        service.addHuman(name, gender, birthDate);
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate, String motherName, String fatherName){
        service.addHuman(name, gender, birthDate, motherName, fatherName);
    }

    public void getPeopleInfo(){
        String info = service.getPeopleInfo();
        view.printAnswer(info);
    }

    public void sortByName(){
        service.sortByName();
    }

    public void sortByAge(){
        service.sortByAge();
    }

    public void setWedding(){
        System.out.println("Введите имя первого человека");
        String human1 = scanner.nextLine();
        System.out.println("Введите имя второго человека");
        String human2 = scanner.nextLine();
        service.setWedding(human1, human2);
    }
}
