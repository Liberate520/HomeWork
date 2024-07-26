public class FamilyTree {
    private Human root;

    public FamilyTree() {
        // No arguments
    }

    public FamilyTree(Human root) {
        this.root = root;
    }

        public Human getRoot() {
            return root;
        }

    public String queryVariable(String variableName) {
        switch (variableName) {
            case "name":
                return root.getName();
            case "gender":
                return root.getGender().toString();
            case "birthDate":
                return root.getBirthDate().toString();
            case "deathDate":
                return root.getDeathDate().toString();
            case "parents":
                return root.getParents().toString();
            case "children":
                return root.getChildren().toString();
            default:
                return "Variable not found";
        }
    }
}


