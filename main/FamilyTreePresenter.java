package main;

import model.FamilyTree;
import model.Person;
import view.FamilyTreeView;

import java.util.List;

public class FamilyTreePresenter {
    private FamilyTree<Person> familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<Person> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void addPerson(Person person) {
        familyTree.addMember(person);
        view.showMessage("Человек добавлен: " + person.getName());
    }

    public void displayFamilyTree() {
        List<Person> members = familyTree.getMembers();
        view.displayFamilyTree(members);
    }

    public void displayChildren(Person parent) {
        List<Person> children = familyTree.getChildren(parent);
        view.displayChildren(children);
    }

    public void sortByName() {
        familyTree.sortByName();
        view.showMessage("Генеалогическое древо отсортировано по имени.");
        displayFamilyTree();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
        view.showMessage("Генеалогическое древо отсортировано по дате рождения.");
        displayFamilyTree();
    }
}
