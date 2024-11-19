package sorter;

import java.util.Collection;

public interface ISorter<T extends Comparable<T>> {
    public void sort(Collection<T> collection);
}

