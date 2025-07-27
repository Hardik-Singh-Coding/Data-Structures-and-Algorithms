import java.util.Arrays;

public class Adjacency_Matrix {
    static void printAdjacencyMatrix(int[][] matrix){
        System.out.println("Adjacency Matrix: ");
        for(int row=0; row < matrix.length; row++){
            for(int column=0; column < matrix[row].length; column++){
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    static void print_connections(int[][] matrix, char[] vertices){
        System.out.println("Connections for each vertex: ");
        for(int i=0; i < matrix.length; i++){
            System.out.print(vertices[i] + ": ");
            for(int j=0; j < matrix.length; j++){
                if (matrix[i][j] == 1){
                    System.out.print(vertices[j] +  " ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[]args){
        char[] vertexData = {'A', 'B', 'C', 'D'};
        int[][] adjacency_matrix = {
            {0,1,1,1}, // Edges for A
            {1,0,1,0}, // Edges for B
            {1,1,0,0}, // Edges for C
            {1,0,0,0} // Edges for D
        };

        System.out.printf("Vertex data: %s \n", Arrays.toString(vertexData));
        printAdjacencyMatrix(adjacency_matrix);
        print_connections(adjacency_matrix, vertexData);
    }
}
