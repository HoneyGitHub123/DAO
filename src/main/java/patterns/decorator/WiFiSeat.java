package patterns.decorator;

public class WiFiSeat extends FlightSeatDecorator {

    private double additionalCharge;

    public WiFiSeat(FlightSeat decoratedSeat, double additionalCharge) {
        super(decoratedSeat);
        this.additionalCharge = additionalCharge;

    }

    @Override
    public String getType() {
        return (decoratedSeat.getType()) + "" + "with WIFI";
    }

    @Override
    public double getPrice() {
        double additionalPrice = decoratedSeat.getPrice() + additionalCharge;
        return additionalPrice;
    }
}
