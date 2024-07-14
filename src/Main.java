import java.awt.*;
import java.text.Format;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree(0);

        Human hum1 = new Human();
        hum1.setName("Михaил Федopoвич Рoмaнoв");
        hum1.setDob(LocalDate.of(1596,7,12));
        hum1.setDod(LocalDate.of(1645,7,13));
        hum1.setGender(Gender.Male);



        Human hum2 = new Human();
        hum2.setName("Алекcей Михaйлoвич Рoмaнoв");
        hum2.setDob(LocalDate.of(1629,3,9));
        hum2.setDod(LocalDate.of(1676,1,29));
        hum2.setGender(Gender.Male);
        hum2.setFather(hum1);

        Human hum3 = new Human();
        hum3.setName("Федop III Алекcеевич Рoмaнoв");
        hum3.setDob(LocalDate.of(1661,5,30));
        hum3.setDod(LocalDate.of(1682,4,27));
        hum3.setGender(Gender.Male);
        hum3.setFather(hum2);

        Human hum4 = new Human();
        hum4.setName("Ивaн V Алекcеевич Рoмaнoв");
        hum4.setDob(LocalDate.of(1666,8,27));
        hum4.setDod(LocalDate.of(1696,1,29));
        hum4.setGender(Gender.Male);
        hum4.setFather(hum2);

        Human hum5 = new Human();
        hum5.setName("Петp I Алекcеевич Рoмaнoв");
        hum5.setDob(LocalDate.of(1672,5,30));
        hum5.setDod(LocalDate.of(1725,1,28));
        hum5.setGender(Gender.Male);
        hum5.setFather(hum2);

        Human hum6 = new Human();
        hum6.setName("Елизaветa Петpoвнa Рoмaнoвa");
        hum6.setDob(LocalDate.of(1709,12,18));
        hum6.setDod(LocalDate.of(1761,12,25));
        hum6.setGender(Gender.Female);
        hum6.setFather(hum5);

        ft.addHuman(hum1);
        ft.addHuman(hum2);
        ft.addHuman(hum3);
        ft.addHuman(hum4);
        ft.addHuman(hum5);
        ft.addHuman(hum6);

        System.out.println(ft.getHumansInfo());

        System.out.println("Выберите номер человека из древа  чтобы узнать его детей :");
        System.out.println(ft.getHumansChildrenInfo(Integer.parseInt(sc.next())));
    }


}
