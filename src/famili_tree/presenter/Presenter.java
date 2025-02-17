package presenter;

import service.Service;
import view.View;

public class Presenter{

    private View view;
    private Service service;

    public Presenter (View view){
        this.view=view;
        service=new Service();
    }

    public void addHuman (String name, String familiya, String pol, String birthDate ){
        view.printRes(service.addHuman (name, familiya, pol,birthDate ));
        getTreeInfo();
    }

    public void getTreeInfo(){
        String info=service.getInfo();
        view.printRes(info);
    }

    public void sortByName(){
        service.sortByName();
        getTreeInfo();
    }

    public void sortByAge(){
        service.sortByAge();
        getTreeInfo();
    }

    public void addSuprugById(int id1, int id2){
        view.printRes(service.addSuprugById(id1, id2));
        getTreeInfo();
    }

    public void addSuprugByNum(int num1, int num2){
        view.printRes(service.addSuprugByNum(num1,  num2));
        getTreeInfo();
    }

    public void addChildByNum(int num1, int num2){
        view.printRes(service.addChildByNum(num1, num2));
        getTreeInfo();
    }

    public void addChildById(int id1, int id2){
        view.printRes(service.addChildById(id1,id2));
        getTreeInfo();
    }

    public void addParentByNum(int num1, int num2){
        view.printRes(service.addParentByNum(num1,num2));
        getTreeInfo();
    }

    public void addParentById(int id1, int id2){
        view.printRes(service.addParentById(id1, id2));
        getTreeInfo();
    }

    public void getParentByNum(int num1){
        service.getParentByNum(num1);
        String info=service.getParentByNum(num1);
        view.printRes(info);
    }

    public void save(){
        service.save();
        view.printRes("Дерево сохранено");
    }

    public void load(){
        service.load();
        view.printRes("Дерево зугружено");
    }

}