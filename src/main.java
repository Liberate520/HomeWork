

public class main {


    public static void main(String[] args) {
        Human Oleg = new Human("Oleg", 24, gender.valueOf("male"));
        Human Ivan = new Human("Ivan", 10, gender.valueOf("male"));
        Human Olga = new Human("Olga", 20, gender.valueOf("female"));
        Family Ivanovs = new Family("Ivanov");
        System.out.println(Olga);
        Ivanovs.setHusband(Oleg);
        Ivanovs.setWife(Olga);
        System.out.println(Olga);
        System.out.println(Ivanovs.husband);
        Ivanovs.newChild(Oleg, Olga, Ivan);
        Ivanovs.showFamily();
    }
}
