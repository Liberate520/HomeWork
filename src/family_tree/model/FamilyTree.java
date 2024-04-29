package family_tree.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FamilyTree<T extends LivingBeing> {
    private List<T> beings;

    public FamilyTree() {
        this.beings = new ArrayList<>();
    }

    public void addBeing(T being) {
        this.beings.add(being);
    }

    public List<T> getBeings() {
        return Collections.unmodifiableList(beings);
    }

    public T findBeing(String name) {
        Optional<T> optionalBeing = beings.stream()
                .filter(being -> being.getName().equals(name))
                .findFirst();
        return optionalBeing.orElse(null);
    }
}
