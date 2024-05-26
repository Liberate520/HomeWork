package homeWork;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Person {
    private static final AtomicLong idGenerator = new AtomicLong(0); // Автоматический генератор ID
    private final Long id; // primary key, автоматически присваивается и неизменяемый
    private String lastName;
    private String firstName;
    private String middleName;
    private Gender gender; // Ограничено значениями Male или Female
    private Date birthDate;
    private Date deathDate;
    private List<Long> parentIds; // Список идентификаторов родителей
    private List<Long> childIds; // Список идентификаторов детей
    private Person spouse; // Объект супруг(а)

    // Полный конструктор
    public Person(String lastName, String firstName, String middleName, Gender gender, 
                  Date birthDate, Date deathDate, List<Long> parentIds, List<Long> childIds, Person spouse) {
        this.id = idGenerator.incrementAndGet();
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parentIds = parentIds != null ? new ArrayList<>(parentIds) : new ArrayList<>();
        this.childIds = childIds != null ? new ArrayList<>(childIds) : new ArrayList<>();
        this.spouse = spouse;
    }

    // Конструктор для обязательных полей
    public Person(String lastName, String firstName, String middleName, Date birthDate) {
        this(lastName, firstName, middleName, null, birthDate, null, null, null, null);
    }

    // Геттер для идентификатора
    public Long getId() {
        return id;
    }

    // Остальные геттеры и сеттеры
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public List<Long> getParentIds() {
        return parentIds;
    }

    public void setParentIds(List<Long> parentIds) {
        this.parentIds = parentIds;
    }

    public List<Long> getChildIds() {
        return childIds;
    }

    public void setChildIds(List<Long> childIds) {
        this.childIds = childIds;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    // Метод для добавления ребенка
    public boolean addChildId(Long childId) {
        if (childIds.contains(childId)) {
            return false; // Идентификатор ребенка уже существует
        } else {
            childIds.add(childId);
            return true; // Идентификатор ребенка добавлен
        }
    }

    // Метод для добавления родителя
    public boolean addParentId(Long parentId) {
        if (parentIds.contains(parentId)) {
            return false; // Идентификатор родителя уже существует
        } else {
            parentIds.add(parentId);
            return true; // Идентификатор родителя добавлен
        }
    }

    // Метод для добавления супруга
    public boolean addSpouse(Person spouse) {
        if (this.spouse != null) {
            return false; // Супруг(а) уже существует
        } else {
            this.spouse = spouse;
            return true; // Супруг(а) добавлен(а)
        }
    }

    // Метод для получения информации о родителях
    public List<Person> findParentsInfo(List<Person> allPersons) {
        List<Person> parentsInfo = new ArrayList<>();
        if (parentIds == null) return parentsInfo;
        for (Long parentId : parentIds) {
            for (Person person : allPersons) {
                if (person.getId().equals(parentId)) {
                    parentsInfo.add(person);
                    break;
                }
            }
        }
        return parentsInfo;
    }

    // Метод для получения информации о детях
    public List<Person> findChildrenInfo(List<Person> allPersons) {
        List<Person> childrenInfo = new ArrayList<>();
        if (childIds == null) return childrenInfo;
        for (Long childId : childIds) {
            for (Person person : allPersons) {
                if (person.getId().equals(childId)) {
                    childrenInfo.add(person);
                    break;
                }
            }
        }
        return childrenInfo;
    }
}
