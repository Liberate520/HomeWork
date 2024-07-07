
public class Human {

    String name;
    int birthYear;
    String gender;
    Human father, mother;
    String children;


/**Создание человека в семье */
public Human(String name, int birthYear, String gender, Human father, Human mother, String children) {
    this.name = name;
    this.birthYear = birthYear;
    this.gender = gender;
    this.father = father;
    this.mother = mother;
    this.children = children;
}


public Human(String Name, String gender, String i, int birthYear){
    this.name = Name;
    if(gender == "Male"){
        this.gender = "Male";
    }
    else { this.gender = "Female"; }
    this.children = i;
    this.birthYear = birthYear;
}


@Override
public String toString() {
    return String.format("\nName: %s \nBirth Year: %s \nGender: %s \n\nFather: %s \n\nMother: %s \nChildren: %s\n", name, birthYear, gender, father, mother, children);
}
}



