package db.model;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AirportMapper {

    static final String SELECT_BY_CODE = "SELECT airport_code,airport_name,city_name,state_name,country_code FROM airport WHERE airport_code=#{airportCode}";
    static final String DELETE = "DELETE FROM airport WHERE airport_code=#{airportCode}";
    static final String INSERT = "INSERT INTO airport(airport_code,airport_name,city_name,country_code,state_name) VALUES(#{airportCode},#{airportName},#{cityName},#{countryCode},#{stateName})";
    static final String UPDATE = "UPDATE airport SET airport_name=#{airportName} WHERE airport_code=#{airportCode}";


    @Select("Select * from airport")
    @Results(value = {
            @Result(property = "airportCode", column = "airport_code"),
            @Result(property = "airportName", column = "airport_name"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "countryCode", column = "country_code"),
            @Result(property = "stateName", column = "state_name")

    })
    List<Airport> selectAll();


    @Select(SELECT_BY_CODE)
    @Results(value = {
            @Result(property = "airportCode", column = "airport_code"),
            @Result(property = "airportName", column = "airport_name"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "countryCode", column = "country_code"),
            @Result(property = "stateName", column = "state_name")

    })
    Airport selectByCode(String airportCode);

    @Update(UPDATE)
    void update(Airport airport);

    @Delete(DELETE)
    int delete(String airportCode);

    @Insert(INSERT)
    @Options(useGeneratedKeys = true, keyProperty = "airportCode")
    int insert(Airport airport);

}
