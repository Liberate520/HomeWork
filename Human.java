package oop_home.my_familyTree;

import java.util.ArrayList;
import java.util.List;

public class Human{
    //Поля экземляра класса
    private String surname;
    private String name;
    private String patronymic;
    private int age;
    private String gender;
    List<Parents> parent = new ArrayList<>();
    

    public Human(String surname, String name, String patronymic, int age, String gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Фамилия : ");
        sb.append(surname + "\n");
        sb.append("Имя : " );
        sb.append(name + "\n");
        sb.append("Отчество : " );
        sb.append(patronymic + "\n");
        sb.append("Возраст : " );
        sb.append(age + "\n");
        sb.append("Пол : " );
        sb.append(gender + "\n");
        

        return sb.toString();
    }
    
    // @Override
    // public String toString() {
    //     return "Human [name=" + surname + ", surname=" + name + ", patronymic=" + patronymic + ", age=" + age
    //             + ", gender=" + gender + "]";
    // }

    public static void main(String[] args) {
        Human human1 = new Human("Кокшаров","Сергей","Александрович",34,"Мужской");

        human1.getGender();
        // System.out.println(human1.getInfo());
        // System.out.println(human1.getGender());

    }

}
