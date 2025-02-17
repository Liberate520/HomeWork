import java.util.Objects;

class FamilyRelationsService {
    public void setParents(Person child, Person father, Person mother) {
        if (Objects.nonNull(father)) {
            child.setFather(father);
            father.addChild(child);
        }
        if (Objects.nonNull(mother)) {
            child.setMother(mother);
            mother.addChild(child);
        }
    }
}
