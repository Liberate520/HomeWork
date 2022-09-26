import java.util.ArrayList;
import java.util.List;

public class HumanInfo {
    private String name;
    private int age;
    private List<HumanInfo> children;

    public HumanInfo(String name, int age) {
        this.name = name;
        this.age = age;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addChild(HumanInfo child) {
        children.add(child);
    }

    public List<HumanInfo> getChildren() {
        return new ArrayList<>(children);
    }
}
