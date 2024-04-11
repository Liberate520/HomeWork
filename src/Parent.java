import java.util.ArrayList;
import java.util.List;

public class Parent extends Children {
    private String gender;

    public Parent(String name, String gender) {
        super(name);
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}