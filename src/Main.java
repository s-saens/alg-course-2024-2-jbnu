import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] arr = { 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1 };

        int cnt0 = 0, cnt1 = 0, first = arr[0], second = -1;

        for (int e : arr) {
            if (first == e) cnt0++;
            else {
                cnt1++;
                second = e;
            }
        }

        if (first > second) { // swap if first is bigger than second
            int temp = first;
            first = second;
            second = temp;
        }

        for (int i=0 ; i<cnt0 ; ++i) arr[i] = first;
        for (int i=cnt0 ; i<arr.length ; ++i) arr[i] = second;

        System.out.println(Arrays.toString(arr));
    }
}