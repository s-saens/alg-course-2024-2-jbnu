package sorter;

import java.util.ArrayList;
import java.util.Collection;

public class QuickSorter<T extends Comparable<T>> implements ISorter<T> {

    ArrayList<T> array;
    @Override
    public void sort(Collection<T> collection) {
        array = new ArrayList<>(collection);

        quick_sort(0, array.size() - 1);

        collection.clear();
        collection.addAll(array);
    }

    void quick_sort(int left, int right)
    {
        int i=left+1, j=right;
        T pivot = array.get(left);
        while(i < j)  {

        }

        quick_sort(left, i-1);
        quick_sort(i+1, right);
    }
}
