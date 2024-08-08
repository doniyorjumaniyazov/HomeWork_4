package model;

public interface ParentChildChecker<T> {
    boolean isChildOf(T child, T parent);
}
