package view;

import model.Person;

import java.util.List;

public interface FamilyTreeView {
    void displayFamilyTree(List<Person> members);
    void displayChildren(List<Person> children);
    void showMessage(String message);
}
