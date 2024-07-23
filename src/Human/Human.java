package Human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {

    private long id;
    private String name;
    private Gender gender;  // мужчина, женщина
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    //    private FamilyTies familyTies; // родственные узы --> мать, отец, брат, сестра (продумать?)
    private Human father;
    private Human mother;
    private Human spouse; // супруги
    private Human human;
    private List<Human> children;


    // создать класс, который будет описывать родственную связь
    // будет два поля Человек_1 и Человек_2 --> enam --> тип связи ребенок, родитель, брат/сестра, и т.п.

    // бабушки/дедушки не нужны, через родителей --> родителей (через методы)

    // в классе все поля должны быть сверху, далее конструктор и потом методы


//    public Human() {
//
//    }

    public Human(String name, Gender gender, LocalDate dateOfBirth) {
        // метод для внесения сведений о человеке (с отсутствием некоторых параметров)
        this(name, gender, dateOfBirth, null, null);
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth, Human father, Human mother) {
        // метод для внесения сведений о человеке (с отсутствием некоторых параметров)
        this(name, gender, dateOfBirth, null, father, mother, new ArrayList<>());
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath,
                 Human father, Human mother) {
        this(name, gender, dateOfBirth, dateOfDeath, father, mother, new ArrayList<>());
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath,
                 Human father, Human mother, List<Human> children) {
        // метод для внесения сведений о человеке (с отсутствием некоторых параметров)
        this.id = -1;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();

        this.children = children;
    }


    public Human(Human human) {
        this.human = human;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
//        this.mother = mother;
        if (mother != null) {
            if (Gender.Female == mother.getGender()) {
                mother.addChildren(this);
                this.mother = mother;
            } else {
                System.out.println("Ошибка ввода данных!");
            }
        }

    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
//        this.father = father;
        if (father != null) {
            if (Gender.Male == father.getGender()) {
                father.addChildren(this);
                this.father = father;
            } else {
                System.out.println("Ошибка ввода данных!");
            }
        }
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human human) {
        this.spouse = human;
        if (human.getSpouse() == null) {
            human.setSpouse(this);
        }
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public int getAge() {   // метод для вычисления возраста
        if (dateOfDeath == null) {
            return Period.between(dateOfBirth, LocalDate.now()).getYears();
        } else {
            return Period.between(dateOfBirth, dateOfDeath).getYears();
        }
    }


    public Human addChildren(Human child) {
        // добавление ребенка (с проверкой)
        //TODO метод добавления ребенка с проверкой (перепроверить! ОШИБКА!)
//        if (!children.contains(child)) {
//            children.add(child);
//        } else {
//            System.out.printf("Ребенок уже добавлен! Ребенок: [ id: %s, имя: %s\n]",
//                    id, name);
//        }
        return this;
    }

    public boolean isAddChildren(Human child) {
        int size = this.getChildren().size();
        addChildren(child);
        return this.getChildren().size() > size;
    }

    public boolean isParent(Human human) {
        return this.getMother().equals(human) || this.getFather().equals(human);
    }


    public String getChildrenInfo() { // метод для отображения сведений о детях
        StringBuilder result = new StringBuilder();
        result.append("; дети: ");
        if (!getChildren().isEmpty()) {
            result.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                result.append("; ");
                result.append(children.get(i).getName());
            }
        } else {
            result.append("данные отсутствуют");
        }
        return result.toString();
    }




    public boolean addParent(Human parent) { // добавление родителя
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }
//
    public List<Human> getParent() {
        List<Human> list = new ArrayList<>(2);
        if (getFather() != null) {
            list.add(getFather());
        }
        if (getMother() != null) {
            list.add(getMother());
        }
        return list;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public String toString() {
        //TODO - попробовать упростить данный метод!
        StringBuilder sb = new StringBuilder();

        sb.append("id-").append(getId());
        sb.append(". имя: ").append(getName());
        sb.append("; пол: ").append(getGender());
        sb.append("; дата рождения: ").append(dateOfBirth);
        if (dateOfDeath == null) {
            sb.append("; возраст: ").append(getAge());
        } else {
            sb.append("; дата смерти: ").append(dateOfDeath);
            sb.append("; возраст: ").append(getAge());
        }
            // можно использовать данный метод для отображения родителей
        //TODO отредактировать вывод родителей (сделать вывод только некоторых значений...)
//        if (father == null) {
//            sb.append("; отец: данные отсутствуют");
//        } else {
//            sb.append("; отец: ").append(father).getClass();
//        }
//
//        if (mother == null) {
//            sb.append("; мать: данные отсутствуют");
//        } else {
//            sb.append("; мать: ").append(mother).getClass();
//        }

            // либо можно использовать данный метод для отображения родителей
        //TODO отредактировать вывод родителей (сделать вывод только некоторых значений...)
        if (getParent() == null) {
            sb.append("; родители: данные отсутствуют");
        } else {
            sb.append("; родители: ").append(getParent()).getClass();
        }

        if (spouse == null) {
            sb.append("; супруг(а): данные отсутствуют");
        } else {
            sb.append("; супруг(а): ").append(spouse);
        }

//        sb.append(getChildrenInfo()); //TODO Исправить ошибку!!!

        return sb.toString();
    }

}
