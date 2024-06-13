package seminar2.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human extends TreeCreature<Human> implements Serializable, Comparable<Human>, Creature {

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

    public Human(String name, String surname, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath,
                 Human partner, Human father, Human mother){
        id = -1;  // -1 - родственник ещё не в дереве
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        super.partner = partner;
        parents = new ArrayList<>();
        children = new ArrayList<>();

        if(father != null){
            super.parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }


    }

    public Human(String name, String surname, Gender gender, LocalDate dateOfBirth){
        this(name, surname, gender, dateOfBirth, null, null, null, null);
    }


    public Human(String name, String surname, Gender gender, LocalDate dateOfBirth, Human father, Human mother){
        this(name, surname, gender, dateOfBirth, null, null, father, mother);
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

    public Human getPartner() {
        return partner;
    }

    public void setPartner(Human partner) {
        this.partner = partner;
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

    public String getSpouseInfo(){
        String result = "супруг(а): ";

        if(partner == null){
            result += "нет, ";
        }else{
            result += partner.getName();
            result += " ";
            result += partner.getSurname();
            result += ", ";
        }

        return result;
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
        info.append(getSpouseInfo());
        info.append(getChildrenInfo() + "\n");
        return info.toString();

    }
    public String getBriefInfo(){
        StringBuilder info = new StringBuilder();

        info.append(surname);
        info.append(", ");
        info.append(name);
        info.append("; \n");
        info.append(getSpouseInfo() + "\n");
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

    @Override
    public int compareTo(Human o) {
        return 0;
    }
    // Это переопределение же не имеет никакого смысла, так как мы не выводим сортировку по имени для разных Human?

//    @Override
//    public int compareTo(Human o) {
//        return this.name.compareTo(o.name);
//    }
}
