public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Human human1 = new Human("Vagif", "male", null, null, null, null);
        Human human2 = new Human("Naila", "female", null, null, null, null);
        Human human3 = new Human("Ramil", "male", human1, human2, null, null);
        Human human4 = new Human("Nigar", "female", null, null, null, null);
        Human human5 = new Human("Murad", "male", human3, human4, human2, human1);
        Human human6 = new Human("Ayla", "female", human3, human4, human2, human1);
        human1.SetDateOfBirth(1954, 4, 15);
        human2.SetDateOfBirth(1950, 1, 21);
        human3.SetDateOfBirth(1981, 9, 27);
        human4.SetDateOfBirth(1983, 3, 28);
        human5.SetDateOfBirth(2008, 2, 24);
        human6.SetDateOfBirth(2010, 12, 1);
        human1.addChild(human3);
        human2.addChild(human3);
        human3.addChild(human5);
        human3.addChild(human6);
        human4.addChild(human5);
        human4.addChild(human6);
        familyTree.addHumanToFamilyTree(human1);
        familyTree.addHumanToFamilyTree(human2);
        familyTree.addHumanToFamilyTree(human3);
        familyTree.addHumanToFamilyTree(human4);
        familyTree.addHumanToFamilyTree(human5);
        familyTree.addHumanToFamilyTree(human6);
        familyTree.getFamilyTree();
    }
}