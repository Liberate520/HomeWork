import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human yulia = new Human("Юлия",Gender.Female,LocalDate.of(1981,4,12));
        Human kostya = new Human("Костя",Gender.Mail,LocalDate.of(1982,2,2));
        Human nikita = new Human("Никита",Gender.Female,yulia,kostya,LocalDate.of(1991,7,3));
        Human gosha = new Human("Георгий",Gender.Mail,yulia,kostya,LocalDate.of(1992,12,4));
        yulia.addChildren(nikita);
        yulia.addChildren(gosha);
        yulia.addChildren(nikita);
        yulia.addChildren(gosha);
        kostya.addChildren(nikita);
        kostya.addChildren(gosha);




        System.out.println(yulia.toString());

    }
}
