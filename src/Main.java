public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode("Root");

        TreeNode parent1 = new TreeNode("Parent1");
        TreeNode parent2 = new TreeNode("Parent2");

        TreeNode child1 = new TreeNode("Child1");
        TreeNode child2 = new TreeNode("Child2");

        root.addChild(child1);
        root.addChild(child2);

        child1.addParent(parent1);
        child2.addParent(parent2);

        System.out.println("Children of " + root.getName() + ":");
        for (TreeNode child : root.getChildren()) {
            System.out.println(child.getName());
        }

        System.out.println("Parents of " + child1.getName() + ":");
        for (TreeNode parent : child1.getParents()) {
            System.out.println(parent.getName());
        }
        System.out.println("Parents of " + child2.getName() + ":");
        for (TreeNode parent : child2.getParents()) {
            System.out.println(parent.getName());
        }
    }
}