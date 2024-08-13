package family_tree.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate; // Дата смерти
    private List<Human> children;
    private Human mother;
    private Human father;
    private Human spouse;

    // Конструктор без родителей
    public Human(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    // Конструктор с родителями
    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(name, gender, birthDate);
        this.mother = mother;
        this.father = father;
        if (mother != null) mother.addChild(this); // Добавление ребенка к матери
        if (father != null) father.addChild(this); // Добавление ребенка к отцу
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    public void setSpouse(Human spouse){
        this.spouse = spouse;
    }
    public Human getSpouse(){
        return spouse;
    }
    public boolean hasChildren(){
        return !children.isEmpty();
    }


    @Override
    public String toString() {
        String spouseName = (spouse != null) ? spouse.getName() : "no";
        String childrenInfo = hasChildren() ? String.valueOf(children.size()) : "no";
        return String.format("%s (%s), born on %s, mother: %s, father: %s, spouse: %s, children: %s",
                name, gender, birthDate, mother != null ? mother.getName() : "no",
                father != null ? father.getName() : "no", spouseName, childrenInfo);
    }
}
























































































/*public class Human {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human spouse;

    public Human(String name, Gender gender, LocalDate birthDate,LocalDate deathDate, Human father, Human mother){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();

    }
    // конструктор вызов родительского класс
    public Human(String name, Gender gender,LocalDate birthDate){
        this(name,gender,birthDate,null, null, null);

    }

    public Human(String name, Gender gender,LocalDate birthdate, Human father, Human mother){
        this(name,gender, birthdate, null, father, mother);
    }

    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;

        }
        return false;

    }

    public boolean addParent(Human parent){
        if(parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        }
        else if (parent.getGender().equals(Gender.Female)){
            setMother(parent);
        }
        return true;
    }

    public void setGender(Gender gender){this.gender = gender;}

    public void setName(String name){this.name = name;}

    public void setMother(Human mother){this.mother = mother;}

    public void setFather(Human father){this.father = father;}

    public Human getMother() {return mother;}

    public Human getFather() {return father;}

    public List<Human> getParents(){// возвращает список родителей
        List<Human> list = new ArrayList<>(2);
        if (father != null){
            list.add(father);
        }

        if (mother != null){
            list.add(mother);
        }
        return list;
    }

    public int getAge(){
        if(deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        }else {
            return getPeriod(birthDate,deathDate);
        }


        private int getPeriod(LocalDate birthDate, LocalDate deathDate){
            Period diff = Period.between(birthDate,deathDate);
            return diff.getYears();
        }

        public void setSpouse(Human spouse) {this.spouse = spouse;}

        public Human getSpouse() {return spouse;}

        public String getName(){return name;}

        public long getId() {return id;}

        public LocalDate getBirthDate() {return birthDate;}

        public LocalDate getDeathDate() {return deathDate;}

        public List<Human> getChildren() {return children;}

        public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}

        public void setDeathDate(LocalDate deathDate) {this.deathDate = deathDate;}

        public Gender getGender() {
            return gender;
        }

        @Override
        public  String toString() {
            return getInfo();
        }

        public String getInfo() {
            StringBuilder sb = new StringBuilder();
            sb.append("id: ");
            sb.append(id);
            sb.append(", name: ");
            sb.append(name);
            sb.append(", gender: ");
            sb.append(getGender());
            sb.append(", age: ");
            sb.append(getAge());
            sb.append(", ");
            sb.append(getSpouseInfo());
            sb.append(", ");
            sb.append(getMotherInfo());
            sb.append(", ");
            sb.append(getFatherInfo());
            sb.append(", ");
            sb.append(getChildrenInfo());
            return sb.toString();
        }
        public String getSpouseInfo() {
            String res = "spouse: ";
            if(spouse == null) {
                res += "no";
            }else {
                res += spouse.getName();
            }
            return res;
        }

        public String getMotherInfo() {
            String res = "mother: ";
            Human mother = getMother();
            if(mother != null){
                res += mother.getName();
            }else{
                res += "unknown";
            }
            return res;
        }

        public String getFatherInfo(){
            String res = "father: ";
            Human mother = getFather();
            if(father != null){
                res += father.getName();
            }else{
                res += "unknown";
            }
            return res;

        }

        public String getChildrenInfo(){
            StringBuilder res = new StringBuilder();
            res.append("children: ");
            if(children.size() != 0){
                res.append(children.get(0).getName());
                for (int i = 1; i < children.size(); i++) {
                    res.append(", ");
                    res.append(children.get(i).getName());
                }
            }else{
                res.append(" there are no children");
            }
            return res.toString();
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


}
*/

