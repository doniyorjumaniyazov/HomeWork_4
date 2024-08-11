package main;

import model.FamilyTree;
import model.Person;
import model.PersonParentChildChecker;
import view.FamilyTreeConsoleView;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Модель
        PersonParentChildChecker checker = new PersonParentChildChecker();
        FamilyTree<Person> familyTree = new FamilyTree<>(checker);

        // Представление
        FamilyTreeConsoleView view = new FamilyTreeConsoleView();

        // Презентер
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTree, view);

        // Добавление людей через презентер
        Person rustam = new Person("Рустам", LocalDate.of(1962, 4, 4), null, null, null);
        Person boyjon = new Person("Бойжон", LocalDate.of(1940, 1, 1), null, null, null);
        Person mukaddas = new Person("Мукаддас", LocalDate.of(1962, 5, 5), null, boyjon, null);
        Person doniyor = new Person("Дониёр", LocalDate.of(1987, 11, 8), null, mukaddas, rustam);
        Person sevora = new Person("Севара", LocalDate.of(1991, 2, 2), null, null, null);
        Person samiy = new Person("Самий", LocalDate.of(2015, 12, 3), null, sevora, doniyor);

        presenter.addPerson(rustam);
        presenter.addPerson(boyjon);
        presenter.addPerson(mukaddas);
        presenter.addPerson(doniyor);
        presenter.addPerson(sevora);
        presenter.addPerson(samiy);

        // Отображение генеалогического древа
        presenter.displayFamilyTree();

        // Отображение детей
        presenter.displayChildren(doniyor);

        // Сортировка и отображение
        presenter.sortByName();
        presenter.sortByBirthDate();
    }
}
