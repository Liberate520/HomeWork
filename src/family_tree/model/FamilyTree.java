package family_tree.model;

import java.util.*;

public class FamilyTree<T extends LivingBeing> implements Iterable<T> {
    private List<T> beings;

    public FamilyTree() {
        this.beings = new ArrayList<>();
    }

    public void addBeing(T being) {
        this.beings.add(being);
    }

    public List<T> getBeings() {
        return this.beings;
    }

    public T findBeing(String name) {
        for (T being : beings) {
            if (being.getName().equals(name)) {
                return being;
            }
        }
        return null;
    }

    public void printTree() {
        List<T> printedBeings = new ArrayList<>();
        for (T being : beings) {
            if (!printedBeings.contains(being)) {
                printBeing(being, 0, printedBeings);
            }
        }
    }

    private void printBeing(T being, int level, List<T> printedBeings) {
        if (!printedBeings.contains(being)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append("  ");
            }
            sb.append(being.getName());
            System.out.println(sb.toString());
            printedBeings.add(being);
            for (LivingBeing child : being.getChildren()) {
                printBeing((T) child, level + 1, printedBeings);
            }
        }
    }

    public List<String> convertTreeToText() {
        List<String> lines = new ArrayList<>();
        for (T being : beings) {
            StringBuilder sb = new StringBuilder();
            sb.append(being.getName()).append(",").append(being.getGender()).append(",").append(being.getBirthDate()).append(",").append(being.getDeathDate());
            lines.add(sb.toString());
            for (LivingBeing parent : being.getParents()) {
                lines.add(parent.getName() + "," + being.getName());
            }
        }
        return lines;
    }

    @Override
    public Iterator<T> iterator() {
        return beings.iterator();
    }

    public void sortByNames() {
        Collections.sort(beings, Comparator.comparing(LivingBeing::getName));
    }

    public void sortByBirthDate() {
        Collections.sort(beings, new Comparator<T>() {
            @Override
            public int compare(T being1, T being2) {
                String[] birthDate1 = being1.getBirthDate().split("-");
                String[] birthDate2 = being2.getBirthDate().split("-");

                int year1 = Integer.parseInt(birthDate1[2]);
                int year2 = Integer.parseInt(birthDate2[2]);
                if (year1 != year2) {
                    return Integer.compare(year1, year2);
                }

                int month1 = Integer.parseInt(birthDate1[1]);
                int month2 = Integer.parseInt(birthDate2[1]);
                if (month1 != month2) {
                    return Integer.compare(month1, month2);
                }

                int day1 = Integer.parseInt(birthDate1[0]);
                int day2 = Integer.parseInt(birthDate2[0]);
                return Integer.compare(day1, day2);
            }
        });
    }
}
