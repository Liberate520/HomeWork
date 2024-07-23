package Human;

public enum FamilyTies {
//TODO продумать использование данной структуры!
    Mother("мать"),
    Father("отец"),
    Brother("Брат"),
    Sister("Сестра");

    private String familyTies;

    FamilyTies(String familyTies) {
        this.familyTies = familyTies;
    }

    public String getFamilyTies() {
        return familyTies;
    }

    @Override
    public String toString() {
        return "Human.FamilyTies{" +
                "familyTies='" + familyTies + '\'' +
                '}';
    }
}
