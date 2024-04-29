package src.view.commands;

public class IsNumeric {
    

    @SuppressWarnings("unused")
    public static boolean isNumeric (String text){
        if (text == null || text.contains("-/*+ ")){
            return false;
        }
        try {
            int i = Integer.parseInt(text);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;}
    


}
