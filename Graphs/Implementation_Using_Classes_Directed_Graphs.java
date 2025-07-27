class directedGraph{
    private String[] vertexData;
    private int[][] adjacencyMatrix;
    private int size;

    public directedGraph(int size){
        this.size = size;
        this.vertexData = new String[size];
        this.adjacencyMatrix = new int[size][size];
    }

    public void addVertices(int vertex_index, String vertex_name){
        if (vertex_index>=0 && vertex_index<this.size)
            this.vertexData[vertex_index] = vertex_name;
    }

    public void adEdges(int index_u, int index_v, int weight){
        if (index_u>=0 && index_u<this.size){
            if (index_v>=0 && index_v<this.size){
                this.adjacencyMatrix[index_u][index_v] = weight;
            }
        }
    }

    public void prinGraph(){
        // Printing vertices
        System.out.println("Vertex Data: ");
        for(int i=0; i<this.vertexData.length; i++){
            System.out.printf("Vertex %d: %s\n", i,vertexData[i]);
        }

        System.out.println();

        // Printing matrix
        System.out.println("Adjacency matrix: ");
        for(int row=0; row < this.adjacencyMatrix.length; row++){
            for(int column=0; column < this.adjacencyMatrix[row].length; column++){
                System.out.print(this.adjacencyMatrix[row][column] + " ");
            }
        System.out.println();
        }
    }
}

public class Implementation_Using_Classes_Directed_Graphs {
    public static void main(String[]args){
        directedGraph g = new directedGraph(4);

        g.addVertices(0, "A");
        g.addVertices(1, "B");
        g.addVertices(2, "C");
        g.addVertices(3, "D");

        g.adEdges(0, 1, 3);
        g.adEdges(0, 2, 2);
        g.adEdges(2, 1, 1);
        g.adEdges(3, 0, 4);

        g.prinGraph();
    }
}
