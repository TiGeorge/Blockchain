import java.util.*;

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
            } else if (used[to] == v) {
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

    private boolean smollest(Integer vertex) {
        for (int i = 1; i < adjList.length; i++) {
            List<Integer> list = adjList[i];
            for (Integer adj : list) {
                if (adj.equals(vertex)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        Map<String, Integer> vars = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            vars.put(scanner.nextLine(), i);
        }

        Graph dag = new Graph(n);
        for (int i = 0; i < m; i++) {
            String constraint = scanner.nextLine();
            if (constraint.contains("<")) {
                String[] split = constraint.split("<");
                dag.addEdge(vars.get(split[0]),
                        vars.get(split[1]));
            } else if (constraint.contains(">")) {
                String[] split = constraint.split(">");
                dag.addEdge(vars.get(split[1]), vars.get(split[0]));
            }
        }
        dag.topologicalSort();

        if (dag.isDag) {
            int count = 0;
            for (Integer vertex : dag.topSort) {
                if (dag.smollest(vertex)) {
                    count++;
                }
            }
            System.out.println(count);
        } else {
            System.out.println("NO");
        }
    }
}