package practice.graph;

public class FloydWarshall {
	final static int INF = 99999, V = 4; 

	// Driver program to test above function 
    public static void main (String[] args) 
    { 
        /* Let us create the following weighted graph 
           10 
        (0)------->(3) 
        |         /|\ 
        5 |          | 
        |          | 1 
        \|/         | 
        (1)------->(2) 
           3           */
        int graph[][] = { {0,   5,  INF, 10}, 
                          {INF, 0,   3, INF}, 
                          {INF, INF, 0,   1}, 
                          {INF, INF, INF, 0} 
                        }; 
        FloydWarshall a = new FloydWarshall(); 
  
        // Print the solution 
        a.floydWarshall(graph); 
    } 

}
