import java.util.ArrayList;
import java.util.List;

public class Human {

    int ID;
    String name;
    int yearBirth;
    int yearDeath;
    String gender;
    Human father, mother = null;
    ArrayList<Human> children = new ArrayList<>();


    public Human(int ID, String name, int yearBirth, String gender){
        this.ID = ID;
        this.name = name;
        this.yearBirth = yearBirth;
        this.gender = gender;
        
    }
    

    public Human(int ID, String name, int yearBirth, int yearDeath, String gender){
        this.ID = ID;
        this.name = name;
        this.yearBirth = yearBirth;
        this.yearDeath = yearDeath;
        this.gender = gender;
        
    }

    public int getID() {
        return ID;
    }
    
    public String setFather(Human father) {
        if (this.father == null) { 
            this.father = father; 
            return setChildren(father); }

        else { return "Отец уже есть\n";}
    }

    public String setMother(Human mother) {
        if (this.mother == null) { this.mother = mother; return setChildren(mother); }
        else { return "Мама уже есть\n";}
    }

    public String setChildren(Human parent){
        parent.children.add(this);
        return "Ребенок добавлен";
    }


    public ArrayList<Human> getParents(){
        ArrayList parents = new ArrayList<Human>();
        parents.add(this.father);
        parents.add(this.mother);
        return parents;
    }
        
    public ArrayList getChildren(Human human){
        ArrayList Child = new ArrayList<>();
        for(Human child: children){
            Child.add(child.name);
        }
        return Child;
    }

    @Override
    public String toString() {
        StringBuilder SB = new StringBuilder();
        SB.append("\n\nID: ");
        SB.append(ID);
        SB.append("\nИмя: ");
        SB.append(name);
        SB.append("\nГод рождения: ");
        SB.append(yearBirth);
        SB.append("\nГод смерти: ");
        SB.append(yearDeath);
        SB.append("\nПол: ");
        SB.append(gender);
        SB.append("\nПапа: ");
        if (father != null) {SB.append(father.name);}
        SB.append("\nМама: ");
        if (mother != null) {SB.append(mother.name);}
        SB.append("\nДети: ");
        SB.append(getChildren(this));
        
        return SB.toString();
    }
    }
    




    

