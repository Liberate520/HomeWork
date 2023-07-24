import gb.FamilyTree.Node.RelativeNode.RelativeNode;
import gb.FamilyTree.Service.Service;
import gb.FamilyTree.Tree.Relations;

public class App {
    public static void main(String[] args) {
        testTree();
    }

    private static void testTree() {
        Service service = new Service();

        RelativeNode me = service.createNode("K", "V", "D");
        service.addNodeToTree(me);

        RelativeNode mom = service.createNode("K", "I", "G");
        service.addNodeToTree(me, mom, Relations.PARENT);

        RelativeNode sis = service.createNode("K", "P", "D");
        service.addNodeToTree(me, sis, Relations.ONE_LEVEL);

        System.out.println(service.getTreeInfo());

        service.sortByName();

        System.out.println(service.getTreeInfo());

    }
}
