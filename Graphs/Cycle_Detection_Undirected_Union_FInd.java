class Graph_3{
    private char[] vertexData;
    private int[][] matrix;
    private int size;
    private int[] parent;

    public Graph_3(int size){
        this.size = size;
        this.matrix = new int[size][size];
        this.vertexData = new char[size];
        this.parent = new int[size];
        for(int i=0; i < this.size; i++){
            parent[i] = i;
        }
    }

    public void add_vertex(int v_index, char vertex){
        if(v_index>=0 && v_index<this.size){
            this.vertexData[v_index] = vertex;
        }
    }

    public void add_edges(int u, int v){
        if(u>=0 && u<this.size){
            if(v>=0 && v<this.size){
                this.matrix[u][v] = 1;
                this.matrix[v][u] = 1;
            }
        }
    }

    public void print_graph(){
        System.out.println("Vertex data: ");
        for(int i=0; i < this.size; i++){
            System.out.printf("Vertex %d: %s\n", i,vertexData[i]);
        }

        System.out.println();

        System.out.println("Adjacency matrix: ");
        for(int row=0; row < this.matrix.length; row++){
            for(int column=0; column < this.matrix[row].length; column++){
                System.out.print(matrix[row][column] + " ");
            }
        System.out.println();
        }
    }

    public int find(int i){
        if(parent[i] == i)
            return i;

        return find(parent[i]);
    }

    public void union(int x, int y){
        int xRoot = x;
        int yRoot = y;
        System.out.printf("Union: %s + %s\n", vertexData[x],vertexData[y]);
        parent[xRoot] = yRoot;
        System.out.println(java.util.Arrays.toString(parent) + "\n");
    }

    public boolean is_cyclic(){
        for (int i=0; i < this.size; i++){
            for(int j=i+1; j < this.size; j++){
                if(matrix[i][j] == 1){
                    int x = find(i);
                    int y = find(j);
                    if (x==y)
                        return true;
                    union (x,y);
                }
                
            }
        }
        return false;
    }
}

public class Cycle_Detection_Undirected_Union_FInd {
    public static void main(String[]args){
        Graph_3 g = new Graph_3(7);
        
        g.add_vertex(0, 'A');
        g.add_vertex(1, 'B');
        g.add_vertex(2, 'C');
        g.add_vertex(3, 'D');
        g.add_vertex(4, 'E');
        g.add_vertex(5, 'F');
        g.add_vertex(6, 'G');

        g.add_edges(0, 1);
        g.add_edges(0, 2);
        g.add_edges(0, 3);
        g.add_edges(2, 3);
        g.add_edges(3, 4);
        g.add_edges(3, 5);
        g.add_edges(3, 6);
        g.add_edges(4, 5);

        g.print_graph();

        System.out.println();
        if(g.is_cyclic()){
            System.out.print("Is the graph cyclic? ");
            System.out.println("Yes");
        }
        else{
            System.out.print("Is the graph cyclic? ");
            System.out.println("No");
        }
    }
}
