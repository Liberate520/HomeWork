import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private String nationality;
    private Human father;
    private Human mother;
    private Human spouse;
    private List<Human> children;
    private Village village;
    private Town town;
    private City city;

    public Human(String firstName, String lastName, String patronymic, LocalDate birthDate, LocalDate deathDate,
            Gender gender, String nationality, Human father, Human mother, Human spouse, Village village, Town town,
            City city) {
        id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.nationality = nationality;
        this.father = father;
        this.mother = mother;
        this.spouse = spouse;
        children = new ArrayList<>();
        this.village = village;
        this.town = town;
        this.city = city;
    }

    public Human(String firstName, String lastName, String patronymic, LocalDate birthDate, LocalDate deathDate,
            Gender gender, Village village, Town town, City city) {
        this(firstName, lastName, patronymic, birthDate, deathDate, gender, null, null, null, null, village,
                town, city);
    }

    public Human(String firstName, String lastName, String patronymic, LocalDate birthDate, Gender gender,
            String nationality) {
        this(firstName, lastName, patronymic, birthDate, null, gender, nationality, null, null, null, null, null,
                null);
    }

    public Human(String firstName, String lastName, LocalDate birthDate, Gender gender, String nationality) {
        this(firstName, lastName, null, birthDate, null, gender, nationality, null, null, null, null, null, null);
    }

    public boolean addChild(Human child) {
        if (children.contains(child)) {
            return false;
        } else {
            children.add(child);
            return true;
        }
    }

    public boolean removeChild(Human child) {
        if (children.contains(child)) {
            children.remove(child);
            return true;
        } else {
            return false;
        }
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.MALE)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.FEMALE)) {
            setMother(parent);
        }
        return true;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public List<Human> getParents() {
        List<Human> parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        return parents;
    }

    public int getAge() {
        if (deathDate != null) {
            return deathDate.minusYears(birthDate.getYear()).getYear();
        } else {
            return LocalDate.now().minusYears(birthDate.getYear()).getYear();
        }
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID");
        sb.append(id);
        sb.append(", \nИмя: ");
        sb.append(firstName);
        sb.append(", \nФамилия: ");
        sb.append(lastName);
        sb.append(", \nОтчество: ");
        sb.append(patronymic);
        sb.append(", \nДата рождения: ");
        sb.append(birthDate);
        if (deathDate != null) {
            sb.append(", \nДата смерти: ");
            sb.append(deathDate);
        }
        sb.append(", \nПол: ");
        sb.append(gender);
        sb.append(", \nНациональность: ");
        sb.append(nationality);
        sb.append(", \nОтец: ");
        if (father != null) {
            if (father.getClass() != this.getClass()) {
                sb.append(father.toString());
            } else {
                sb.append(father.getFirstName()).append(" ").append(father.getLastName());
            }
        }
        sb.append(", \nМать: ");
        if (mother != null) {
            if (mother.getClass() != this.getClass()) {
                sb.append(mother.toString());
            } else {
                sb.append(mother.getFirstName()).append(" ").append(mother.getLastName());
            }
        }
        sb.append(", \nСупруг: ");
        if (spouse != null) {
            if (spouse.getClass() != this.getClass()) {
                sb.append(spouse.toString());
            } else {
                sb.append(spouse.getFirstName()).append(" ").append(spouse.getLastName());
            }
        }
        sb.append(", \nДети: ");
        for (Human child : children) {
            if (child.getClass() != this.getClass()) {
                sb.append(child.toString());
            } else {
                sb.append(child.getFirstName()).append(" ").append(child.getLastName()).append(",");
            }
        }

        sb.append(", \nМесто жительства: ");
        if (village != null) {
            sb.append(village.toString());
            sb.append(", ");
        }
        if (town != null) {
            sb.append(town.getInfo());
            sb.append(", ");
        }
        if (city != null) {
            sb.append(city.toString());
        }
        return sb.toString();
    }

    public String getSpouseInfo() {
        String res = "Супруг(а): ";
        if (spouse != null) {
            res += spouse.getInfo();
        } else {
            res += "Супруг не найден";
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "Мать: ";
        if (mother != null) {
            res += mother.getInfo();
        } else {
            res += "Мать не найдена";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "Отец: ";
        if (father != null) {
            res += father.getInfo();
        } else {
            res += "Отец не найден";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder("Дети: ");
        if (children.size() > 0) {
            for (Human child : children) {
                res.append(child.getInfo());
                res.append(", ");
            }
        } else {
            res.append("Детей нет");
        }
        return res.toString();
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
}
