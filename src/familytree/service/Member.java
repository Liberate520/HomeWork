package familytree.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Member implements Serializable {
    private String name;
    private String gender;
    private List<Member> children = new ArrayList<>();

    public Member(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public void addChild(Member child) {
        children.add(child);
    }

    public List<Member> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}