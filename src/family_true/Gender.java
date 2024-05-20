/**
 * @author Ostrovskiy Dmitriy
 * @created 19.05.2024
 * enum Gender
 * @version v1.0
 */

package family_true;

public enum Gender {

    MALE("муж."), FEMALE("жен.");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGenderValue() {
        return gender;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "gender='" + gender + '\'' +
                '}';
    }
}
