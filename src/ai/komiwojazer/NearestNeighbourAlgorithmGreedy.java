package ai.komiwojazer;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;

public class NearestNeighbourAlgorithmGreedy {

    public void algorythm(int numberOfNodes, List<CityLocalisation> citiesToVisit) {
        System.out.println("Number of nodes in the graph = " + numberOfNodes);
        System.out.println();
        int[][] adjacency_matrix = prepareAdjacencyMatrix(numberOfNodes, citiesToVisit);
        System.out.println();
        System.out.println("The cities will be visited as follows: ");
        tsp(numberOfNodes, adjacency_matrix);
    }

    private int[][] prepareAdjacencyMatrix(int numberOfNodes, List<CityLocalisation> citiesToVisit) {
        int adjacencyMatrix[][] = new int[numberOfNodes + 1][numberOfNodes + 1];
        for (int i = 1; i <= numberOfNodes - 1; i++) {
            for (int j = 1; j <= numberOfNodes - 1; j++) {
                adjacencyMatrix[i][j] = citiesToVisit.get(i).distanceBetweenCities(citiesToVisit.get(j));
// Uncoment this if You want to see matrix
//                if(adjacencyMatrix[i][j] == 0) {
//                    System.out.print("000 ");
//                } else
//                System.out.print(adjacencyMatrix[i][j]+ " ");
            }
//            System.out.println();
        }
        return adjacencyMatrix;
    }

    public void tsp(int numberOfNodes, int[][] adjacencyMatrix) {
        int[] visitedCities = new int[numberOfNodes];
        visitedCities[1] = 1; //because we are starting from [0][1] so this is 2 element

        System.out.println();
        System.out.print(1 + "\t");

        List<Integer> travelIndex = new ArrayList<>();
        travelIndex.add(1); //Starting travel index

        for (int matrixRowIndex = 0; matrixRowIndex < numberOfNodes-2; matrixRowIndex++) {
            int lastIndexFromTravelList = travelIndex.get(matrixRowIndex);
            int min = MAX_VALUE;
            int closestCityIndex = 0;

            //search for closest city
            for (int matrixColumnIndex = 1; matrixColumnIndex < numberOfNodes; matrixColumnIndex++) {
                if (adjacencyMatrix[lastIndexFromTravelList][matrixColumnIndex] > 1 && visitedCities[matrixColumnIndex] == 0) {
                    if (min > adjacencyMatrix[lastIndexFromTravelList][matrixColumnIndex]) {
                        min = adjacencyMatrix[lastIndexFromTravelList][matrixColumnIndex];
                        closestCityIndex = matrixColumnIndex;
                    }
                }
            }
            visitedCities[closestCityIndex] = 1;
            travelIndex.add(closestCityIndex);
            System.out.print(closestCityIndex + "\t");
        }
    }
}
