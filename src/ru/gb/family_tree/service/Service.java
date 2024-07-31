package ru.gb.family_tree.service;

import ru.gb.family_tree.familly_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.builder.HumanBuilder;

import java.time.LocalDate;

public class Service { //  в этом классе функционал Приложения, что прописано, то может делать это приложение
// сам ничего не делает (верхне уровневый), но всем раздает. Ты сделай, ты сделай.

    private final FamilyTree familyTree;
    private final HumanBuilder humanBuilder;
    // TODO можно добавить FileHandler

    public Service(){
        familyTree = new FamilyTree();
        humanBuilder = new HumanBuilder();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) { // принимаем сырые данные и обращаемся к Билдеру
        Human human = humanBuilder.build(name, gender, birthDate); // появился человек human
        familyTree.add(human); // добавили его в дерево
    }
        // TODO сохранение
        // TODO статистику посмотреть, сколько человек в дереве
        // TODO private void setGenderFromStr(String genderStr, Human human) {

        // TODO public void sortById() {

    public String getHumanListInfo() { // возвращаю только текст, а не список студентов
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");
        for (Human human : familyTree) { // не поддерживается Итератор, в FamilyTree имплементируем Итерабле и прописываем в конструкторе
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

        // TODO public void saveTree() {
        // TODO public void readTree() {
        // TODO public String findByName(String name) {
        // TODO public List<Integer> foundHumansId(String name) {
        // TODO public void removeHuman(int id) {

}
