class DFSGraph{
    private char[] vertexData;
    private int[][] matrix;
    private int size;

    public DFSGraph(int size){
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

    public void DFSUtil(int v, boolean[] visited){ // This is used to check the edges between the visited and not-visited vertices
        visited[v] = true;
        System.out.print(vertexData[v] + " ");

        for(int i=0; i < this.size; i++){ // Traverses through all the vertices
            if(this.matrix[v][i] == 1 && !visited[i]){ // Checks the edge and visited array
                DFSUtil(i, visited);
            }
        }
    }

    public void DFS(char startVertexData){ // Defines the visited array. Defines the starting vertex index
        boolean[] visited = new boolean[this.size];
        int startVertex = new String(vertexData).indexOf(startVertexData);
        DFSUtil(startVertex, visited);
    }
}

public class Depth_First_Search {
    public static void main(String[]args){
        DFSGraph g = new DFSGraph(8);

        g.addVertex(0, 'S');
        g.addVertex(1, 'A');
        g.addVertex(2, 'B');
        g.addVertex(3, 'C');
        g.addVertex(4, 'D');
        g.addVertex(5, 'E');
        g.addVertex(6, 'F');
        g.addVertex(7, 'G');

        g.addEdges(0, 1);
        g.addEdges(0, 2);
        g.addEdges(1, 3);
        g.addEdges(2, 3);
        g.addEdges(2, 4);
        g.addEdges(4, 6);
        g.addEdges(6, 7);
        g.addEdges(1, 5);
        g.addEdges(5, 6);
        g.addEdges(5, 7);

        g.printGraph();

        System.out.println("Depth First Search starting from vertex S: ");
        g.DFS('S');
    }
}
