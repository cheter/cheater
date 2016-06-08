package Task.TaskTwo;

/**
 * Created by Cheter on 07.06.2016.
 */
class Matrix {
    public int[][] Cost;// An array that contains the value of the ribs(массив содержит значение цены)

    /* Argument is the number of vertices in the graph (номер вертикалей в матрице)*/
    public Matrix(int vertices){

        Cost = new int [vertices][vertices];
    }
    /* Set the weight between the neighbors (утановка цены между соседями)*/
    public void setEdge (int i, int j, int weight){
        Cost [i][j] = weight;
    }
    /* Returns 0 if I and J are the same, a large number of returns if there is no connection between the tops of the ribs or weight(возвращаем 0 если I i J одинаковые, большее число возвр если нет соеденений между вершинами)) */
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
      ignoring those in visited.(возвращаем индекс мин.дистации эл-та , игнорируем те которые уже были)*/
    protected int cheapest (Integer[] result, boolean [] visited){
        int best =-1;
        for (int i=0; i<Cost.length; i++){
            if (!visited[i]&&((best<0)||(result[i] < result[best]))) {
                best =i;
            }
        }
        return best;
    }

    /*Return an array of the distances from source to each other vertex(возвращает массив растояний между источником и каждой вершиной)*/
    public Integer[] distancesFrom (int source){
        Integer[] result = new Integer[Cost.length];
        java.util.Arrays.fill(result,10001);// Set tops mark(устанавливаем наибольшую отметку)
        result [source]=source;//Assign 1st top mark equal to "source"(присваевает первую найбольшую отметку равную "переменной(источнику)"
        boolean []visited = new boolean [Cost.length];// visit the city(посещение города)
        for (int i =0; i<Cost.length;i++){
            int City = cheapest (result,visited);// Select the top of which has a minimum mark(определение вершины с мин. значением)
            visited [City]=true;// Marking visited vertex(отмечаем посещенную вершину(город))
            for (int j =0; j<Cost.length;j++){
                result [j] = Math.min(result[j], result[City]+getCost(City,j));// Write the smallest cost from one vertex to another(записываем наименьшую цену от 1-й вершине к другой)
            }
        }
        return result;
    }
}
