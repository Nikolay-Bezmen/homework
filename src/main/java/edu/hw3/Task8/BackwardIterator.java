package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    public static final String HAS_NOT_NEXT_ELEMENT = "has not next element";
    private List<T> list;
    private int currIndex;

    public BackwardIterator(List<T> list) {
        this.list = list;
        this.currIndex = list.size();
    }

    @Override
    public boolean hasNext() {
        return currIndex > 0;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return list.get(--currIndex);
        }
        throw new IndexOutOfBoundsException(HAS_NOT_NEXT_ELEMENT);
    }
}
