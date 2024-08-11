package view;

import model.Person;

import java.util.List;

public class FamilyTreeConsoleView implements FamilyTreeView {
    @Override
    public void displayFamilyTree(List<Person> members) {
        for (Person member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void displayChildren(List<Person> children) {
        if (children.isEmpty()) {
            System.out.println("Дети: Нет данных");
        } else {
            System.out.println("Дети:");
            for (Person child : children) {
                System.out.println(" - " + child.getName());
            }
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
