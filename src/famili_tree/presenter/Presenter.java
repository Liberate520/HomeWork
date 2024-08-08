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
        service.addHuman (name, familiya, pol,birthDate );
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
        service.sortByName();
        getTreeInfo();
    }

    public void addSuprugById(int id1, int id2){
        service.addSuprugById(id1, id2);
        getTreeInfo();
    }

    public void addSuprugByNum(int num1, int num2){
        service.addSuprugByNum(num1,  num2);
        getTreeInfo();
    }

    public void addChildByNum(int num1, int num2){
        service.addChildByNum(num1, num2);
        getTreeInfo();
    }

    public void addChildById(int id1, int id2){
        service.addChildById(id1,id2);
        getTreeInfo();
    }

    public void addParentByNum(int num1, int num2){
        service.addParentByNum(num1,num2);
        getTreeInfo();
    }

    public void addParentById(int id1, int id2){
        service.addParentById(id1, id2);
        getTreeInfo();
    }

    public void getParentByNum(int num1){
        service.getParentByNum(num1);
    }

}