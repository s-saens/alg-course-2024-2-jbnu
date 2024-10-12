import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MergeInsertionSorter<T extends Comparable<T>> implements ISorter<T> {

    int insertionCount;
    ArrayList<T> array = new ArrayList<>();
    ArrayList<T> sortedArray = new ArrayList<>();

    public MergeInsertionSorter(int insertionCount) { this.insertionCount = insertionCount; }

    // Collection을 ArrayList로 변환하여 구현
    @Override
    public void sort(Collection<T> collection) {
        int size = collection.size();

        array.clear();
        sortedArray.clear();
        array.addAll(collection);
        sortedArray.addAll(collection);

        mergeSort(0, size-1);
        collection.clear();
        collection.addAll(sortedArray);
    }

    void mergeSort(int left, int right) { // inclusive
        int size = right - left + 1;
        if(size < insertionCount) {
            insertionSort(left, right);
            return;
        }

        if(left >= right) return;
        int mid = mid(left, right);

        mergeSort(left, mid);
        mergeSort(mid+1, right);
        merge(left, right);
    }

    void insertionSort(int left, int right) {
        InsertionSorter<T> insertionSorter = new InsertionSorter<>();
        List<T> list = array.subList(left, right+1);
        insertionSorter.sort(list);
        int k = 0;
        for(int i=left; i<=right; i++) {
            sortedArray.set(i, list.get(k));
            k++;
        }
    }

    void merge(int left, int right) {
        int m = mid(left, right);
        int i = left;
        int j = m+1;
        int k = left;

        while(i <= m && j <= right)  {

            if(array.get(i).compareTo(array.get(j)) <= 0) {
                sortedArray.set(k, array.get(i));
                k++; i++;
            } else {
                sortedArray.set(k, array.get(j));
                k++; j++;
            }
        }

        while(i <= m) {
            sortedArray.set(k, array.get(i));
            k++; i++;
        }

        array = new ArrayList<>(sortedArray);
    }

    int mid(int left, int right) { return (left + right)/2; }
}