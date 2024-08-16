package model.human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import model.family_tree.FamilyTreeItem;
import model.places.Place;

// Применяем SRP: Класс Human отвечает только за хранение данных человека.
public class Human implements FamilyTreeItem<Human> {
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
    private Place birthPlace;

    public Human() {
        this.children = new ArrayList<>();
    }

    public Human(String firstName, String lastName, String patronymic, LocalDate birthDate, LocalDate deathDate,
            Gender gender, String nationality) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.nationality = nationality;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
    public int compareTo(Human o) {
        return Long.compare(this.id, o.getId());
    }

    @Override
    public int getAge() {
        if (birthDate == null) {
            throw new IllegalStateException("Дата рождения не установлена.");
        }
        LocalDate endDate = (deathDate != null) ? deathDate : LocalDate.now();
        return Period.between(birthDate, endDate).getYears();
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    @Override
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

    @Override
    public List<Human> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    @Override
    public boolean addParent(Human parent) {
        if (parent == null) {
            return false;
        }
        if (parent.getGender() == Gender.MALE) {
            this.father = parent;
        } else if (parent.getGender() == Gender.FEMALE) {
            this.mother = parent;
        } else {
            return false;
        }
        return true;
    }

    @Override
    public Human getSpouse() {
        return spouse;
    }

    @Override
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Place getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Place birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id)
                .append(", Имя: ").append(firstName)
                .append(", Фамилия: ").append(lastName)
                .append(", Отчество: ").append(patronymic)
                .append(", Дата рождения: ").append(birthDate);

        if (deathDate != null) {
            sb.append(", Дата смерти: ").append(deathDate);
        }
        sb.append(", Пол: ").append(gender)
                .append(", Национальность: ").append(nationality);

        if (birthPlace != null) {
            sb.append(", Место жительства: ")
                    .append("Дом: ").append(birthPlace.getHomeNumber())
                    .append(", Улица: ").append(birthPlace.getStreet())
                    .append(", Область: ").append(birthPlace.getRegion())
                    .append(", Страна: ").append(birthPlace.getCountry())
                    .append(", Индекс: ").append(birthPlace.getPostalCode())
                    .append(", Населенный пункт: ").append(birthPlace.getLocality());
        }

        if (father != null) {
            sb.append(", Отец: ").append(father.getFirstName()).append(" ").append(father.getLastName());
        }
        if (mother != null) {
            sb.append(", Мать: ").append(mother.getFirstName()).append(" ").append(mother.getLastName());
        }
        if (spouse != null) {
            sb.append(", Супруг(а): ").append(spouse.getFirstName()).append(" ").append(spouse.getLastName());
        }
        if (!children.isEmpty()) {
            sb.append(", Дети: ");
            for (Human child : children) {
                sb.append(child.getFirstName()).append(" ").append(child.getLastName()).append("; ");
            }
        }
        return sb.toString();
    }
}
