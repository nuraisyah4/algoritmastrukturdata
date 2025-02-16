import java.util.*;

public class Graph {
    private final int V; // Jumlah vertex
    private int E; // Jumlah edge
    private final LinkedList<Integer>[] adj; // Adjacency list

    // Constructor untuk membuat graph dengan V vertex
    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    // Method untuk menambahkan edge antara vertex v dan w
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Graph tidak berarah
        E++;
    }

    // Method untuk mendapatkan adjacency list dari vertex v
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    // Method untuk mendapatkan jumlah vertex
    public int V() {
        return V;
    }

    // Method untuk mendapatkan jumlah edge
    public int E() {
        return E;
    }

    // Method untuk representasi string dari graph
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V).append(" vertices, ").append(E()).append(" edges\n"); // Gunakan E()
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (int w : adj[v]) {
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }


    // Implementasi Depth-First Search (DFS)
    public static class DepthFirstSearch {
        private final boolean[] marked; // Array untuk menandai vertex yang sudah dikunjungi
        private final int[] edgeTo; // Array untuk menyimpan jalur dari vertex sumber ke vertex lainnya
        private final int s; // Vertex sumber

        // Constructor untuk DFS
        public DepthFirstSearch(Graph G, int s) {
            this.s = s;
            marked = new boolean[G.V()];
            edgeTo = new int[G.V()];
            dfs(G, s);
        }

        // Method rekursif untuk DFS
        private void dfs(Graph G, int v) {
            marked[v] = true;
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    dfs(G, w);
                }
            }
        }

        // Method untuk mengecek apakah ada jalur dari vertex sumber ke vertex v
        public boolean hasPathTo(int v) {
            return marked[v];
        }

        // Method untuk mendapatkan jalur dari vertex sumber ke vertex v
        public Iterable<Integer> pathTo(int v) {
            if (!hasPathTo(v)) return Collections.emptyList(); // Menghindari NullPointerException
            Stack<Integer> path = new Stack<>();
            for (int x = v; x != s; x = edgeTo[x]) {
                path.push(x);
            }
            path.push(s);
            return path;
        }
    }

    // Main method untuk testing
    public static void main(String[] args) {
        // Membuat graph dengan 6 vertex
        Graph G = new Graph(6);

        // Menambahkan edge ke graph
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 3);
        G.addEdge(2, 4);
        G.addEdge(3, 5);

        // Mencetak graph
        System.out.println(G);

        // Melakukan DFS dari vertex 0
        DepthFirstSearch dfs = new DepthFirstSearch(G, 0);

        // Mencetak jalur dari vertex 0 ke vertex 5
        System.out.print("Path from 0 to 5: ");
        for (int x : dfs.pathTo(5)) {
            System.out.print(STR."\{x} ");
        }
        System.out.println();
    }
}
