# Объектно-ориентированное программирование (семинары)

## Урок 1. Принципы ООП: Инкапсуляция, наследование, полиморфизм

### Домашнее задание

#### Задание 1
Создать структуру генеалогического древа.

Реализовать приложение с учетом ООП подхода.

Провести исследования с генеалогическим древом.

**Идея:** описать некоторое количество компонент, например:

*   модель человека и дерева

Под "проведением исследования" можно понимать, например, получение всех детей выбранного человека.

## Урок 2. Принципы ООП Абстракция и интерфейсы. Пример проектирования

### Домашнее задание

#### Задание 2
Дополнить проект методами записи в файл и чтения из файла. Для этого создать отдельный класс и реализовать в нем нужные методы. Для данного класса сделайте интерфейс, который и используйте в своей программе. Использовать интерфейс Serialazable.

## Урок 3. Некоторые стандартные интерфейсы Java и примеры их использования

### Домашнее задание

#### Задание 3
Реализовать интерфейс Iterable для дерева. Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2). Создать пакетную структуру для проекта.

## Краткое описание программы

### FamilyTree.java
Этот класс представляет собой генеалогическое древо и содержит методы для добавления членов семьи и исследования дерева:

*   `addMember(Human human)`: Добавляет человека в дерево.
*   `getChildren(Human parent)`: Возвращает список детей указанного родителя.
*   `getSiblings(Human person)`: Возвращает список братьев и сестер указанного человека.
*   `getSpouse(Human person)`: Возвращает супруга указанного человека.
*   `getAncestors(Human person)`: Возвращает список предков указанного человека.
*   `sortByname()`: Сортирует членов семьи по имени.
*   `sortByBirthDate()`: Сортирует членов семьи по дате рождения.
*   `sortByAge()`: Сортирует членов семьи по возрасту.

### Main.java
Этот класс содержит метод `main`, который демонстрирует работу с генеалогическим древом:

*   Создает экземпляры людей (отец, мать, дети).
*   Устанавливает семейные связи (супруги, дети).
*   Добавляет людей в дерево.
*   Проводит исследования дерева (получение детей, братьев и сестер, супруга и предков).
*   Сохраняет и загружает дерево из файла.
*   Выводит информацию о членах семьи.

### Human.java
Этот класс представляет человека и содержит атрибуты и методы для работы с ними:

*   Атрибуты: имя, дата рождения, дата смерти, пол, профессия, национальность, место рождения, отец, мать, дети, супруг.
*   Конструктор: Инициализирует все атрибуты.
*   Геттеры и сеттеры: Позволяют получать и изменять значения атрибутов.
*   `addChild(Human child)`: Добавляет ребенка к человеку.
*   `getInfo()`: Возвращает строку с информацией о человеке.
*   `getYearsString(int years)`: Возвращает строку с возрастом человека.

### Gender.java
Этот перечисляемый тип представляет пол человека:

*   Значения: `Male` (мужчина), `Female` (женщина).

### FileHandler.java
Этот класс содержит методы для сохранения и загрузки дерева из файла:

*   `save(Serializable serializable)`: Сохраняет объект в файл.
*   `load()`: Загружает объект из файла.
*   `setPath(String filePath)`: Устанавливает путь к файлу.

### Writer.java
Этот интерфейс определяет методы для сохранения и загрузки объектов:

*   `save(Serializable serializable)`: Сохраняет объект.
*   `load()`: Загружает объект.
*   `setPath(String filePath)`: Устанавливает путь к файлу.

### FamilyTreeIterator.java
Этот класс реализует интерфейс Iterator для дерева:

*   `hasNext()`: Проверяет, есть ли следующий элемент.
*   `next()`: Возвращает следующий элемент.

## Пакетная структура проекта

*   `FamilyTree.model`: Содержит классы `FamilyTree` и `Human`.
*   `FamilyTree.utility`: Содержит классы `FileHandler` и `Writer`.
*   `FamilyTree.iterator`: Содержит класс `FamilyTreeIterator`.
*   `FamilyTree.human`: Содержит перечисляемый тип `Gender`.
*   `FamilyTree`: Содержит класс `Main`.
