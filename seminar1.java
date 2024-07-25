public class seminar1 {
    public static void main(String[] args) {
        Human ivan = new Human("Иван", 37, "male");
        Human olga = new Human("Ольга", 36, "female");

        olga.marriage(ivan);

        Human petya = new Human("Петя", 14, "male", olga, ivan);

        olga.addChild(petya);

        Human Andrei = new Human("Андрей", 56, "male");
        Andrei.addChild(olga);
        olga.addParent(Andrei);

        FileManager file = new FileManager("file.txt");
        file.setFile("log.txt");
        file.writeToFile(ivan.toString());
        file.writeToFile(olga.toString());
        System.out.println(file.readFromFile());
    }
}