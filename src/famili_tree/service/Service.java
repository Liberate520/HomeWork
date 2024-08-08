package service;

import Filehendler.FileHandler;
import family_tree.FamilyTree;
import Human.Human;



public class Service {
    final  static String  filePath="Human/ttest.txt";
    private FamilyTree <Human> serviceTree;
    private HumanBuilder hB;

    public Service(){
        serviceTree=new FamilyTree();
        hB=new HumanBuilder();
    }


    public void addHuman (String name, String familiya, String pol, String birthDate ){
        Human newHuman=hB.humanBuild(name, familiya, pol, birthDate);
        serviceTree.addHuman(newHuman);
        System.out.println("человек добавлен");
    }

    public String getInfo(){
        StringBuilder strBuil= new StringBuilder();
        strBuil.append("Список родственников: "  +"\n");
        strBuil.append(serviceTree.getInfo());
        return strBuil.toString();
    }

    public void sortByName(){
        serviceTree.sortByName();
    }

    public void sortByAge(){
        serviceTree.sortByAge();
    }

    public Human getHuman(String name, String familiya, String pol, String birthDate){
        return serviceTree.getHuman(name, familiya, pol, birthDate);
    }

    public void addSuprug(Human h1, Human h2){
        if (serviceTree.contains(h1) && serviceTree.contains(h2)){
            h1.addSuprug(h2);
        }else{
            System.out.println("Таких людей в списке нет");
        }
    }

    public void addChild(Human h1, Human h2){
        if (serviceTree.contains(h1) && serviceTree.contains(h2)){
            h1.addChildren(h2);
            System.out.println("Rebenok dobavlen");
        }else{
            System.out.println("Таких людей в списке нет");
        }
    }

    public void addSuprugById(int id1, int id2){
        Human h1=serviceTree.getHumanById(id1);
        Human h2=serviceTree.getHumanById(id2);
        this.addSuprug( h1, h2);
    }

    public void addSuprugByNum(int num1, int num2){
        Human h1=serviceTree.get(num1-1);
        Human h2=serviceTree.get(num2-1);
        this.addSuprug( h1, h2);
        System.out.println("Suprug dobavlen");
    }

    public void addChildByNum(int num1, int num2){
        Human h1=serviceTree.get(num1-1);
        Human h2=serviceTree.get(num2-1);
        this.addChild(h1,h2);
    }

    public void addChildById(int id1, int id2){
        Human h1=serviceTree.getHumanById(id1);
        Human h2=serviceTree.getHumanById(id2);
        this.addChild(h1,h2);
    }

    public void addParent(Human h1, Human h2){
        if (serviceTree.contains(h1) && serviceTree.contains(h2)){
            h1.addParents(h2);
            System.out.println("Roditel dobavlen");
        }else{
            System.out.println("Таких людей в списке нет");
        }
    }

    public void addParentByNum(int num1, int num2){
        Human h1=serviceTree.get(num1-1);
        Human h2=serviceTree.get(num2-1);
        this.addParent(h1,h2);
    }

    public void addParentById(int id1, int id2){
        Human h1=serviceTree.getHumanById(id1);
        Human h2=serviceTree.getHumanById(id2);
        this.addParent(h1,h2);
    }

    public void getParentByNum(int num1){
        Human human=serviceTree.get(num1-1);
        System.out.print("Родители: ");
        System.out.println(human.getParents());
    }

     public static FamilyTree load (){
         FileHandler filehendler= new FileHandler(filePath);

         return (FamilyTree) filehendler.read();
     }

    public static void save (FamilyTree familyTree){
         FileHandler filehendler= new FileHandler(filePath);

         filehendler.save(familyTree);
    }






}
