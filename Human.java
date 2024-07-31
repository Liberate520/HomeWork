package Seminars.Seminars_1.HomeWork.homeWork;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private int age;
    private String gender;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, String gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getHuman(){return name;}
    public String getGender(){return gender;}
    public int getAge(){return age;}

    public void addChild(Human child) {this.children.add(child);}
    public void addParent(Human parent) {this.parents.add(parent);}

    public List<Human> getParents() {return parents;}
    public List<Human> getChildren() {return children;}
    @Override
    public String toString() {return "Имя: " + name + "\n" + "Пол: " + gender + "\n" + "Возраст: " + age;}

    public String getFamilyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this).append("\n");
        if (!parents.isEmpty()) {
            stringBuilder.append("Родители: ");
            for (Human parent : parents) {
                stringBuilder.append(parent.getHuman()).append(" ");
            }
            stringBuilder.append("\n");
        }
        if (!children.isEmpty()) {
            stringBuilder.append("Дети: ");
            for (Human child : children) {
                stringBuilder.append(child.getHuman()).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
