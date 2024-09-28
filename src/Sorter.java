import java.util.ArrayList;
import java.util.Collection;

public interface Sorter<T extends Comparable<T>> {
    public void sort(Collection<T> collection);
}