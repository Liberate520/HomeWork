//package service;


//public void getHumanListInfo() {
//        presenter.getHumanListInfo();
//    }
//
//    public void addHuman() {
//        System.out.println("Укажите имя");
//        String name = scanner.nextLine();
//        System.out.println("Укажите пол (male/female)");
//        String gender1 = scanner.nextLine();
//        Gender gender = parse(gender1);
//
//        System.out.println("Укажите дату рождения  (в формате 01.01.1900)");
//        String birthdate = scanner.nextLine();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        LocalDate date = LocalDate.parse(birthdate, formatter);
//
//        presenter.addHuman(name,gender,date);
//    }
//    public void addParent() {
//        System.out.println("Введите ID родителя:");
//        String id = scanner.nextLine();
//        Long parID = Long.parseLong(id);
//        System.out.println("Введите ID ребенка:");
//        String id1 = scanner.nextLine();
//        Long chID = Long.parseLong(id1);
//
//        presenter.addParent(parID,chID);
//    }
//    public void addMarriage() {
//        System.out.println("Введите ID мужа:");
//        String id = scanner.nextLine();
//        Long human1 = Long.parseLong(id);
//        System.out.println("Введите ID жены:");
//        String id1 = scanner.nextLine();
//        Long human2 = Long.parseLong(id1);
//
//        presenter.addMarriage(human1,human2);
//    }
//
//    public void sortByName() {
//        presenter.sortByName();
//    }
//
//    public void saveToFile() throws IOException {
//        presenter.saveToFile();
//        System.out.println("Данные сохранены в файл .txt");
//    }
//
//    public void readFromFile() throws IOException, ClassNotFoundException {
//        System.out.println(presenter.readFromFile()); ;
//    }
//
//    public void finish() {
//        work = false;
//        scanner.close();
//        System.out.println("До свидания!");
//    }
//
//
//    @Override
//    public void printAnswer(String answer) {
//        System.out.println(answer);
//
//    }
//
//    public static Gender parse(String gender) {
//        if (gender == null) {
//            throw new IllegalArgumentException("Gender cannot be null");
//        }
//        try {
//            return Gender.valueOf(gender.toLowerCase());
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException("No enum constant " + gender);
//        }
//    }
//}
