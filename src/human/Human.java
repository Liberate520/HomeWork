package human;

import familiTree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements TreeNode<Human> {

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

    public int getAge() {   // метод для вычисления возраста
        if (dateOfDeath == null) {
            return Period.between(dateOfBirth, LocalDate.now()).getYears();
        } else {
            return Period.between(dateOfBirth, dateOfDeath).getYears();
        }
    }


    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        if (mother != null) {
            if (Gender.Female == mother.getGender()) {
                mother.addChildren(this);
                this.mother = mother;
            } else {
                System.out.println("Ошибка ввода данных!");
            }
        }

    }


    public StringBuilder getMotherInfo() {
        // метод для отображения только выборочных сведений о матери
        StringBuilder sb = new StringBuilder();

        if (mother != null) {
            sb.append("id-").append(mother.getId());
            sb.append(". имя: ").append(mother.getName());
            sb.append("; дата рождения: ").append(mother.dateOfBirth);
            if (mother.dateOfDeath == null) {
                sb.append("; возраст: ").append(mother.getAge());
            } else {
                sb.append("; дата смерти: ").append(mother.dateOfDeath);
                sb.append("; возраст: ").append(mother.getAge());
            }
        }
        return sb;
    }


    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        if (father != null) {
            if (Gender.Male == father.getGender()) {
                father.addChildren(this);
                this.father = father;
            } else {
                System.out.println("Ошибка ввода данных!");
            }
        }
    }


    public StringBuilder getFatherInfo() {
        // метод для отображения только выборочных сведений об отце
        StringBuilder sb = new StringBuilder();

        if (father != null) {
            sb.append("id-").append(father.getId());
            sb.append(". имя: ").append(father.getName());
            sb.append("; дата рождения: ").append(father.dateOfBirth);
            if (father.dateOfDeath == null) {
                sb.append("; возраст: ").append(father.getAge());
            } else {
                sb.append("; дата смерти: ").append(father.dateOfDeath);
                sb.append("; возраст: ").append(father.getAge());
            }
        }
        return sb;
    }


    public boolean isParent(Human human) {
        return this.getMother().equals(human) || this.getFather().equals(human);
    }


    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouses) {
        this.spouse = spouses;
        if (spouses.getSpouse() == null) {
            spouses.setSpouse(this);
        }
    }

    public StringBuilder getSpouseInfo() {
        // метод для отображения только выборочных сведений о супругах
        StringBuilder sb = new StringBuilder();
        if (spouse != null) {
            sb.append(spouse.getName()).append(" (id: ");
            sb.append(spouse.getId()).append(")");
        }
        return sb;
    }


    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Human addChildren(Human child) {
        // добавление ребенка (с проверкой)
        if (!children.contains(child)) {
            children.add(child);
        } else {
            System.out.println("----------------------------------------");
            System.out.printf("ОШИБКА! Сведения о данном ребёнке уже внесены!!! Ребенок: %s (id: %s)\n",
                    child.name, child.id);
            System.out.println("-----------------------------------------");
        }
        return this;
    }


    public boolean isAddChildren(Human child) {
        int size = this.getChildren().size();
        addChildren(child);
        return this.getChildren().size() > size;
    }


    public String getChildrenInfo() { // метод для отображения сведений о детях
        StringBuilder result = new StringBuilder();
        result.append("дети: ");
        if (!getChildren().isEmpty()) {
            result.append(children.get(0).getName());
            result.append(" (id: ").append(children.get(0).getId());
            result.append(")");
            for (int i = 1; i < children.size(); i++) {
                result.append("; ");
                result.append(children.get(i).getName());
                result.append(children.get(i).getId());
            }
        } else {
            result.append("данные отсутствуют");
        }
        return result.toString();
    }


    @Override
    public boolean equals(Object obj) {
        // метод проверки человека (внесен или нет)
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Human)) return false;
        Human human = (Human) obj;
        return Objects.equals(id, id)
                && Objects.equals(name, name)
                && gender == human.gender
                && Objects.equals(dateOfBirth, human.dateOfBirth);

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nid-").append(getId());
        sb.append(". имя: ").append(getName());
        sb.append("; пол: ").append(getGender());
        sb.append("; дата рождения: ").append(dateOfBirth);
        if (dateOfDeath == null) {
            sb.append("; возраст: ").append(getAge());
        } else {
            sb.append("; дата смерти: ").append(dateOfDeath);
            sb.append("; возраст: ").append(getAge());
        }

        if (father == null) {
            sb.append("\n\tотец: данные отсутствуют");
        } else {
            sb.append("\n\tотец: ").append(getFatherInfo());
        }

        if (mother == null) {
            sb.append("\n\tмать: данные отсутствуют");
        } else {
            sb.append("\n\tмать: ").append(getMotherInfo());
        }

        if (spouse == null) {
            sb.append("\n\tсупруг(а): данные отсутствуют");
        } else {
            sb.append("\n\tсупруг(а): ").append(getSpouseInfo());
        }

        sb.append("\n\t").append(getChildrenInfo());

        return sb.toString();
    }

//    @Override
//    public int compareTo(Human anotherHuman) {
//        return this.name.compareTo(anotherHuman.name);
//    }
}
