class BFSGraph{
    private char[] vertexData;
    private int[][] matrix;
    private int size;

    public BFSGraph(int size){
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

    public void BFS(char start_vertex_data){
        boolean[] visited = new boolean[this.size];
        int[] queue = new int[this.size];
        int queue_start = 0;
        int queue_end = 0;

        int start_vertex = new String(vertexData).indexOf(start_vertex_data);
        queue[queue_end++] = start_vertex;
        visited[start_vertex] = true; // 'D' enqueued

        while (queue_start < queue_end){ // BFS starts at 'D' from here 
            int current_vertex = queue[queue_start++];
            System.out.print(vertexData[current_vertex] + " ");

            for (int i=0; i < this.size; i++){
                if (matrix[current_vertex][i] == 1 && !visited[i]){
                    queue[queue_end++] = i;
                    visited[i] = true;
                }
            }
        }
    }
}

public class Breadth_First_Search{
    public static void main(String[]args){
        BFSGraph g = new BFSGraph(7);

        g.addVertex(0, 'A'); //
        g.addVertex(1, 'B'); //
        g.addVertex(2, 'C'); //
        g.addVertex(3, 'D'); //
        g.addVertex(4, 'E'); //
        g.addVertex(5, 'F'); //
        g.addVertex(6, 'G'); //

        g.addEdges(0, 2);
        g.addEdges(0, 3);
        g.addEdges(0, 4);
        g.addEdges(2, 4);
        g.addEdges(2, 1);
        g.addEdges(2, 5);
        g.addEdges(2, 6);
        g.addEdges(1, 5);

        g.printGraph();

        System.out.println("Breadth First Search, starting from 'D'");
        g.BFS('D');
    }
}