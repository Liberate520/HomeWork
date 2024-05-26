package homeWork;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private static AtomicLong idGenerator = new AtomicLong(1);
    private long id;

    private String lastName;
    private String firstName;
    private String middleName;

    private Gender gender;
    private Date birthDate;
    private Date deathDate;

    private List<Long> parentIds;
    private List<Long> childIds;
    private Long spouseId;

    public Person(String lastName, String firstName, String middleName, Gender gender,
                  Date birthDate, Date deathDate, List<Long> parentIds, List<Long> childIds, Long spouseId) {
        this.id = idGenerator.getAndIncrement();
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parentIds = parentIds != null ? new ArrayList<>(parentIds) : new ArrayList<>();
        this.childIds = childIds != null ? new ArrayList<>(childIds) : new ArrayList<>();
        this.spouseId = spouseId;
    }

    public Person(String lastName, String firstName, String middleName, Date birthDate) {
        this(lastName, firstName, middleName, null, birthDate, null, null, null, null);
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public List<Long> getParentIds() {
        return parentIds;
    }

    public List<Long> getChildIds() {
        return childIds;
    }

    public Long getSpouseId() {
        return spouseId;
    }

    public boolean addParentId(Long parentId) {
        if (parentIds.contains(parentId)) {
            return false;
        } else {
            parentIds.add(parentId);
            return true;
        }
    }

    public boolean addChildId(Long childId) {
        if (childIds.contains(childId)) {
            return false;
        } else {
            childIds.add(childId);
            return true;
        }
    }

    public boolean addSpouseId(Long spouseId) {
        if (this.spouseId != null && this.spouseId.equals(spouseId)) {
            return false;
        } else {
            this.spouseId = spouseId;
            return true;
        }
    }

    public boolean isAlive() {
        return deathDate == null || deathDate.after(new Date());
    }
}
