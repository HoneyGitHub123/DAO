package patterns.decorator;

public class Main {

    public static void main(String[] args) {

        //Create normal seat
        FlightSeat cabinSeat = new NormalCabinSeat("EconomySeat", 800);

        //Create seat with Wi-Fi
        FlightSeat wifiFacility = new WiFiSeat(cabinSeat, 100);

        //Display normal seat details
        System.out.println("Normal Seat details");
        System.out.println("-----------------------");
        System.out.println("Seat Type:" + cabinSeat.getType());
        System.out.println("Seat Price in $ :" + cabinSeat.getPrice());

        //Display seat with additional facilities
        System.out.println("Seat with additional Facilities");
        System.out.println("-----------------------");
        System.out.println("Seat Type:" + wifiFacility.getType());
        System.out.println("Seat Price in $:" + wifiFacility.getPrice());


    }
}
