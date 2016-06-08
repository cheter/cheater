package Task.TaskTwo;

/**
 * Created by Cheter on 07.06.2016.
 */
import Task.TaskTwo.Matrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader  Strim = new BufferedReader(new FileReader("D:\\input.txt"));
        String line = Strim.readLine();
        int source = Integer.parseInt(line);
        for (int testIndex=0; testIndex<source; testIndex++){// the number of tests(кол-во тестов)
            String [] citiesIds = new String[10000];// create an array of the condition(создаем массив состояний городов)
            line = Strim.readLine();
            int CountCities = Integer.parseInt(line);// read the number of cities(считывает кол-во городов)
            int matrixSize = CountCities+1;
            Matrix g = new Matrix (matrixSize);
            for (int CityIndex=0; CityIndex < CountCities; CityIndex++){
                line = Strim.readLine();// reads the name of the city(считывает название города)
                String CityName = line;
                citiesIds[CityIndex] = CityName;// write the name of the city(записывает имя города)
                line = Strim.readLine();// read the next value (the number of neighbors)(считывает след.значение(номер соседа))
                int p = Integer.parseInt(line);
                for (int neighborIndex = 0; neighborIndex < p; neighborIndex++){
                    line = Strim.readLine();
                    String [] brokenLine = line.split(" ");
                    int cityToConnect = Integer.parseInt(brokenLine[0]);// Write the code neighbor(записывает код соседа)
                    int weightOfConnection = Integer.parseInt(brokenLine[1]);// write the weight of the edge(записыывает цену поездки)
                    g.setEdge(CityIndex,cityToConnect, weightOfConnection);
                }
            }

            line = Strim.readLine();
            int routesToFind = Integer.parseInt(line);// number of calculated routes(номер высчитываемой поездки(пути))
            for (int routesIndex=0; routesIndex<routesToFind; routesIndex++){
                line = Strim.readLine();// reads the path(считывает путь)
                String [] cityNames = line.split(" ");
                String start = cityNames[0];
                String destination = cityNames[1];
                List<String> list = new ArrayList<String>();
                for(String s : citiesIds) {// remove the null elements from the array before writing to the list(убирает все null элементы из массива перед записью в список)
                    if(s != null) {
                        list.add(s);
                    }
                }
                citiesIds = list.toArray(new String[list.size()]);
                int startIndex = 0;
                int destinationIndex = 0;
                for (int i = 0; i < citiesIds.length; i++) {  // find the index of the initial city(находит индекс первоначального(стартового) города)
                    if(start.equals(citiesIds[i])){
                        startIndex=i; break;
                    }
                }
                for (int i = 0; i < citiesIds.length; i++) {  // find the index of the end of the city(находит индекс конечного города)
                    if(destination.equals(citiesIds[i])){
                        destinationIndex=i;break;
                    }
                }
                Integer[] distancesFromSource = g.distancesFrom(startIndex);
                int destinationDistance = distancesFromSource[destinationIndex];
                System.out.println(destinationDistance);
            }

        }
        Strim.close();
    }


}