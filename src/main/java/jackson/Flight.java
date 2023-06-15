package jackson;


import com.fasterxml.jackson.annotation.*;

//Used Json annotations
@JsonRootName(value="flight details")
@JsonPropertyOrder({"flight no", "flight name", "departure time", "arrival time", "source", "destination", "seat"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Flight {


    @JsonProperty("flight no")
    private int flightNo;

    @JsonProperty("flight name")
    private String flightName;

    @JsonProperty("departure time")
    private String depTime;

    @JsonProperty("arrival time")
    private String arrivalTime;

    @JsonProperty("source")
    private String source;

    @JsonProperty("destination")
    private String destination;

    @JsonProperty("seat")
    private int seat;

    public Flight(int flightNo, String flightName, String depTime, String arrivalTime, String source, String destination, int seat) {
        this.flightNo = flightNo;
        this.flightName = flightName;
        this.depTime = depTime;
        this.arrivalTime = arrivalTime;
        this.source = source;
        this.destination = destination;
        this.seat = seat;
    }

    public Flight() {
    }
    @JsonSetter
    public void FlightNo(int flightNo) {
        this.flightNo = flightNo;
    }
    @JsonGetter
    public int FlightNo() {
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
        return "Flight{" +
                "flightNo=" + flightNo + "," + "Flight Name=" + flightName + "," + "Departure=" + depTime + "," + "Arrival=" + arrivalTime + "," + "Source=" + source + "," + "Destination=" + destination + "," + "Seat=" + seat + '}';

    }
}