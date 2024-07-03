public class Main {
        public static void main(String[] args) {



                // Уважаемый преподаватель, не чего сложного в этом проекте не создавал,
                // сделал для отчета по Домашнему заданию,
                // 400 строк Вашего кода переписал и еще во всем разбираюсь.
                // Буду откровенен тяжело, но Я ВАШ КОД ЧИТАЮ И ГЛАВНОЕ ПОНИМАЮ ЧТО В НЕМ!
                // Очень стараюсь думать, но пока тяжело все взаимосвязывать в голове.
                // Спасибо за понимание!

                // Создание людей
                Human wowa= new Human("Вова", Gender.MALE, 45);
                Human wika = new Human("Вика", Gender.FEMALE, 38);
                Human katja = new Human("Катя", Gender.FEMALE, 12);
                Human sasha = new Human("Саша", Gender.MALE, 8);

                // Создание экземпляра класса семейное дерево.
                FamilyTree familyTree = new FamilyTree();

                familyTree.addMember(wowa);
                familyTree.addMember(wika);
                familyTree.addMember(katja);
                familyTree.addMember(sasha);


                familyTree.connectSpouses(wowa, wika);


                familyTree.connectParents(katja, wowa, wika);
                familyTree.connectParents(sasha, wowa, wika);



                System.out.println("Кати родители: " + katja.getFather().getName() + " и " + katja.getMother().getName() );
                System.out.println("Саши родители: " + sasha.getFather().getName() + " и " + sasha.getMother().getName());

        }
}
