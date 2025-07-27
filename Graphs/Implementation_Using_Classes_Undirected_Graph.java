class undirectedGraph{
    private String[] vertex_data;    
    private int[][] adjacency_matrix;
    private int size;

    // Making empty variables size, matrix and vertices
    public undirectedGraph(int size){
        this.size = size;
        this.adjacency_matrix = new int[size][size];
        this.vertex_data = new String[size];
    }

    // Adding vertices
    public void addVertexData(int vertex_Index, String data){ // data: vertex name
        if (vertex_Index>=0 && vertex_Index<this.size)
            this.vertex_data[vertex_Index] = data;
    }

    // Adding edges ( 1 in case of undirected graph )
    public void addEdge(int index_u,int index_v){
        if (index_u>=0 && index_u<this.size){
            if (index_v>=0 && index_v<this.size){
                adjacency_matrix[index_u][index_v] = 1;
                adjacency_matrix[index_v][index_u] = 1;
            }
        }
    }

    // Printing the vertices and graph 
    public void printGraph(){
        System.out.println("Vertex Data: ");
        for(int i=0; i<vertex_data.length; i++){
            System.out.printf("Vertices %d: %s\n", i,vertex_data[i]);
        }

        System.out.println();

        System.out.println("Adjacency Matrix: ");
        for(int row=0; row < this.adjacency_matrix.length; row++){
            for(int column=0; column < adjacency_matrix[row].length; column++){
                System.out.print(adjacency_matrix[row][column] + " ");
            }
        System.out.println();
        }
    }
}

public class Implementation_Using_Classes_Undirected_Graph {
    public static void main(String[]args){
        undirectedGraph g = new undirectedGraph(4);

        g.addVertexData(0, "A");
        g.addVertexData(1, "B");
        g.addVertexData(2, "C");
        g.addVertexData(3, "D");
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 1);

        g.printGraph();
    }
}
