package util;

import java.util.Iterator;
import java.util.List;

public class TreeIterable<T> implements Iterator<T> {
    private List<T> members;
    private int index;

    public TreeIterable(List<T> members) {
        this.members = members;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < members.size();
    }

    @Override
    public T next() {
        return members.get(index++);
    }
}
