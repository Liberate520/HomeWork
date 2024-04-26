package Family_Tree;

import Family_Tree.model.FamilyTree.FamilyTree;
import Family_Tree.model.Human.Gender;
import Family_Tree.model.Human.Human;
import Family_Tree.view.ConsoleUI;
import Family_Tree.view.View;

import java.io.IOException;
import java.time.LocalDate;


public class Main {
    public Main() {
    }

    public void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = testFamilyTree();
        tree.sortByName();

        View view=new ConsoleUI();
        view.start();
//        System.out.println(tree.getInfo());
//        tree.sortByAge();
//        System.out.println(tree.getInfo());
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Введите имя человека");
//        String name=scanner.nextLine();
//        System.out.println("Введите возраст человека");
//        int age=scanner.nextInt();

//        System.out.println("name: "+name);
//        System.out.println("age: "+age);
    }

    public FamilyTree testFamilyTree() throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();
        Human Ivan = new Human("Иван", Gender.Male, LocalDate.of(1978, 9, 4));
        Human Oleg = new Human("Олег",Gender.Male,LocalDate.of(1971,7,5));
        Human Angelina = new Human("Ангелина",Gender.Female,LocalDate.of(1977,1,7));
        tree.add(Ivan);
        tree.add(Oleg);
        tree.add(Angelina);
//        Writer human = new Writer();
//        human.save(Ivan);Доработать
        return tree;
    }
}
