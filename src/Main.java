import java.util.Scanner;

public class Main {

    static int[][] dp;

    static int get(int x, int y) {
        return x < 0 || y < 0 ? 0 : dp[y][x];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String sy = scanner.nextLine(), sx = scanner.nextLine();
        int leny = sy.length(), lenx = sx.length();

        dp = new int[leny][lenx];
        for(int y=0 ; y<leny ; ++y) for(int x=0 ; x<lenx ; ++x) {
            if(sy.charAt(y) == sx.charAt(x)) dp[y][x] = get(x-1, y-1) + 1;
            else dp[y][x] = Math.max(get(x-1, y), get(x, y-1));
        }

        int x = lenx-1, y = leny-1;
        StringBuilder sb = new StringBuilder();

        while(x >= 0 && y >= 0) {
            if (sx.charAt(x) == sy.charAt(y)) { sb.append(sy.charAt(y--)); x--; }
            else if(get(x-1, y) > get(x, y-1)) x--;
            else y--;
        }

        System.out.println(dp[leny-1][lenx-1]);
        System.out.println(sb.reverse());
    }
}