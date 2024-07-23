import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
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

    public List<Human> getSiblings() {
        List<Human> siblings = new ArrayList<>();
        if (father != null) {
            siblings.addAll(father.getChildren());
        }
        if (mother != null) {
            siblings.addAll(mother.getChildren());
        }
        siblings.remove(this);
        return siblings;
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
        sb.append(", Имя: ");
        sb.append(firstName);
        sb.append(", Фамилия: ");
        sb.append(lastName);
        sb.append(", Отчество: ");
        sb.append(patronymic);
        sb.append(", Дата рождения: ");
        sb.append(birthDate);
        if (deathDate != null) {
            sb.append(", Дата смерти: ");
            sb.append(deathDate);
        }
        sb.append(", Пол: ");
        sb.append(gender);
        sb.append(", Национальность: ");
        sb.append(nationality);
        sb.append(", Отец: ");
        if (father != null) {
            sb.append(father.toString());
            sb.append(", ");
        }
        sb.append(", Мать: ");
        if (mother != null) {
            sb.append(mother.toString());
            sb.append(", ");
        }
        sb.append(", Супруг: ");
        if (spouse != null) {
            sb.append(spouse.toString());
            sb.append(", ");
        }
        sb.append(", Дети: ");
        for (Human child : children) {
            sb.append(child.toString());
            sb.append(", ");
        }
        sb.append(", Место жительства: ");
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

}
