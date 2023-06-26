package patterns.decorator;

public class NormalCabinSeat implements FlightSeat {

    private String type;
    private double price;

    public NormalCabinSeat(String type, double price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
