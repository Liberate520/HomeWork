package familytree.model;

import java.io.Serializable;

public class FullName implements Serializable {
    private static final long serialVersionUID = 1L;
    private String familyName;
    private String firstName;
    private String fatherName;

    public FullName(String familyName, String firstName, String fatherName) {
        this.familyName = familyName;
        this.firstName = firstName;
        this.fatherName = fatherName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    @Override
    public int hashCode() {
        return familyName.hashCode() + firstName.hashCode() + fatherName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FullName other = (FullName) obj;
        return familyName.equals(other.familyName) && firstName.equals(other.firstName) && fatherName.equals(other.fatherName);
    }

    @Override
    public String toString() {
        return familyName + " " + firstName + " " + fatherName;
    }
}