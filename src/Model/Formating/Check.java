package Model.Formating;

import Model.Creature.Gender;

import java.util.TreeMap;

public class Check {
    private static final TreeMap<String, Gender> genderType = new TreeMap<>();

    static {
        genderType.put("male", Gender.male);
        genderType.put("female", Gender.female);
    }

    private Check(){}

    public static boolean isInt(String string){
        try {
            Integer.parseInt(string);

            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean isGender(String string){
        return genderType.get(string) != null;
    }

    public static Gender parseGender(String string){
        return genderType.get(string);
    }

    public static Integer parseInt(String number){
        try {
            return Integer.parseInt(number);

        } catch (Exception e){
            return null;
        }
    }
}
