import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[100];
        for(int i=0 ; i<100 ; ++i) arr[i] = i+1;

        int[] aux = arr.clone();
        shuffle(aux);

        System.out.println(Arrays.toString(aux));
        System.out.println(quickSelect(aux, 6, false));
    }

    static void shuffle(int[] arr) {

        int length = arr.length;
        Random random = new Random();

        for (int i = length - 1; i > 0; i--) {

            int randomIndex = random.nextInt(0, i + 1);

            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }

    static List<Integer> quickSelect(int[] arr, int n, Boolean ascending) {

        int length = arr.length;
        select(arr, 0, length-1, n, ascending);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=length-n ; i<length ; ++i) list.add(arr[i]);
        InsertionSorter<Integer> sorter = new InsertionSorter<>();
        sorter.sort(list);

        return list;
    }

    static int select(int[] arr, int l, int r, int n, Boolean ascending) {

        if (l == r) return arr[l];

        int pivotIndex = partition(arr, l, r, ascending);

        int length = arr.length;
        int dist = length - n;
        if (pivotIndex == dist) return arr[pivotIndex];
        if (pivotIndex > dist) return select(arr, l, pivotIndex - 1, n, ascending);

        return select(arr, pivotIndex + 1, r, n, ascending);
    }

    static int partition(int[] arr, int left, int right, Boolean ascending) {

        int pivot = arr[right];
        int i = left;

        for (int j = left ; j < right ; ++j) {
            if ((ascending ? 1 : -1) * (arr[j] - pivot) > 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;

        return i;
    }
}

