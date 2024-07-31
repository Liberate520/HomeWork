package model.writer;

public class PathToFile {
    private static String defaultPath = "src/defaultTree.out";

    public static String getDefaultPath() {
        return defaultPath;
    }

    public static void setPath(String path) {
        defaultPath = path;
    }
}
