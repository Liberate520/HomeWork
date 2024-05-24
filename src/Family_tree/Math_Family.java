package Family_tree;

public class Math_Family {
    public static long nameValue(String string){
        char[] chars = string.toCharArray();
        long vals = 0;
        for (char c : chars) {
            vals = (long) c + vals;
        }
        return vals;
    }
}
