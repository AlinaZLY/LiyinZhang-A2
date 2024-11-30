import java.util.LinkedList;
import java.util.Queue;

public class Ride {
    private String rideName;
    private int maxPassengers;
    private Employee rideOperator;
    private Queue<Visitor> visitorQueue;


    public Ride() {
        
    }

    public Ride(String rideName, int maxPassengers, Employee rideOperator) {
        this.rideName = rideName;
        this.maxPassengers = maxPassengers;
        this.rideOperator = rideOperator;
        visitorQueue = new LinkedList<>();
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
    
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.add(visitor);
        System.out.println(visitor.getName() + " has been added to the queue for ride " + rideName);
    }
    
    public void removeVisitorFromQueue() {
        Visitor visitor = visitorQueue.poll();
        if (visitor != null) {
            System.out.println(visitor.getName() + " has been removed from the queue for ride " + rideName);
        } else {
            System.out.println("Queue is empty. No visitor to remove.");
        }
    }
    
    public void printQueue() {
        System.out.println("Visitors in the queue for ride " + rideName + ":");
        for (Visitor visitor : visitorQueue) {
            System.out.println(visitor.getName() + " (ID: " + visitor.getVisitorId() + ", Member: " + visitor.isMember() + ") - Age: " + visitor.getAge());
        }
    }
}