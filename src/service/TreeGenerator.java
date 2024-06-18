package service;

import human.Gender;
import human.Human;
import tree.FamilyTree;

import java.time.*;
import java.util.*;


public class TreeGenerator {
    public TreeGenerator(FamilyTree familyTree, long randomSeed){
        rnd = new Random();
        rnd.setSeed(randomSeed);
        humansArrayList = new ArrayList<>();
        maleName = new ArrayList<>();
        famaleName = new ArrayList<>();
        lastName = new ArrayList<>();

        maleName.add("William");
        maleName.add("James");
        maleName.add("Benjamin");
        maleName.add("Alexander");
        maleName.add("Jacob");
        maleName.add("Michael");
        maleName.add("Daniel");
        maleName.add("Joshua");
        maleName.add("Andrew");
        maleName.add("Christopher");


        famaleName.add("Emma");
        famaleName.add("Olivia");
        famaleName.add("Ava");
        famaleName.add("Isabella");
        famaleName.add("Sophia");
        famaleName.add("Mia");
        famaleName.add("Charlotte");
        famaleName.add("Harper");
        famaleName.add("Amelia");
        famaleName.add("Emily");

        lastName.add("Smith");
        lastName.add("Johnson ");
        lastName.add("Williams");
        lastName.add("Brown");
        lastName.add("Davis");
        lastName.add("Miller");
        lastName.add("Wilson");
        lastName.add("Anderson");
        lastName.add("Taylor");
        lastName.add("Thomas");
    }
    static ArrayList<Human> humansArrayList;
    public FamilyTree treeGenerator(){
        FamilyTree tree = new FamilyTree();
        //нулевое поколение
        humansArrayList.add(new Human(getRandomName(NameType.nameMale), getRandomName(NameType.lastName),  LocalDate.of(1750,1,10), LocalDate.of(1820,3,1), Gender.Male));
        humansArrayList.add(new Human(getRandomName(NameType.nameFamale), humansArrayList.get(0).getLastName(),  LocalDate.of(1755,5,15), LocalDate.of(1820,12,13), Gender.Female,null,null, humansArrayList.get(0)));

        int startID = 0, endID = humansArrayList.size();



        for(int g = 1; g < 8; g++){ // цикл поколений
            for(int h = startID; h < endID; h++){ //проходим по людям в поколении. для каждой женщины генерирует детей
                if(getFertilePeriod(humansArrayList.get(h)) != 0 && humansArrayList.get(h).getGender() == Gender.Female) { // усли девушка и дожила до репродуктивного возраста
                    int childCount = rnd.nextInt(Math.toIntExact(getFertilePeriod(humansArrayList.get(h))/2)-1); // кол-во детей в семье
                    for (int i = 0; i < childCount; i++) {
                        Gender gender;
                        if (rnd.nextBoolean()) {
                            gender = Gender.Male;
                        } else {
                            gender = Gender.Female;
                        }
                        LocalDate tmpBD;
                        tmpBD = humansArrayList.get(h).getDateOfBirth();
                        tmpBD = tmpBD.plusDays((rnd.nextInt(7300) + 5840));
                        humansArrayList.add(new Human(getRandomName(gender), humansArrayList.get(h).getSpouse().getLastName(), tmpBD, tmpBD.plusDays(rnd.nextInt(36500)), gender, humansArrayList.get(h), humansArrayList.get(h).getSpouse()));
                    }
                }
            }
            startID = endID;
            endID = humansArrayList.size();
            for(int h = startID; h < endID; h++) { // проходим по детям в поколении, генерируем супругов
                if(getFertilePeriod(humansArrayList.get(h)) != 0) { // если человек дожил до репродуктивного возраста то генерим супругов
                    Gender gender;
                    String lastName;
                    if(humansArrayList.get(h).getGender() == Gender.Male){
                        gender = Gender.Female;
                        lastName =  humansArrayList.get(h).getLastName();
                    }else{
                        gender = Gender.Male;
                        lastName = getRandomName(NameType.lastName);
                        humansArrayList.get(h).setLastName(lastName);
                    }
                    LocalDate dateOfBirth;
                    dateOfBirth = humansArrayList.get(h).getDateOfBirth();
                    dateOfBirth = dateOfBirth.plusDays((rnd.nextInt(3650) - 1825));
                    humansArrayList.add(new Human(getRandomName(gender), lastName, dateOfBirth, dateOfBirth.plusDays(rnd.nextInt(29200)+7300), gender, null,null, humansArrayList.get(h)));
                    if(gender == Gender.Male){

                    }
                }
            }
            endID = humansArrayList.size();
        }
        for (int i =0; i < humansArrayList.size(); i++){
            tree.add(humansArrayList.get(i));
        }
        return tree;
    }
    private enum NameType{
        nameMale, nameFamale, lastName;
    }
    private ArrayList<String> maleName;
    private ArrayList<String> famaleName;
    private ArrayList<String> lastName;
    private Random rnd;

    private Human humanGenerator(int Generation) {

        return null;
    }

    private String getRandomName(NameType nameType){
        if(nameType==NameType.nameMale) {
            return maleName.get(rnd.nextInt(10));
        }
        if(nameType==NameType.nameFamale) {
            return famaleName.get(rnd.nextInt(10));
        }
        if(nameType==NameType.lastName) {
            return lastName.get(rnd.nextInt(10));
        }
        return null;
    }
    private String getRandomName(Gender gender){
        if(gender == Gender.Male){
            return getRandomName(NameType.nameMale);
        }else {
            return getRandomName(NameType.nameFamale);
        }
    }
    private int getFertilePeriod(Human human){
        long period = human.getAge() - 15;
        if (period < 1){
            return 0;
        }
        if(period > 20){
            return 20;
        }
        return 0;
    }

}
