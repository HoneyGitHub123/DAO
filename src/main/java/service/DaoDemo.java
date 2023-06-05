package service;

import model.*;

import java.sql.SQLException;
import java.util.List;

public class DaoDemo {


    public static void main(String[] args) throws SQLException {

        System.out.println("CRUD operations for Country Table");
        System.out.println("******************************************");
        System.out.println();
        CountryDao countryDao = new CountryDao();
        Country country1 = countryDao.findByCode(new Country("CA", "Canada"));
        System.out.println("select * from country where country_code=?");
        System.out.println(country1);

        List<Country> country2 = countryDao.findAll();
        System.out.println("select * from country");
        System.out.println(country2);
        System.out.println("Retrieve all records successfully");


        boolean insert = countryDao.insert(new Country("IN", "INDIA"));
        System.out.println(insert);
        if (insert == true) {
            System.out.println("Inserted successfully");
        }

        boolean update = countryDao.update(new Country("IN", "India"));
        System.out.println(update);
        if (update == true) {
            System.out.println("Updated successfully");
        }


        boolean delete = countryDao.delete(new Country("IN", "India"));
        System.out.println(delete);
        if (delete == true) {
            System.out.println("Record deleted successfully");
        }

        System.out.println("CRUD operations for Airport Table");
        System.out.println("******************************************");
        System.out.println();
        AirportDao airportDao = new AirportDao();
        Airport airport1 = airportDao.findByCode(new Airport("LAX", "Los Angeles International Airport", "Los Angeles", "US", "California"));
        System.out.println("select * from airport where airport_code=?");
        System.out.println(airport1);

        List<Airport> airport2 = airportDao.findAll();
        System.out.println("select * from airport");
        System.out.println(airport2);
        System.out.println("Retrieve all records successfully");


        boolean insert1 = airportDao.insert(new Airport("PBI", "PALM Beach International Airport", "Palm Beach", "US", "Florida"));
        System.out.println(insert1);
        if (insert1 == true) {
            System.out.println("Inserted successfully");
        }

        boolean update1 = airportDao.update(new Airport("PBI", "Palm Beach International Airport", "Palm Beach", "US", "Florida"));
        System.out.println(update1);
        if (update1 == true) {
            System.out.println("Updated successfully");
        }


        boolean delete1 = airportDao.delete(new Airport("PBI", "Palm Beach International Airport", "Palm Beach", "US", "Florida"));
        System.out.println(delete1);
        if (delete1 == true) {

            System.out.println("Record deleted successfully");

        }

        System.out.println("CRUD operations for Airline Table");
        System.out.println("******************************************");
        System.out.println();

        AirlineDao airlineDao = new AirlineDao();
        Airline airline = airlineDao.findByCode(new Airline("American Airlines", "AAL"));
        System.out.println("select * from airline where airline_code=?");
        System.out.println(airline);

        List<Airline> airline1 = airlineDao.findAll();
        System.out.println("select * from airline");
        System.out.println(airline1);
        System.out.println("Retrieve all records successfully");


        boolean insert2 = airlineDao.insert(new Airline("Delta Airlines", "DAL"));
        System.out.println(insert2);
        if (insert2 == true) {
            System.out.println("Inserted successfully");
        }

        boolean update2 = airlineDao.update(new Airline("Delta Airlines", "DAL"));
        System.out.println(update2);
        if (update2 == true) {
            System.out.println("Updated successfully");
        }


        boolean delete2 = airlineDao.delete(new Airline("Delta Airlines", "DAL"));
        System.out.println(delete2);
        if (delete2 == true) {

            System.out.println("Record deleted successfully");

        }

        System.out.println("CRUD operations for Passenger Table");
        System.out.println("******************************************");
        System.out.println();

        PassengerDao passengerDao = new PassengerDao();
        Passenger passenger = passengerDao.findById(new Passenger(100, "Maria John", "6754327892", 35, "1989-05-23", "109 park victoria", "West Covina", "California", "US"));
        System.out.println("select * from passenger where passenger_id=?");
        System.out.println(passenger);

        List<Passenger> passenger1 = passengerDao.findAll();
        System.out.println("select * from Passenger");
        System.out.println(passenger1);
        System.out.println("Retrieve all records successfully");


        boolean insert3 = passengerDao.insert(new Passenger(105, "Alex Mathew", "6754007892", 25, "1998-05-23", "1C29 snow creek", "Denver", "Colorado", "US"));
        System.out.println(insert3);
        if (insert3 == true) {

            System.out.println("Inserted successfully");
        }

        boolean update3 = passengerDao.update(new Passenger(105, "Alex John Mathew", "6754007892", 25, "1998-05-23", "1C29 snow creek", "Denver", "Colorado", "US"));
        System.out.println(update3);
        if (update3 == true) {
            System.out.println("Updated successfully");
        }


        boolean delete3 = passengerDao.delete(new Passenger(105, "Alex Mathew", "6754007892", 25, "1998-05-23", "1C29 snow creek", "Denver", "Colorado", "US"));
        System.out.println(delete3);
        if (delete3 == true) {

            System.out.println("Record deleted successfully");

        }

        FlightDao flightDao = new FlightDao();
        Flight flight = flightDao.findByNum(new Flight(300,"Alaskan Airlines","2023-06-12 13:00:00","2023-06-12 14:00:00","Los Angeles","Oregon",330));
        System.out.println("select * from flight where flight_no=?");
        System.out.println(flight);
    }


}
