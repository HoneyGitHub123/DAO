package patterns.builders;

public class Main {

    public static void main(String[] args) {
        Passenger passenger = new Passenger.PassengerBuilder()
                .setPassengerID(109)
                .setPassengerName("Arun Thomas")
                .setMobileNum("645654321")
                .setAge(33)
                .setDob("1990-09-20")
                .setAddress("Tropical Drive")
                .setCity("Tampa")
                .setCountryCode("US")
                .build();

        System.out.println("Passenger ID:" + passenger.getPassengerID());
        System.out.println("Passenger Name:" + passenger.getPassengerName());
        System.out.println("Age:" + passenger.getAge());
        System.out.println("Mobile Number:" + passenger.getMobileNum());
        System.out.println("DOB:" + passenger.getDob());
        System.out.println("Address:" + passenger.getAddress());
        System.out.println("City:" + passenger.getCity());
        System.out.println("State:" + passenger.getState());
        System.out.println("Country :" + passenger.getCountryCode());

    }
}
