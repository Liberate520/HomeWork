package oop_java.seminar1;

public class seminar1 {
    public static void main(String[] args) {
        Human ivan = new Human("Иван", 37, "male");
        Human olga = new Human("Ольга", 36, "female");

        olga.marriage(ivan); // свадьба

        Human petya = new Human("Петя", 14, "male", olga, ivan);

        olga.addChild(petya);

        Human Andrei = new Human("Андрей", 56, "male");
        Andrei.addChild(olga);
        olga.addParent(Andrei);

        System.out.println(olga);
        System.out.println(ivan);
        System.out.println(petya);
        System.out.println(Andrei);
    }
}