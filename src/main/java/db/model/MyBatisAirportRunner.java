package db.model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
//Using Interface mapping
public class MyBatisAirportRunner {

    public static void main(String[] args) throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession();
        AirportMapper mapper = session.getMapper(AirportMapper.class);
        Airport airport = mapper.selectByCode("ONT");
        System.out.println("Select Operation");
        System.out.println("====================");
        System.out.println();
        System.out.println(airport);
        System.out.println("SelectAll Operation");
        System.out.println("====================");
        System.out.println();
        List<Airport> airport1 = mapper.selectAll();
        System.out.println(airport1);
        System.out.println("Insert Operation");
        System.out.println("====================");
        System.out.println();
        Airport airport2 = new Airport("LAX", "Los Angeles International Airport", "Los Angeles", "US", "California");
        int rowsUpdated = mapper.insert(airport2);
        System.out.println("Number of rows inserted:" + rowsUpdated);
        session.commit();
        System.out.println("Delete Operation");
        System.out.println("====================");
        System.out.println();
        int rowsUpdated1 = mapper.delete("LAX");
        System.out.println("Number of rows deleted:" + rowsUpdated1);
        session.commit();


    }
}