import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.service.Service;
import family_tree.writer.FileHendler;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Service service = new Service();
    public static void main(String[] args) {

        createTree();



        System.out.println(service.getHumansInfo(1));
        service.sortByName();
        System.out.println(service.getHumansInfo(2));
        service.sortByDOB();
        System.out.println(service.getHumansInfo(3));

        //System.out.println("Выберите номер человека из древа  чтобы узнать его детей :");
        //System.out.println(ft.getHumansChildrenInfo(Integer.parseInt(sc.next())));

    }
    private static FamilyTree readTree(){
        FileHendler fh = new FileHendler();
        return (FamilyTree) fh.read();
    }
    private static void saveTree(FamilyTree ft){
        FileHendler fh = new FileHendler();
        fh.save(ft);
    }
    private static void createTree(){

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

        service.addHuman(hum1);
        service.addHuman(hum2);
        service.addHuman(hum3);
        service.addHuman(hum4);
        service.addHuman(hum5);
        service.addHuman(hum6);

    }

}
