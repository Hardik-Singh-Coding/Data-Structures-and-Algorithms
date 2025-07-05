class dGraph{
    private char[] vertexData;
    private int[][] matrix;
    private int size;

    public dGraph(int size){
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

    // BFS  
    public void BFS(char start_vertex_data){
        boolean[] visited = new boolean[this.size];
        int[] queue = new int[this.size];
        int queue_start = 0;
        int queue_end = 0;
        
        int start_vertex = new String(vertexData).indexOf(start_vertex_data);
        queue[queue_end++] = start_vertex;
        visited[start_vertex] = true;
        
        while (queue_start < queue_end){
            int current_vertex = queue[queue_start++];
            System.out.print(vertexData[current_vertex] + " ");

            for (int i=0; i < this.size; i++){
                if(matrix[current_vertex][i] == 1 && !visited[i]){
                    queue[queue_end++] = i;
                    visited[i] = true;
                }
            }
        }
    }

    // DFS
    public void DFSUtil(int start, boolean[] visited){
        visited[start] = true;
        System.out.print(vertexData[start] + " ");

        for(int i=0; i < this.size; i++){
            if(this.matrix[start][i] == 1 && !visited[i])
                DFSUtil(i, visited);
        }
    }

    public void DFS(char start_vertex_data){
        boolean[] visited = new boolean[this.size];
        int start_vertex = new String(vertexData).indexOf(start_vertex_data);
        DFSUtil(start_vertex, visited);
    }
}

public class DFS_BFS_For_Directed_Graphs {
    public static void main(String[]args){
        dGraph g = new dGraph(7);

        g.addVertex(0, 'A');
        g.addVertex(1, 'B');
        g.addVertex(2, 'C');
        g.addVertex(3, 'D');
        g.addVertex(4, 'E');
        g.addVertex(5, 'F');
        g.addVertex(6, 'G');

        g.addEdges(3, 0);
        g.addEdges(3, 4);
        g.addEdges(4, 0);
        g.addEdges(0, 2);
        g.addEdges(2, 4);
        g.addEdges(2, 5);
        g.addEdges(2, 6);
        g.addEdges(5, 1);
        g.addEdges(1, 2);

        g.printGraph();

        System.out.println("Breadth First Search: ");
        g.BFS('D');

        System.out.println();

        System.out.println("Depth First Search: ");
        g.DFS('D');
    }
}