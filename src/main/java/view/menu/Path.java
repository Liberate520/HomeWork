package view.menu;

public enum Path {
    PATH("src/main/java/tree.txt");

    private String path;
    Path(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return this.path;
    }

    public String getPath(){
        return path;
    }

}
