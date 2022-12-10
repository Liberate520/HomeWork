package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person {
    
    private int id;
    private String name;
    private int age;
    private List<Relation> relationships;

    public Person(List<Person> list, String name, int age) {
        this.id = setId(list);
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    protected int getId() {
        return id;
    }

    private int setId(List<Person> list) {
        int upperRange = 1000;
        Random random = new Random();
        int tempId = random.nextInt(upperRange);
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).id == tempId){
                tempId++;
                i = 0;
            }
        }
        return this.id = tempId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getAge() {
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public List<Relation> getRelationships() {
        return relationships;
    }

    public String personToString(Person human){
        StringBuilder res = new StringBuilder();
        res = new StringBuilder("id человека: " + human.id + "\n" + "имя человека: " + human.name + "\n" +
                "Возраст человека: " + human.age + "\n" + "Связи человека: " + "\n");
        if (human.relationships != null){
            for (Relation r : human.relationships){
                    res.append("с человеком ").append(r.getRelationPerson()).append(" существует связь - ")
                            .append(r.getRelation()).append("\n");
                }
        }            
        return res.toString();
    }

    public String childrensToString(Person human){
        StringBuilder res = new StringBuilder();
        if (human.relationships != null){
            for (Relation r : human.relationships){
                if (r.getRelationId() == 2){ //2 - 'это связь дети в Relationships'
                    res.append("Id ребенка ").append(r.getRelationPerson());
                }    
            }
        }
        return res.toString();
    }

    public void setRelationship(Person human, Relation relationship) {
        if (human.relationships == null){
            ArrayList<Relation> temp = new ArrayList<>();
            temp.add(relationship);
            human.relationships = temp;
        }
        else{
            human.relationships.add(relationship);
        }
    }
}

