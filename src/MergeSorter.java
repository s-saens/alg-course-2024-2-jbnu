import java.util.ArrayList;
import java.util.Collection;

public class MergeSorter<T extends Comparable<T>> implements Sorter<T> {

    // Collection을 ArrayList로 변환하여 구현
    @Override
    public void sort(Collection<T> collection) {
        ArrayList<T> arr = new ArrayList<>(collection);
        collection.addAll(arr);
    }

    ArrayList<T> mergeSort(ArrayList<T> array) {
        int size = array.size();
        int m = size / 2;
        ArrayList<T> arr1 = new ArrayList<>(array.subList(0, m));
        ArrayList<T> arr2 = new ArrayList<>(array.subList(m, size));
        mergeSort(arr1);
        mergeSort(arr2);
        return merge(arr1, arr2);
    }

    ArrayList<T> merge(ArrayList<T> array1, ArrayList<T> array2) {
        // 구현해라~
        return null;
    }
}