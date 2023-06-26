package patterns.facade;

public class Main {

    public static void main(String[] args) {
        //Create AirlineFacade object to access airline details
        AirlineFacade airlineFacade = new AirlineFacade("Qatar Airlines", "QAR");
        String airlineDetails = airlineFacade.getAirlineInfo();
        System.out.println(airlineDetails);
    }
}
