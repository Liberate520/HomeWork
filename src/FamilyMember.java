import java.io.Serializable;
import java.util.List;

public interface FamilyMember extends Serializable {
    String getId();
    String getName();
    List<? extends FamilyMember> getChildren();
}