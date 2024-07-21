package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Human {
    private String name;
    private LocalDate dateofbirth;
    private LocalDate dateofdeath;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;

public Human (String name,LocalDate dateofbirth,LocalDate dateofdeath,Gender gender,Human mother,Human father,List<Human> children){
    this.name = name;
    this.dateofbirth = dateofbirth;
    this.dateofdeath = dateofdeath;
    this.gender = gender;
    this.mother = mother;
    this.father = father;
    this.children = new ArrayList<>();
}    

public String getName() {
    return name;
}
public LocalDate getBirthDate() {
    return dateofbirth;
}
public LocalDate getDeathDate() {
    return dateofdeath;
}
public Gender getGender() {
    return gender;
}
public Human getMother() {
    return mother;
}
public Human getFather() {
    return father;
}
public List<Human> getChildren() {
    return children;
}

public void setName(String name) {
    this.name = name;
}
public void setBirthDate(LocalDate dateofbirth) {
    this.dateofbirth = dateofbirth;
}
public void setDeathDate(LocalDate dateofdeath) {
    this.dateofdeath = dateofdeath;
}
public void setGender(Gender gender) {
    this.gender = gender;
}
public void setMother(Human mother) {
    this.mother = mother;
}
public void setFather(Human father) {
    this.father = father;
}
public void setChildren(Human child) {
    this.children.add(child);
}

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    String childrenCollected = children.stream().map(Human::getName).collect(Collectors.joining(", "));
    sb.append("Family member's info: \n");
    sb.append("Name: ").append(name).append("\n");
    sb.append("Date of birth: ").append(dateofbirth).append("\n");
    if (dateofdeath != null) {
        sb.append("Date of death: ").append(dateofdeath).append("\n");
    }        
    sb.append("Gender: ").append(gender).append("\n");
    if (mother != null) {
        sb.append("Mother: ").append(mother.getName()).append("\n");
    } 
    else{
        sb.append("Mother is unknown ").append("\n");
    }    
    if (father != null) {
        sb.append("Father: ").append(father.getName()).append("\n");
    } 
    else{
        sb.append("Father is unknown ").append("\n");
    }     
    if (!children.isEmpty()) {
        sb.append("Children: ").append(childrenCollected).append("\n");
    }     
    else{
        sb.append("There is no information about children").append("\n");
    } 
    return sb.toString();
}
}