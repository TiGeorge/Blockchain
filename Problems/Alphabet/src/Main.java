import java.util.*;

class Graph {
    private int n;
    private List<Integer>[] adjList;
    private List<Integer> topSort;
    private boolean[] used;

    public Graph(int n) {
        this.n = n;
        adjList = new ArrayList[n + 1];
        topSort = new ArrayList<>();
        used = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList();
        }
    }

    public void addEdge(int a, int b) {
        if (!adjList[a].contains(b)) {
            adjList[a].add(b);
        }
    }

    private void dfs(int v) {
        used[v] = true;
        for (Integer to : adjList[v]) {
            if (!used[to]) {
                dfs(to);
            }
        }
        topSort.add(v);
    }

    public List<Integer> topologicalSort() {
        for (int i = 1; i <= n; i++) {
            used[i] = false;
        }
        topSort.clear();
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                dfs(i);
            }
        }
        Collections.reverse(topSort);
        return topSort;
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> vertexes = new HashMap<>();
        List<String[]> words = new ArrayList<>();
        int countVert = 0;
        for (int i = 0; i < n; i++) {
            String[] word = scanner.nextLine().split("");
            words.add(word);
            for (String s : word) {
                if (!vertexes.containsKey(s)) {
                    vertexes.put(s, ++countVert);
                }
            }
        }
        Graph dag = new Graph(vertexes.size());

        for (int i = 1; i < words.size(); i++) {
            String[] previous = words.get(i - 1);
            String[] current = words.get(i);
            for (int j = 0; j < Math.min(previous.length, current.length); j++) {
                if (!previous[j].equals(current[j])) {
                    dag.addEdge(vertexes.get(previous[j]), vertexes.get(current[j]));
                    break;
                }
            }
        }

        dag.topologicalSort();
        dag.topSort.forEach(i -> System.out.print(getKey(vertexes, i)));
    }
}