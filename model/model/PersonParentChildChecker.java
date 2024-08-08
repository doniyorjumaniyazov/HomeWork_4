package model;

public class PersonParentChildChecker implements ParentChildChecker<Person> {

    @Override
    public boolean isChildOf(Person child, Person parent) {
        return child.getMother() == parent || child.getFather() == parent;
    }
}
