import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;

    public Human (String name, Gender gender, LocalDate birthDate, 
                LocalDate deathDate, Human mother, Human father){
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
            if (father != null){
                parents.add(father);
            }
            if (mother != null){
                parents.add(mother);
            }
        children = new ArrayList<>();
    }

    public Human (String name, Gender gender, LocalDate birthDate){
        this(name, gender, birthDate, null, null, null);
    }

    public Human (String name, Gender gender, LocalDate birthDate, Human mother, Human father){
        this(name,  gender, birthDate,null, mother, father);
    }

    public boolean addChild (Human child){
        if(!children.contains(child)){
            this.children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent (Human parent){
        if(!parents.contains(parent)){
            if (this.parents.size() <= 2){
                parents.add(parent);
                return true;
            }
             return false;
        }
        return false;
    }

    public Gender getGender(){
        return gender;
    }

    public Human getFather(){
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }

    public Human getMother(){
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    public int getAge(){
        if (deathDate == null){
            return getLifetime(birthDate, LocalDate.now());
        }else{
            return getLifetime(birthDate, deathDate);
        }
    }

    public int getLifetime(LocalDate birthday, LocalDate deathDate){
        Period life = Period.between(deathDate, birthDate);
        return life.getYears();
    }
    public void sefBirthDate (LocalDate birthDate){ this.birthDate = birthDate; }

    public void setDethDate (LocalDate dethDate){ this. deathDate = dethDate; }

    public void setSpouse (Human spouse){ this.spouse = spouse; }

    public Human getSpouse(){
        return spouse;
    }

    public String getName(){ return name; }

    public LocalDate getBirthDate(){ return birthDate; }

    public LocalDate getDethDate(){ return deathDate; }

    public List<Human> getParents(){ return parents; }

    public List<Human> getChildren(){ return children; }

    @Override
    public String toString() {
        return getInfo();
    }
    
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя ");
        sb.append(name);
        sb.append("Пол ");
        sb.append(getGender());
        sb.append("Возраст ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChilfInfo());
        return sb.toString();
    }

    public String getSpouseInfo(){
        String res = "Супруг/супруга: ";
        if (spouse == null) {
             res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "Мать: ";
        Human mother = getMother();
        if (mother == null) {
             res += "нет информации";
        } else {
            res += mother.getName();
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "Отец: ";
        Human father = getFather();
        if (father == null) {
             res += "нет информации";
        } else {
            res += father.getName();
        }
        return res;
    }

    public String getChilfInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }else{
            res.append("нет");
        }
        return res.toString();
    }
}
