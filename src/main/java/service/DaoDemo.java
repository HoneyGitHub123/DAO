package service;

import model.Airline;
import model.Airport;
import model.Country;

import java.sql.SQLException;
import java.util.List;

public class DaoDemo {


    public static void main(String[] args) throws SQLException {
        CountryDao countryDao = new CountryDao();
        Country country1 = countryDao.findByCode(new Country("CA", "Canada"));
        System.out.println("select * from country where country_code=?");
        System.out.println(country1);

        List<Country> country2 = countryDao.findAll();
        System.out.println("select * from country");
        System.out.println(country2);
        System.out.println("Retrieve all records successfully");


        boolean insert = countryDao.insert(new Country("CH", "China"));
        System.out.println(insert);
        System.out.println("Inserted successfully");

        boolean update = countryDao.update(new Country("CH", "CHINA"));
        System.out.println(update);
        System.out.println("Updated successfully");


        boolean delete = countryDao.update(new Country("CH", "CHINA"));
        System.out.println(delete);
        System.out.println("Record deleted successfully");


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
        System.out.println("Inserted successfully");

        boolean update1 = airportDao.update(new Airport("PBI", "Palm Beach International Airport", "Palm Beach", "US", "Florida"));
        System.out.println(update1);
        System.out.println("Updated successfully");


        boolean delete1 = airportDao.delete(new Airport("PBI", "Palm Beach International Airport", "Palm Beach", "US", "Florida"));
        System.out.println(delete1);
        System.out.println("Record deleted successfully");


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
        System.out.println("Inserted successfully");

        boolean update2 = airlineDao.update(new Airline("Delta Airlines", "DAL"));
        System.out.println(update2);
        System.out.println("Updated successfully");


        boolean delete2 = airlineDao.delete(new Airline("Delta Airlines", "DAL"));
        System.out.println(delete2);
        System.out.println("Record deleted successfully");


    }


}
