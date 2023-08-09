package presenter;

import model.Service.FileHandler;
import model.Service.ServiceTree;
import model.human.Gender;
import model.human.Human;
import view.View;

import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private ServiceTree family;


    public Presenter(View view) {
        this.view = view;
        family = new ServiceTree();

    }

    public void addHuman(String name, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father, Human spouse, List<Human> children) {
   //TODO создание нового человека, как определять родственные связи (можно через id)
        try {
            family.addHuman(name, lastName, gender, birthDate, deathDate, mother, father, spouse, children);
            getInfo();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getInfo() {
        view.printAnswer(family.getHumanInfo());
    }

    public void sortByAge() {
        family.sortByAge();
    }

    public void sortByName() {
        family.sortByName();
    }

    public int getFamilySize() { return family.getFamilySize();}

    public void setSpouseTogether(int idSpouse1, int idSpouse2) {
        family.setSpouseTogether(idSpouse1, idSpouse2);
    }

    public void setChild(int idParent, int idChild) {
        family.setChild(idParent, idChild);
    }

    public ServiceTree getTree() {
        return family;
    }

    public void setServiceTree(){
        FileHandler fh = new FileHandler();
        Serializable object = fh.readFile("familytree.out");
        this.family = (ServiceTree) object;
    }

    public void saveTree(){
        FileHandler fh = new FileHandler();
        fh.saveFile(getTree());
    }
}
