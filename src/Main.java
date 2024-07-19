public class Main {
    public static void main(String[] args) {
        Male father = new Male("Сергей", 53);
        Female mother = new Female("Ольга", 53);

        Male son = new Male("Стас", 31);
        Female daughter = new Female("Настя", 29);

        father.addChild(son);
        father.addChild(daughter);

        mother.addChild(son);
        mother.addChild(daughter);

        System.out.println("Father: " + father);
        System.out.println("Mother: " + mother);
        System.out.println("Son: " + son + ", Father: " + son.getFather() + ", Mother: " + son.getMother());
        System.out.println("Daughter: " + daughter + ", Father: " + daughter.getFather() + ", Mother: " + daughter.getMother());
    }
}