import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] stack;
    static int stackSize;
    static int currentSccIndex;
    static int[] sccIndex;

    static void dfs1(int now) {
        visited[now] = true;

        for(int next : graph[now]) if(!visited[next]) dfs1(next);

        stack[stackSize++] = now;
    }

    static void dfs2(int now, int id) {
        visited[now] = true;
        sccIndex[now] = id;
        for(int i = 0; i < N; i++) if(!visited[i] && contains(i, now)) dfs2(i, id);
    }

    static boolean contains(int i, int target) {
        for(int x : graph[i]) if(x == target) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        graph = new List[N];
        for(int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            graph[a].add(b);
        }

        stack = new int[N];
        stackSize = 0;
        visited = new boolean[N];
        for(int i = 0; i < N; i++)
            if(!visited[i])
                dfs1(i);

        sccIndex = new int[N];
        Arrays.fill(sccIndex, -1);
        visited = new boolean[N];
        currentSccIndex = 0;

        for(int i = stackSize - 1; i >= 0; i--) {
            int now = stack[i];
            if(!visited[now])
                dfs2(now, currentSccIndex++);
        }

        List<Integer>[] sccGroups = new List[currentSccIndex];

        for(int i = 0; i < currentSccIndex; i++)
            sccGroups[i] = new ArrayList<>();

        for(int i = 0; i < N; i++)
            sccGroups[sccIndex[i]].add(i + 1);

        for(List<Integer> scc : sccGroups)
            Collections.sort(scc);

        Integer[] order = new Integer[currentSccIndex];

        for(int i = 0; i < currentSccIndex; i++) order[i] = i;

        Arrays.sort(order, Comparator.comparingInt(a -> sccGroups[a].getFirst()));

        System.out.println(currentSccIndex);
        for(int i : order) {
            for(int v : sccGroups[i])
                System.out.print(v + " ");
            System.out.print("-1\n");
        }
    }
}