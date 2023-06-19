package db.model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//Using XML Mapping

public class MyBatisAirlineRunner {
    public static void main(String[] args) throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
       SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession();
        //AirlineMapper mapper=session.getMapper(AirlineMapper.class);
        //Airline airline1=mapper.selectAirlineByCode("AAL");
        Airline airline1 = session.selectOne("resources.AirlineMapper.selectAirlineBycode", "AAL");
        System.out.println("Select Operation");
        System.out.println("====================");
        System.out.println();
        System.out.println(airline1);
        System.out.println("Insert Operation");
        System.out.println("====================");
        System.out.println();
        Airline airline3 = new Airline("Air India Express", "AXB");
        int updatedRows = session.insert("resources.AirlineMapper.insert", airline3);
        session.commit();
        System.out.println("Number of rows updated:" + updatedRows);
        System.out.println("SelectAll Operation");
        System.out.println("====================");
        System.out.println();
        List<Airline> airline2 = session.selectList("resources.AirlineMapper.selectAll");
        session.commit();
        System.out.println(airline2);
        System.out.println("Update Operation");
        System.out.println("====================");
        System.out.println();
        Airline airline4 = new Airline();
        airline4.setAirlineName("AirIndiaExpress");
        airline4.setAirlineCode("AXB");
        int updatedRows1 = session.update("resources.AirlineMapper.update", airline4);
        System.out.println("Number of rows updated:" + updatedRows1);
        session.commit();
        System.out.println("Delete Operation");
        System.out.println("====================");
        System.out.println();
        int updatedRows2 = session.update("resources.AirlineMapper.delete", "AXB");
        System.out.println("Number of rows deleted:" + updatedRows2);
        session.commit();


    }
}