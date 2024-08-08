package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import util.TreeIterable;

public class FamilyTree<T> implements Serializable, Iterable<T> {
    private List<T> members;
    private ParentChildChecker<T> checker;

    public FamilyTree(ParentChildChecker<T> checker) {
        this.members = new ArrayList<>();
        this.checker = checker;
    }

    public void addMember(T member) {
        members.add(member);
    }

    public List<T> getChildren(T parent) {
        List<T> children = new ArrayList<>();
        for (T member : members) {
            if (checker.isChildOf(member, parent)) {
                children.add(member);
            }
        }
        return children;
    }

    public List<T> getMembers() {
        return members;
    }

    public void printFamilyTree() {
        for (T member : members) {
            System.out.println(member);
            List<T> children = getChildren(member);
            if (!children.isEmpty()) {
                System.out.println("Дети:");
                for (T child : children) {
                    System.out.println(" - " + ((Person) child).getName());
                }
            } else {
                System.out.println("Дети: Нет данных");
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterable<>(members);
    }

    public void sortByName(Comparator<T> comparator) {
        members.sort(comparator);
    }

    public void sortByBirthDate(Comparator<T> comparator) {
        members.sort(comparator);
    }
}
