package main;

import model.FamilyTree;
import model.Person;
import model.PersonParentChildChecker;

import java.time.LocalDate;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Создание проверщика отношений "Родитель-Ребенок"
        PersonParentChildChecker checker = new PersonParentChildChecker();

        // Создание генеалогического древа с проверщиком
        FamilyTree<Person> familyTree = new FamilyTree<>(checker);

        // Создание людей
        Person rustam = new Person("Рустам", LocalDate.of(1962, 4, 4), null, null, null);
        Person boyjon = new Person("Бойжон", LocalDate.of(1940, 1, 1), null, null, null);
        Person mukaddas = new Person("Мукаддас", LocalDate.of(1962, 5, 5), null, boyjon, null);
        Person doniyor = new Person("Дониёр", LocalDate.of(1987, 11, 8), null, mukaddas, rustam);
        Person sevora = new Person("Севара", LocalDate.of(1991, 2, 2), null, null, null);
        Person samiy = new Person("Самий", LocalDate.of(2015, 12, 3), null, sevora, doniyor);

        // Добавление людей в генеалогическое древо
        familyTree.addMember(rustam);
        familyTree.addMember(boyjon);
        familyTree.addMember(mukaddas);
        familyTree.addMember(doniyor);
        familyTree.addMember(sevora);
        familyTree.addMember(samiy);

        // Вывод информации о всех людях в генеалогическом древе
        System.out.println("Список всех людей в генеалогическом древе:");
        familyTree.printFamilyTree();

        // Получение и вывод всех детей выбранного человека
        System.out.println("Дети Дониёра:");
        familyTree.getChildren(doniyor).forEach(child -> System.out.println(" - " + child.getName()));

        // Вывод всей информации о человеке
        System.out.println("\nИнформация о Рустаме:");
        System.out.println(rustam);

        System.out.println("\nИнформация о Севаре:");
        System.out.println(sevora);

        // Сортировка по имени
        familyTree.sortByName(Comparator.comparing(Person::getName));
        System.out.println("\nОтсортировано по имени:");
        familyTree.printFamilyTree();

        // Сортировка по дате рождения
        familyTree.sortByBirthDate(Comparator.comparing(Person::getBirthDate));
        System.out.println("\nОтсортировано по дате рождения:");
        familyTree.printFamilyTree();
    }
}
