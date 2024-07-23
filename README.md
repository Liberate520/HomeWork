
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