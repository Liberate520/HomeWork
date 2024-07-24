public interface FamilyTreeInterface {
    void addMember(Person person);
    Person findMember(int id);
    void addChild(Person parent, Person child);
}