package presenter;

import model.Gender;
import service.FamilyTreeManagementService;
import service.FamilyTreePersistenceService;
import view.View;

import java.io.IOException;
import java.time.LocalDate;

public class PresenterImpl implements Presenter {
    private static final String FILE_NAME = "family_tree.txt"; // Имя файла
    private View view;
    private FamilyTreeManagementService managementService;
    private FamilyTreePersistenceService persistenceService;

    public PresenterImpl(FamilyTreeManagementService managementService, FamilyTreePersistenceService persistenceService, View view) {
        this.managementService = managementService;
        this.persistenceService = persistenceService;
        this.view = view;
    }

    @Override
    public void addHuman(String name, LocalDate dateOfBirth, Gender gender, String fatherName, LocalDate fatherBirthDate, String motherName, LocalDate motherBirthDate) {
        managementService.addHuman(name, dateOfBirth, gender, fatherName, fatherBirthDate, motherName, motherBirthDate);
        getHumanListInfo();
    }

    @Override
    public void getHumanListInfo() {
        view.printAnswer(managementService.getHumanListInfo().toString());
    }

    @Override
    public void sortByAge() {
        managementService.sortByBirthDate();
        getHumanListInfo();
    }

    @Override
    public void sortByName() {
        managementService.sortByName();
        getHumanListInfo();
    }

    @Override
    public void findMemberByName(String name) {
        view.printAnswer(managementService.findByNameStr(name));
    }

    @Override
    public void findMembersByBirthYear(int year) {
        view.printAnswer(managementService.findByBirthYearStr(year));
    }

    @Override
    public void saveFamilyTree() {
        try {
            persistenceService.saveFamilyTree(FILE_NAME);
            view.printAnswer("Дерево семьи успешно сохранено в " + FILE_NAME);
        } catch (IOException e) {
            view.printAnswer("Ошибка при сохранении дерева семьи: " + e.getMessage());
        }
    }

    @Override
    public void loadFamilyTree() {
        try {
            persistenceService.loadFamilyTree(FILE_NAME);
            view.printAnswer("Дерево семьи успешно загружено из " + FILE_NAME);
            getHumanListInfo();
        } catch (IOException e) {
            view.printAnswer("Ошибка при загрузке дерева семьи: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            view.printAnswer("Ошибка при загрузке дерева семьи: не удалось найти класс данных.");
        }
    }
}
