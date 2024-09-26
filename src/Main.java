import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // input
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        System.out.println(Josephus(N, M));
    }

    static ArrayList<Integer> Josephus(int N, int M) {
        Queue<Integer> queue = new Queue<Integer>(10);

        for(int i=1 ; i<=N ; ++i) {
            queue.push(i);
        }

        int cnt = 1;

        ArrayList<Integer> answer = new ArrayList<>();
        while(!queue.empty())
        {
            if(cnt == M) {
                cnt = 1;
                answer.add(queue.pop());
            }
            else {
                cnt++;
                queue.push(queue.pop());
            }
        }

        return answer;
    }

    static int tripletSum(int N, int sum) {
        int cnt = 0;



        return cnt;
    }
}
