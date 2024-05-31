package seminar2;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {

    /**
     * id            - идентификатор
     * name          - имя
     * surname       - фамилия
     * maidenName    - девичья фамилия
     * dateOfBirth   - дата рождения
     * dateOfDeath   - дата смерти
     * parents       - родители
     * children      - дети
     * spouse        - супруг(а)
     *
     * placeOfLiving - место проживания
     * placeOfBirth  - место рождения
     */

    private long id;
    private String name;
    private String surname;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;


    //private String placeOfLiving;
    //private String placeOfBirth;
    //private String maidenName;



    public Human(String name, String surname, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath,
                 Human father, Human mother){
        id = -1;  // -1 - родственник ещё не в дереве
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;

        parents = new ArrayList<>();
        children = new ArrayList<>();

        if(father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }


    }

    public Human(String name, String surname, Gender gender, LocalDate dateOfBirth){
        this(name, surname, gender, dateOfBirth, null, null, null);
    }

    public Human(String name, String surname, Gender gender, LocalDate dateOfBirth, Human father, Human mother){
        this(name, surname, gender, dateOfBirth, null, father, mother);
    }



    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if(!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather(){
        for(Human parent: parents){
            if(parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return  null;
    }

    public Human getMother(){
        for(Human parent: parents){
            if(parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    public int getAge(){
        if(dateOfDeath == null){
            return getPeriod(dateOfBirth, LocalDate.now());
        }else{
            return getPeriod(dateOfBirth, dateOfDeath);
        }
    }

    private int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath){
        Period difference = Period.between(dateOfBirth, dateOfDeath);
        return difference.getYears();
    }

    //-----------------------------------------------------------------------------------------------------------------


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Gender getGender() {
        return gender;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }
    //-----------------------------------------------------------------------------------------------------------------

    public String getMotherInfo(){
        String result = "мать: ";
        Human mother = getMother();
        if(mother != null){
            result += mother.getName();
            result += " ";
            result += mother.getSurname();
        }else{
            result += "нет данных";
        }

        return result;
    }

    public String getFatherInfo(){
        String result = "отец: ";
        Human father = getFather();
        if(father != null){
            result += father.getName();
            result += " ";
            result += father.getSurname();
        }else{
            result += "нет данных";
        }

        return result;
    }

    public String getChildrenInfo(){
        StringBuilder result = new StringBuilder();
        result.append("дети: ");
        if(children.size() != 0){
            result.append(children.get(0).getName());
            result.append(" " + children.get(0).getSurname());
            for(int i = 1; i < children.size(); i++){
                result.append(", ");
                result.append(children.get(i).getName());
                result.append(" " + children.get(i).getSurname());
            }
        }else{
            result.append("отсутствуют");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("id: ");
        info.append(id);
        info.append(", имя: ");
        info.append(name);
        info.append(", фамилия: ");
        info.append(surname);
        info.append(", пол: ");
        info.append(getGender());
        info.append(", дата рождения: ");
        info.append(dateOfBirth + "\n");
        info.append("возраст: ");
        info.append(getAge() + " года/лет");
        info.append(", ");
        info.append(getMotherInfo());
        info.append(", ");
        info.append(getFatherInfo() + "\n");
        info.append(getChildrenInfo() + "\n");
        return info.toString();

    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
