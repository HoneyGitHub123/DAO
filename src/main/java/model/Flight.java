package model;

import java.util.Date;

public class Flight {

    private int flightNo;
    private String flightName;
    private String depTime;
    private String arrivalTime;
    private String source;
    private String destination;
    private int seat;

    public Flight(int flightNo,String flightName,String depTime,String arrivalTime,String source,String destination,int seat){
        this.flightNo=flightNo;
        this.flightName=flightName;
        this.depTime=depTime;
        this.arrivalTime=arrivalTime;
        this.source=source;
        this.destination=destination;
        this.seat=seat;
    }
public Flight(){}

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return String.format("Flight[flightNo=%d,flightName=%s,depTime=%s,arrivalTime=%s,source=%s,destination=%s,seat=%d]", flightNo, flightName, depTime, arrivalTime, source, destination, seat);

    }
}