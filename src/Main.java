import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human me = new Human(
                "Буряковский",
                "Павел",
                "Кириллович",
                Gender.Male,
                LocalDate.of(2000, 4, 22),
                null,
                "не в браке",
                "Буряковский Кирилл Борисович",
                "Буряковская (Попкова) Варвара Викторовна",
                "отсутствуют");

        Human dad = new Human(
                "Буряковский",
                "Кирилл",
                "Борисович",
                Gender.Male,
                LocalDate.of(1972, 9, 19),
                null,
                "Буряковская (Попкова) Варвара Викторовна",
                "Буряковский Борис Анатольевич",
                "Буряковская (Феофанова) Любовь Васильевна",
                "Буряковский Павел Кириллович");

        Human mom = new Human(
                "Буряковская (Попкова)",
                "Варвара",
                "Викторовна",
                Gender.Female,
                LocalDate.of(1978, 3, 1),
                null,
                "Буряковский Кирилл Борисович",
                "Попков Виктор Александрович",
                "Попкова Ольга Юрьевна",
                "Буряковский Павел Кириллович");

        familyTree.addHuman(me);
        familyTree.addHuman(dad);
        familyTree.addHuman(mom);

        System.out.println(familyTree.toString());
    }
}
