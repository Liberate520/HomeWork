package family_tree;


import family_tree.view.ConsoleUI;
import family_tree.view.View;



public class Main {
   public static void main(String[] args){
       View view = new ConsoleUI();
       view.start();
   }

   /* public static Service readTree(){
        FileHandler fileHandler = new FileHandler();
        return (Service)  fileHandler.read();
    }

    public static void saveTree(Service tree)   {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);
    }*/

/*   private static Service firstTree(){
       Service service = new Service();
       service.AddHuman("Андрей", "Смит","Павлович",Gender.Male, LocalDate.of(1974,4,17));
       service.AddHuman("Алена","Смит","Борисовна", Gender.Female, LocalDate.of(1974,4,1));
       service.AddHuman("Михаил","Смит","Андреевич", Gender.Male, LocalDate.of(2008,8,14),null,service.getById(0),service.getById(1));
       service.AddHuman("Виталий","Смит","Андреевич", Gender.Male, LocalDate.of(2004,1,12),null,service.getById(0),service.getById(1));
       return service;
   }*/
}
