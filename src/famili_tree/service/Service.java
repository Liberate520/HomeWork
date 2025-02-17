package service;

import Filehendler.FileHandler;
import family_tree.FamilyTree;
import Human.Human;
import Pol.Pol;


public class Service {
    final  static String  filePath="Human/ttest.txt";
    private FamilyTree <Human> serviceTree;
    private HumanBuilder hB;
    private FileHandler serviceFilehendler;

    public Service(){
        serviceTree=new FamilyTree <Human>();
        hB=new HumanBuilder();
        serviceFilehendler= new FileHandler(filePath);
    }


    public String addHuman (String name, String familiya, String pol, String birthDate ){

        Human newHuman=hB.humanBuild(name, familiya, pol, birthDate);

        if (!(newHuman.getBirtdayDate()==null)){
            serviceTree.addHuman(newHuman);
            return "человек добавлен";
        }
        return "Такой человек уже добавлен";
    }

    public String getInfo(){
        StringBuilder strBuil= new StringBuilder();
        strBuil.append("Список родственников: "  +"\n");
        strBuil.append(serviceTree.getInfo());
        return strBuil.toString() + "konec dereva!"+ "\n";
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
            return ;
        }
    }

    public void addChild(Human h1, Human h2){
        if (serviceTree.contains(h1) && serviceTree.contains(h2)){
            h1.addChildren(h2);

        }else{
            return ;
        }
    }

    public String addSuprugById(int id1, int id2){
        Human h1=serviceTree.getHumanById(id1);
        Human h2=serviceTree.getHumanById(id2);
        this.addSuprug( h1, h2);
        return "Suprug dobavlen";
    }

    public String addSuprugByNum(int num1, int num2){
        Human h1=serviceTree.get(num1-1);
        Human h2=serviceTree.get(num2-1);
        this.addSuprug( h1, h2);
        return "Suprug dobavlen";
    }

    public String addChildByNum(int num1, int num2){
        Human h1=serviceTree.get(num1-1);
        Human h2=serviceTree.get(num2-1);
        this.addChild(h1,h2);
        return "Rebenok dobavlen";
    }

    public String addChildById(int id1, int id2){
        Human h1=serviceTree.getHumanById(id1);
        Human h2=serviceTree.getHumanById(id2);
        this.addChild(h1,h2);
        return "Rebenok dobavlen";
    }

    public String addParent(Human h1, Human h2){
        if (serviceTree.contains(h1) && serviceTree.contains(h2)){
            h1.addParents(h2);
            return "Roditel dobavlen";
        }else{
            return "Таких людей в списке нет";
        }
    }

    public String addParentByNum(int num1, int num2){
        Human h1=serviceTree.get(num1-1);
        Human h2=serviceTree.get(num2-1);
        String res=this.addParent(h1,h2);
        return res;
    }

    public String addParentById(int id1, int id2){
        Human h1=serviceTree.getHumanById(id1);
        Human h2=serviceTree.getHumanById(id2);
        String res=this.addParent(h1,h2);
        return res;
    }

    public String getParentByNum(int num1){
        Human human=serviceTree.get(num1-1);
        StringBuilder strBuil= new StringBuilder();
        strBuil.append("Родители: "  +"\n");
        if (human.getParents().size()<2){
            if (human.getParents().isEmpty()){
                strBuil.append("родители не установлены");
            }else{

                Human p1=human.getParents().getFirst();
                if(p1.getPol()==Pol.valueOf("MAN")){
                    strBuil.append("Мать не установлена");
                }else if(p1.getPol()==Pol.valueOf("WOMAN")){
                    strBuil.append("отец не установлен");
                }

            }

        }else{
            for (Human el:human.getParents()){
                strBuil.append(el +"\n");
            }

        }

        return strBuil.toString();
    }

    public void load (){

        this.serviceTree=(FamilyTree) serviceFilehendler.read();

    }

    public void save(){

        serviceFilehendler.save(this.serviceTree);
    }






}