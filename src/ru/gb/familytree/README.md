HumanInfo: отвечает только за хранение информации о человеке.

FileFamilyTreeRepository: отвечает за сохранение и загрузку данных.

FamilyTreeService: реализует бизнес-логику.

FamilyTreePresenter: связывает модель данных и представление.

ConsoleFamilyTreeView: отвечает за взаимодействие с пользователем.

Изменения для использования паттерна MVP: 

Создан интерфейс FamilyTreeView и его реализация ConsoleFamilyTreeView.
Создан класс FamilyTreePresenter для обработки взаимодействий с пользователем.
Main класс инициализирует все компоненты и запускает программу.