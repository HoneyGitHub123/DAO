package db.model;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AirportMapper {

    final String selectAll = "Select * from airport";
    final String selectByCode = "Select airport_code,airport_name,city_name,state_name,country_code from airport where airport_code=#{airportCode}";
    final String delete = "Delete from airport where airport_code=#{airportCode}";
    final String insert = "Insert into airport(airport_code,airport_name,city_name,country_code,state_name) values(#{airportCode},#{airportName},#{cityName},#{countryCode},#{stateName})";
    final String update = "update airport set airport_name=#{airportName} where airport_code=#{airportCode}";


    @Select(selectAll)
    @Results(value = {
            @Result(property = "airportCode", column = "airport_code"),
            @Result(property = "airportName", column = "airport_name"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "countryCode", column = "country_code"),
            @Result(property = "stateName", column = "state_name")

    })
    List<Airport> selectAll();


    @Select(selectByCode)
    @Results(value = {
            @Result(property = "airportCode", column = "airport_code"),
            @Result(property = "airportName", column = "airport_name"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "countryCode", column = "country_code"),
            @Result(property = "stateName", column = "state_name")

    })
    Airport selectByCode(String airportCode);

    @Update(update)
    void update(Airport airport);

    @Delete(delete)
    int delete(String airportCode);

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "airportCode")
    int insert(Airport airport);

}
