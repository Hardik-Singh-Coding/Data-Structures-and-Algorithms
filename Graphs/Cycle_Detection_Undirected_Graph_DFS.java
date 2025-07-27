class Graph_1{
    private char[] vertexData;
    private int[][] matrix;
    private int size;

    public Graph_1(int size){
        this.size = size;
        this.matrix = new int[size][size];
        this.vertexData = new char[size];
    }

    public void addVertex(int vertex_index, char vertex){
        if (vertex_index>=0 && vertex_index<this.size)
            this.vertexData[vertex_index] = vertex;
    }

    public void addEdges(int index_u, int index_v){
        if (index_u>=0 && index_u<this.size){
            if(index_v>=0 && index_v<this.size){
                matrix[index_u][index_v] = 1;
                matrix[index_v][index_u] = 1;
            }
        }
    }

    public void printGraph(){
        System.out.println("Vertex data: ");
        for(int i=0; i < this.vertexData.length; i++){
            System.out.printf("Vertex %d: %s\n", i,vertexData[i]);
        }

        System.out.println();

        System.out.println("Adjacency Matrix: ");
        for(int row=0; row < this.matrix.length; row++){
            for(int column=0; column < this.matrix[row].length; column++){
                System.out.print(matrix[row][column] + " ");
            }
        System.out.println();
        }
    }

    public boolean DFSUtil(int v, boolean[] visited, int parent){
        visited[v] = true;

        for (int j=0; j < this.size; j++){
            if(matrix[v][j] == 1){
                if(!visited[j]){
                    if(DFSUtil(j, visited, v)){
                        return true;
                    }
                }
                else if (parent != j)
                    return true;
            }
        }
        return false;
    }

    public boolean is_cyclic(){
        boolean[] visited = new boolean[this.size];
        for (int i=0; i < this.size; i++){
            if (!visited[i]){
                if (DFSUtil(i,visited,-1)){
                    return true;
                }
            }
        }

        return false;
    }
}

public class Cycle_Detection_Undirected_Graph_DFS {
    public static void main(String[]args){
        Graph_1 g = new Graph_1(7);

        g.addVertex(0, 'A');
        g.addVertex(1, 'B');
        g.addVertex(2, 'C');
        g.addVertex(3, 'D');
        g.addVertex(4, 'E');
        g.addVertex(5, 'F');
        g.addVertex(6, 'G');

        g.addEdges(0, 2);
        g.addEdges(0, 3);
        g.addEdges(0, 4);
        // g.addEdges(2, 4);
        g.addEdges(2, 1);
        // g.addEdges(2, 5);
        g.addEdges(2, 6);
        g.addEdges(1, 5);

        g.printGraph();

        System.out.print("Is the graph cyclic? ");
        if(g.is_cyclic())
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
