package Task.TaskTwo;

/**
 * Created by Cheter on 07.06.2016.
 */
class Matrix {
    public int[][] Cost;// An array that contains the value of the ribs

    /* Argument is the number of vertices in the graph */
    public Matrix(int vertices){

        Cost = new int [vertices][vertices];
    }
    /* Set the weight between the neighbors */
    public void setEdge (int i, int j, int weight){
        Cost [i][j] = weight;
    }
    /* Returns 0 if I and J are the same, a large number of returns if there is no connection between the tops of the ribs or weight*/
    public int getCost(int i , int j){
/* [0, 1, 3, 0]
 * [1, 0, 1, 4]
 * [3, 1, 0, 1]
 * [0, 4, 1, 0]*/
        if (i==j){
            return 0;
        }
        if (Cost[i][j]==0){
            return 10001;
        }
        return Cost[i][j];
    }

    /*Return the index of the smallest element of distances,
      ignoring those in visited.*/
    protected int cheapest (Integer[] result, boolean [] visited){
        int best =-1;
        for (int i=0; i<Cost.length; i++){
            if (!visited[i]&&((best<0)||(result[i] < result[best]))) {
                best =i;
            }
        }
        return best;
    }

    /*Return an array of the distances from source to each other vertex*/
    public Integer[] distancesFrom (int source){
        Integer[] result = new Integer[Cost.length];
        java.util.Arrays.fill(result,10001);// Set tops mark
        result [source]=source;//Assign 1st top mark equal to "source"
        boolean []visited = new boolean [Cost.length];// visit the city
        for (int i =0; i<Cost.length;i++){
            int City = cheapest (result,visited);// Select the top of which has a minimum mark
            visited [City]=true;// Marking visited vertex
            for (int j =0; j<Cost.length;j++){
                result [j] = Math.min(result[j], result[City]+getCost(City,j));// Write the smallest cost from one vertex to another
            }
        }
        return result;
    }
}
