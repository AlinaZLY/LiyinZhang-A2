import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ride {
    private String rideName;
    private int maxRider;
    private Employee rideOperator;
    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory;
    private int numOfCycles;

    public Ride() {
        
    }

    public Ride(String rideName, int maxRider, Employee rideOperator) {
        this.rideName = rideName;
        this.maxRider = maxRider;
        this.rideOperator = rideOperator;
        visitorQueue = new LinkedList<>();
        rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
    }

    public String getRideName() {
        return rideName;
    }
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getMaxRider() {
        return maxRider;
    }
    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
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

    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " has been added to the ride history for ride " + rideName);
    }

    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    public int numberOfVisitors() {
        return rideHistory.size();
    }

    public void printRideHistory() {
        System.out.println("Visitors who have taken the ride " + rideName + ":");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(visitor.getName() + " (ID: " + visitor.getVisitorId() + ", Member: " + visitor.isMember() + ", Age: " + visitor.getAge() + ")");
        }
    }

    public void sortRideHistory(VisitorComparator comparator) {
        Collections.sort(rideHistory, comparator);
    }

    public void RunOneCycle() {
        if (rideOperator == null) {
            System.out.println("Cannot run the ride. No ride operator assigned.");
            return;
        }

        if (visitorQueue.isEmpty()) {
            System.out.println("Cannot run the ride. No visitors in the queue.");
            return;
        }

        System.out.println("Running one cycle of the ride " + rideName + "...");
        int numVisitorsToTake = Math.min(maxRider, visitorQueue.size());
        
        for (int i = 0; i < numVisitorsToTake; i++) {
            Visitor visitor = visitorQueue.poll();
            rideHistory.add(visitor);
            System.out.println("Visitor " + visitor.getName() + " has been taken for the ride.");
        }

        numOfCycles++;
        System.out.println("Ride cycle completed. " + numVisitorsToTake + " visitors taken for the ride " + rideName + ".");
    }

    public void exportRideHistory(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getGender() + "," + visitor.getAge() + "," + visitor.getVisitorId() + "," + visitor.isMember());
                writer.newLine();
            }
            System.out.println("Ride history exported to the file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error occurred while exporting ride history to file: " + e.getMessage());
        }
    }

    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    public void importRideHistory(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] parts = line.split(",");
                Visitor visitor = new Visitor(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Boolean.parseBoolean(parts[4]));
                rideHistory.add(visitor);
            }
            System.out.println("Ride history imported from the file: " + fileName);
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.err.println("Error occurred while importing ride history from file: " + e.getMessage());
        }
    }

}
