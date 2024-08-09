package presenter;

import model.family_tree.Service;
import model.human.Gender;
import view.View;

import java.time.LocalDate;
import java.util.Scanner;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        service.addHuman(name, gender, birthDate);
        //какой-то ответ
        getFamilyTreeInfo();
    }
    public boolean addChild(String choice){
        Scanner scanner = new Scanner(System.in);
        switch (choice){
            case "1":
                String sChild, sParent;
                System.out.println("Введите имя родителя");
                sParent = scanner.nextLine();
                System.out.println("Введите имя ребенка");
                sChild = scanner.nextLine();
                return service.addChild(sParent, sChild);
            case "2":
                int iChild, iParent;
                System.out.println("Введите id родителя");
                iParent = scanner.nextInt();
                System.out.println("Введите id ребенка");
                iChild = scanner.nextInt();
                return service.addChild(iParent,iChild);
            default:
                return false;
        }
    }

    public boolean addParent(String choice){
        Scanner scanner = new Scanner(System.in);
        switch (choice){
            case "1":
                String sChild, sParent;
                System.out.println("Введите имя ребенка");
                sChild = scanner.nextLine();
                System.out.println("Введите имя родителя");
                sParent = scanner.nextLine();
                return service.addParent(sChild,sParent);
            case "2":
                int iChild, iParent;
                System.out.println("Введите id ребенка");
                iChild = scanner.nextInt();
                System.out.println("Введите id родителя");
                iParent = scanner.nextInt();
                return service.addParent(iChild,iParent);
            default:
                return false;
        }
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        String info = service.getFamilyTree().toString();
        view.printAnswer(info);
    }
    public boolean setWedding(String name1, String name2){
        return service.setWedding(name1, name2);
    }
    public boolean setWedding(int id1, int id2){
        return service.setWedding(id1, id2);
    }
    public boolean setDivorce(String name1, String name2){
        return service.setDivorce(name1, name2);
    }
    public boolean setDivorce(int id1, int id2){
        return service.setDivorce(id1, id2);
    }

    public boolean saveToFile(String filename) {
        return service.saveToFile(filename);
    }
    public boolean loadFromFile(String filename){
        return service.loadFromFile(filename);
    }
}