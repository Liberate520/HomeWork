
import java.io.IOException;



public class main {


    public static void main(String[] args) throws IOException {
        Human Oleg = new Human("Oleg", 24, gender.valueOf("male"));
        Human Ivan = new Human("Ivan", 10, gender.valueOf("male"));
        Human Olga = new Human("Olga", 20, gender.valueOf("female"));
        Human Andrey = new Human("Андрей", 26, gender.valueOf("male"));
        Family Ivanovs = new Family("Ivanov");
        System.out.println(Olga);
        Ivanovs.setHusband(Oleg);
        Ivanovs.setWife(Olga);
        System.out.println(Olga);
        System.out.println(Ivanovs.husband);
        Ivanovs.newChild(Oleg, Olga, Ivan);
        Ivanovs.newChild(Oleg, Olga, Andrey);
        Ivanovs.showFamily();
        System.out.println(Ivanovs);
        FamilyTree TreeOfIvanovs = new FamilyTree();
        TreeOfIvanovs.addNewFamily(Ivanovs);
        System.out.println(TreeOfIvanovs);
        TreeOfIvanovs.showTree();
        filehand fh = new filehand();
        try {
            Ivanovs.write(Ivanovs, "Text.txt");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {   
        System.out.println(Ivanovs.read("Text.txt"));
        } catch (ClassNotFoundException ex) {
        }
    }
}
