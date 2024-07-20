package Model;

public class Checks {
    public static Integer parseInt(String string){
        try {
            return Integer.parseInt(string);
        } catch (Exception e){
            return null;
        }
    }
}
