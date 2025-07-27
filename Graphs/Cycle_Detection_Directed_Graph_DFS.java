class Graph_2{
    private char[] vertexData;
    private int[][] matrix;
    private int size;

    public Graph_2(int size){
        this.size = size;
        this.matrix = new int[size][size];
        this.vertexData = new char[size];
    }

    public void add_vertices(int v_index, char vertex){
        if (v_index>=0 && v_index<this.size)
            this.vertexData[v_index] = vertex;
    }

    public void add_edges(int index_u, int index_v){
        if(index_u>=0 && index_v<this.size){
            if(index_v>=0 && index_v<this.size)
                this.matrix[index_u][index_v] = 1;
        }
    }

    public void print_graph(){
        System.out.println("Vertex Data: ");
        for (int i=0; i < this.size; i++){
            System.out.printf("Vertex %d: %s\n", i,vertexData[i]);
        }

        System.out.println();

        System.out.println("Adjacency Matrix: ");
        for (int row=0; row < matrix.length; row++){
            for (int column=0; column < matrix[row].length; column++){
                System.out.print(matrix[row][column] + " ");
            }
        System.out.println();
        }
    }

    public boolean DFSUtil(int v, boolean[] visited, boolean[] recStack){
        visited[v] = true;
        recStack[v] = true;
        System.out.println("Current vertex: " + vertexData[v]);

        for (int i=0; i < this.size; i++){
            if(matrix[v][i] == 1){
                if(!visited[i]){
                    if (DFSUtil(i, visited, recStack)){
                        return true;
                    }
                }
                else if (recStack[i]){
                    return true;
                }
            }
        }
        recStack[v] = false;
        return false;
    }

    public boolean is_cyclic(){
        boolean[] visited = new boolean[size];
        boolean[] recStack = new boolean[size];

        for (int i=0; i < this.size; i++){
            if (!visited[i]){
                System.out.println();
                if(DFSUtil(i, visited, recStack))
                    return true;
            }
        }
        return false;
    }
}

public class Cycle_Detection_Directed_Graph_DFS {
    public static void main(String[]args){
        Graph_2 g = new Graph_2(7);

        g.add_vertices(0, 'A');
        g.add_vertices(1, 'B');
        g.add_vertices(2, 'C');
        g.add_vertices(3, 'D');
        g.add_vertices(4, 'E');
        g.add_vertices(5, 'F');
        g.add_vertices(6, 'G');

        g.add_edges(3, 0);
        g.add_edges(0, 2);
        g.add_edges(2, 4);
        g.add_edges(2, 1);
        g.add_edges(1, 5);
        g.add_edges(2, 6);
        g.add_edges(4, 0);

        g.print_graph();

        if(g.is_cyclic()){
            System.out.print("Is the graph cyclic? ");
            System.out.print("Yes");
        }
        else{
            System.out.print("Is the graph cyclic? ");
            System.out.print("No");
        }
    }
}
