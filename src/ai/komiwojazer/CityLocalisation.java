package ai.komiwojazer;

public class CityLocalisation {
    //punkty na kartezjanskim ukladzie wspolzednych
    int x;
    int y;
//    int distanceToActual;
//    boolean visited;
//    boolean actual;
//
    public CityLocalisation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Wzor na odleglosc miedzy punktami http://matematyka.pisz.pl/strona/1248.html
    //ta metoda odpowiada za modelowanie podrozy komiwojazera
    public int distanceBetweenCities(CityLocalisation cityLocalisation) {
        int x = Math.abs(this.x - cityLocalisation.x);
        int y = Math.abs(this.y - cityLocalisation.y);
        return (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
