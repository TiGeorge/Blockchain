import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Graph {
    private int n;
    private List<Integer>[] adjList;
    private List<Integer> topSort;
    private int[] used;
    boolean isDag = true;

    public Graph(int n) {
        this.n = n;
        adjList = new ArrayList[n + 1];
        topSort = new ArrayList<>();
        used = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList();
        }
    }

    public void addEdge(int a, int b) {
        adjList[a].add(b);
    }

    private void dfs(int v) {
        used[v] = v;
        for (Integer to : adjList[v]) {
            if (used[to] == 0) {
                dfs(to);
            } else if (used[to] <= v) {
                isDag = false;
            }
        }
        topSort.add(v);
    }

    public List<Integer> topologicalSort() {
        for (int i = 1; i <= n; i++) {
            used[i] = 0;
        }
        topSort.clear();
        for (int i = 1; i <= n; i++) {
            if (used[i] == 0) {
                dfs(i);
            }
        }
        Collections.reverse(topSort);
        return topSort;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Graph dag = new Graph(n);
        for (int i = 1; i <= m; i++) {
            scanner.nextLine();
            dag.addEdge(scanner.nextInt(), scanner.nextInt());
        }
        dag.topologicalSort();

        System.out.println(dag.isDag ? "YES" : "NO");
    }
}