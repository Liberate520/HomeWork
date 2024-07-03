package vending_tree;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        human.setName();
        String name = human.getName();
        human.setGenderUserSelect(name);
        human.setDob();
        human.setDod();
        System.out.println(human);

        human.closeScanner();
    }
}