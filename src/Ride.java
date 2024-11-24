public class Ride {
    private String rideName;
    private int maxPassengers;
    private Employee rideOperator;

    public Ride() {
        
    }

    public Ride(String rideName, int maxPassengers, Employee rideOperator) {
        this.rideName = rideName;
        this.maxPassengers = maxPassengers;
        this.rideOperator = rideOperator;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public Employee getRideOperator() {
        return rideOperator;
    }

    public void setRideOperator(Employee rideOperator) {
        this.rideOperator = rideOperator;
    }
}