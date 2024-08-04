
# Урок 1. Принципы ООП: Инкапсуляция, наследование, полиморфизм

## Задание
Реализовать, с учетом ооп подхода, приложение.
Для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
модель человека и дерева
Под “проведением исследования” можно понимать например получение всех детей выбранного человека.

## Пример работы программы

```
Children and descendants of John Michael Doe:
FamilyTree{members=
Human{name='Alice Marie Doe', gender=Female, birthDate=2000-03-30, placeOfBirth='Sydney', deathDate=null}
Human{name='Bob John Doe', gender=Male, birthDate=2002-07-10, placeOfBirth='Sydney', deathDate=null}}


Full family tree:
FamilyTree{members=
Human{name='John Michael Doe', gender=Male, birthDate=1975-05-20, placeOfBirth='Sydney', deathDate=null}
Human{name='Jane Elizabeth Smith', gender=Female, birthDate=1978-08-15, placeOfBirth='Melbourne', deathDate=null}
Human{name='Alice Marie Doe', gender=Female, birthDate=2000-03-30, placeOfBirth='Sydney', deathDate=null}
Human{name='Bob John Doe', gender=Male, birthDate=2002-07-10, placeOfBirth='Sydney', deathDate=null}}
```

# Урок 2. Принципы ООП Абстракция и интерфейсы. Пример проектирования

## Задание
Дополнить проект методами записи в файл и чтения из файла. Для этого создать отдельный класс и реализовать в нем нужные методы. Для данного класса сделайте интерфейс, который и используйте в своей программе. Пример работы с интерфейсом Serialazable можно найти в материалах к уроку.
Поправить замечания к первому уроку

## Решение
Для решения задачи создан интерфейс [PersistenceHandler](./src/ru/gb/family_tree/PersistenceHandler.java) и класс [FileHandler](./src/ru/gb/family_tree/FileHandler.java). реализующий интерфейс.


# Урок 3. Некоторые стандартные интерфейсы Java и примеры их использования

Продолжаем работать с проектом с семейным деревом.
Реализовать интерфейс Iterable для дерева.
Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)
