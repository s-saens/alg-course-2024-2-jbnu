package sorter;

import java.util.ArrayList;
import java.util.Collection;

public class InsertionSorter<T extends Comparable<T>> implements ISorter<T> {

    ArrayList<T> array = new ArrayList<>();

    @Override
    public void sort(Collection<T> collection) {

        array.clear();
        array.addAll(collection);

        for (int i=1; i<array.size(); i++) {
            T key = array.get(i);

            int j;
            for(j=i-1 ; j >= 0 && key.compareTo(array.get(j)) < 0 ; j--) {
                array.set(j+1, array.get(j));
            }

            array.set(j+1, key);
        }

        collection.clear();
        collection.addAll(array);
    }
}


