import java.util.Scanner;

public class Main {

    static int get(int x, int y, int[][] dp) {
        return x < 0 || y < 0 ? 0 : dp[y][x];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String sy = scanner.nextLine(), sx = scanner.nextLine();
        int leny = sy.length(), lenx = sx.length();

        int[][] dp = new int[leny][lenx];
        for(int y=0 ; y<leny ; ++y) for(int x=0 ; x<lenx ; ++x) {
            if(sy.charAt(y) == sx.charAt(x)) dp[y][x] = get(x-1, y-1, dp) + 1;
            else dp[y][x] = Math.max(get(x-1, y, dp), get(x, y-1, dp));
        }

        System.out.println(dp[leny-1][lenx-1]);
    }
}