import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human Ded = new Human();
        Ded.id = 1;
        Ded.name = "Борис Плотников";
        Ded.gender = Gender.Man;
        Ded.birthDate = "7.10.1953";


        Human Babushka = new Human();
        Babushka.id = 2;
        Babushka.name = "Надежда Плотникова";
        Babushka.gender = Gender.Woman;
        Babushka.birthDate = "17.04.57";
        Babushka.deathDate = "25.06.2015";


        Human Otec = new Human();
        Otec.id = 3;
        Otec.name = "Владимир Плотников";
        Otec.gender = Gender.Man;
        Otec.birthDate = "23.12.1977";
        Otec.deathDate = "17.08.2022";


        Human Matb = new Human();
        Matb.id = 4;
        Matb.name = "Татьяна Краснова";
        Matb.gender = Gender.Woman;
        Matb.birthDate = "7.07.1982";


        Human Son = new Human();
        Son.id = 5;
        Son.name = "Игорь Плотников";
        Son.gender = Gender.Man;
        Son.birthDate = "1.05.1999";


        Human Doch = new Human();
        Doch.id = 6;
        Doch.name = "Ксения Плотникова";
        Doch.gender = Gender.Woman;
        Doch.birthDate = "15.06.2001";
        Ded.children = new ArrayList<>();
        Babushka.children = new ArrayList<>();
        Otec.children = new ArrayList<>();
        Matb.children = new ArrayList<>();
        Otec.parents = new ArrayList<>();
        Matb.parents = new ArrayList<>();
        Son.parents = new ArrayList<>();
        Doch.parents = new ArrayList<>();
        Ded.children.add(Matb);
        Babushka.children.add(Matb);
        Otec.children.add(Son);
        Otec.children.add(Doch);
        Matb.parents.add(Ded);
        Matb.parents.add(Babushka);
        Matb.children.add(Son);
        Matb.children.add(Doch);
        Son.parents.add(Otec);
        Son.parents.add(Matb);
        Doch.parents.add(Otec);
        Doch.parents.add(Matb);
        List<Human> allFamily = new ArrayList<>();
        addFamily(allFamily, Ded, Babushka, Otec, Matb, Son, Doch);
        System.out.println(allFamily);
        System.out.println(Ded.getChildren());
        System.out.println(Otec.getChildren());
        System.out.println(Matb.getParents());
        System.out.println(Son.getParents());




    }

    private static void addFamily(List<Human> allFamily, Human Ded, Human Babushka, Human Otec, Human Matb, Human Son, Human Doch) {
        allFamily.add(Ded);
        allFamily.add(Babushka);
        allFamily.add(Otec);
        allFamily.add(Matb);
        allFamily.add(Son);
        allFamily.add(Doch);
    }
    }

