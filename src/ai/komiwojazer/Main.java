package ai.komiwojazer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader reader = getBufferedReader(main);

        int numbersOfCitiesFromTopOfTheFile = Integer.valueOf(reader.readLine());

        List<CityLocalisation> citiesToVisit = prepareCityLocalisations(reader);

        NearestNeighbourAlgorithmGreedy nearestNeighbourAlgorithmGreedy = new NearestNeighbourAlgorithmGreedy();
        nearestNeighbourAlgorithmGreedy.algorythm(10, citiesToVisit);

        //Przetasowanie listy z punktami
        //Collections.shuffle(citiesToVisit);

        //swapStartCityAndDestinationCity(citiesToVisit, new ArrayList<>(), numbersOfCitiesFromTopOfTheFile);

    }



    public int getDistance(List<CityLocalisation> citiesToVisit, List<CityLocalisation> travel) {
        int distance = 0;
//        for (int index = 0; index < travel.size(); index++) {
//            CityLocalisation starting = getCity(index);
//            CityLocalisation destination;
//            if (index + 1 < travel.size()) {
//                destination = getCity(index + 1);
//            } else {
//                destination = getCity(0);
//            }
//            distance += starting.distanceToCity(destination);
//        }
        return distance;
    }


    public static void swapStartCityAndDestinationCity(List<CityLocalisation> citiesToVisit, List<CityLocalisation> travel, int numberOfPoints) {
        int startCityIndex = generateRandomIndex(numberOfPoints);
        int destinationCityIndex = generateRandomIndex(numberOfPoints);
//        previousTravel = travel;
        CityLocalisation startCity = citiesToVisit.get(startCityIndex);
        CityLocalisation endCity = citiesToVisit.get(destinationCityIndex);
        travel.set(startCityIndex, endCity);
        travel.set(destinationCityIndex, startCity);
    }

    private static int generateRandomIndex(int numberOfPoints) {
        double randomDouble = Math.random();
        randomDouble = randomDouble * numberOfPoints + 1;
        return (int) randomDouble;
    }

    private static List<CityLocalisation> prepareCityLocalisations(BufferedReader reader) throws IOException {
        List<CityLocalisation> citiesToVisit = new ArrayList<>();
        while(reader.ready()) {
            String line = reader.readLine();
            citiesToVisit.add(prepareCitiCoordinates(line));
        }
        return citiesToVisit;
    }

    private static CityLocalisation prepareCitiCoordinates(String line) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(line);
        m.find();
        int x = Integer.valueOf(m.group());
        m.find();
        int y = Integer.valueOf(m.group());
        return new CityLocalisation(x,y);
    }

    private static BufferedReader getBufferedReader(Main main) {
        InputStream fileName = main.getResourceAsStream();
        InputStreamReader inputStreamReader = new InputStreamReader(fileName);
        return new BufferedReader(inputStreamReader);
    }

    private InputStream getResourceAsStream() {
        return getClass().getResourceAsStream("miasta.txt");
    }
}
