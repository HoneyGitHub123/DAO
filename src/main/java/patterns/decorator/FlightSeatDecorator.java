package patterns.decorator;

public abstract class FlightSeatDecorator implements FlightSeat {

    protected FlightSeat decoratedSeat;

    public FlightSeatDecorator(FlightSeat decoratedSeat) {
        this.decoratedSeat = decoratedSeat;
    }

    @Override
    public String getType() {
        return decoratedSeat.getType();
    }

    @Override
    public double getPrice() {
        return decoratedSeat.getPrice();
    }

}
