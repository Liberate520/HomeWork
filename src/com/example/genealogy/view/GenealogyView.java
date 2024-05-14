package com.example.genealogy.view;

import java.util.List;
import java.util.Scanner;

import com.example.genealogy.model.GenealogyService;
import com.example.genealogy.model.Person;

public class GenealogyView {

    private GenealogyService genealogyService;
    private Scanner scanner;

    public GenealogyView(GenealogyService genealogyService) {
        this.genealogyService = genealogyService;
        this.scanner = new Scanner(System.in);
    }

    public void runConsole() {
        while (true) {
            System.out.println("Введите команду или help для получения справки:");
            String command = scanner.nextLine();

            Command commandObject = createCommand(command);
            if (commandObject != null) {
                commandObject.execute(genealogyService);
            } else {
                System.out.println("Неизвестная команда. Введите help для получения справки.");
            }
        }
    }

    private Command createCommand(String command) {
        switch (command) {
            case "add_person":
                return new AddPersonCommand();
            case "remove_person":
                return new RemovePersonCommand();
            case "add_relationship":
                return new AddRelationshipCommand();
            case "remove_relationship":
                return new RemoveRelationshipCommand();
            case "print_tree":
                return new PrintTreeCommand();
            case "save_tree":
                return new SaveTreeCommand();
            case "load_tree":
                return new LoadTreeCommand();
            case "display_data":
                return new DisplayDataCommand();
            case "display_sorted_by_name":
                return new DisplaySortedByNameCommand();
            case "display_sorted_by_date_of_birth":
                return new DisplaySortedByDateOfBirthCommand();
            case "help":
                return new HelpCommand();
            default:
                return null;
        }
    }

    private interface Command {
        void execute(GenealogyService genealogyService);
    }

    private class AddPersonCommand implements Command {
        @Override
        public void execute(GenealogyService genealogyService) {
            System.out.println("Введите имя человека:");
            String name = scanner.nextLine();
            genealogyService.addPerson(name);
        }
    }

    private class RemovePersonCommand implements Command {
        @Override
        public void execute(GenealogyService genealogyService) {
            System.out.println("Введите имя человека для удаления:");
            String name = scanner.nextLine();
            genealogyService.removePerson(name);
        }
    }

    private class AddRelationshipCommand implements Command {
        @Override
        public void execute(GenealogyService genealogyService) {
            System.out.println("Введите имя первого человека:");
            String person1 = scanner.nextLine();
            System.out.println("Введите имя второго человека:");
            String person2 = scanner.nextLine();
            System.out.println("Введите тип связи:");
            String relationshipType = scanner.nextLine();
            genealogyService.addRelationship(person1, person2, relationshipType);
        }
    }

    private class RemoveRelationshipCommand implements Command {
        @Override
        public void execute(GenealogyService genealogyService) {
            System.out.println("Введите имя первого человека:");
            String person1 = scanner.nextLine();
            System.out.println("Введите имя второго человека:");
            String person2 = scanner.nextLine();
            genealogyService.removeRelationship(person1, person2);
        }
    }

    private class PrintTreeCommand implements Command {
        @Override
        public void execute(GenealogyService genealogyService) {
            String treeString = genealogyService.printTree();
            System.out.println(treeString);
        }
    }

    private class SaveTreeCommand implements Command {
        @Override
        public void execute(GenealogyService genealogyService) {
            System.out.println("Введите имя файла для сохранения дерева:");
            String filename = scanner.nextLine();
            genealogyService.saveTree(filename);
        }
    }

    private class LoadTreeCommand implements Command {
        @Override
        public void execute(GenealogyService genealogyService) {
            System.out.println("Введите имя файла для загрузки дерева:");
            String filename = scanner.nextLine();
            genealogyService.loadTree(filename);
        }
    }

    private class DisplayDataCommand implements Command {
        @Override
        public void execute(GenealogyService genealogyService) {
            List<Person> people = genealogyService.getAllPeople();
            displayData(people);
        }
    }

    private class DisplaySortedByNameCommand implements Command {
        @Override
        public void execute(GenealogyService genealogyService) {
            List<Person> people = genealogyService.getAllPeople();
            displaySortedByName(people);
        }
    }

    private class DisplaySortedByDateOfBirthCommand implements Command {
        @Override
        public void execute(GenealogyService genealogyService) {
            List<Person> people = genealogyService.getAllPeople();
            displaySortedByDateOfBirth(people);
        }
    }

    private class HelpCommand implements Command {
        @Override
        public void execute(GenealogyService genealogyService) {
            System.out.println("Список команд:");
            System.out.println("add_person - добавить человека");
            System.out.println("remove_person - удалить человека");
            System.out.println("add_relationship - добавить связь");
            System.out.println("remove_relationship - удалить связь");
            System.out.println("print_tree - отобразить дерево");
            System.out.println("save_tree - сохранить дерево");
            System.out.println("load_tree - загрузить дерево");
            System.out.println("display_data - отобразить данные");
            System.out.println("display_sorted_by_name - отобразить данные, отсортированные по имени");
            System.out.println("display_sorted_by_date_of_birth - отобразить данные, отсортированные по дате рождения");
            System.out.println("help - отобразить эту справку");
        }
    }

    public void displayTree() {
        String treeString = genealogyService.printTree();
        System.out.println(treeString);
    }

    public void displayData(List<Person> people) {
        System.out.println("Данные загружены:");
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }

    public void displaySortedByName(List<Person> people) {
        System.out.println("Данные отсортированы по имени:");
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }

    public void displaySortedByDateOfBirth(List<Person> people) {
        System.out.println("Данные отсортированы по дате рождения:");
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }
}