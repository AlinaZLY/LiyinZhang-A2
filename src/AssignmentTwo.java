import java.util.LinkedList;

public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    public void partThree(){
        Employee rideOperator1 = new Employee("John", "Male", 30, "001", "Operator");
        Ride ride1 = new Ride("Roller Coaster", 2, rideOperator1);

        Visitor visitor1 = new Visitor("Nehemia", "Female", 25, 1001, true);
        Visitor visitor2 = new Visitor("Jason", "Male", 30, 1002, false);
        Visitor visitor3 = new Visitor("Jack", "Male", 22, 1003, true);
        Visitor visitor4 = new Visitor("Sharon", "Female", 27, 1004, false);
        Visitor visitor5 = new Visitor("Benny", "Male", 35, 1005, true);
        Visitor visitor6 = new Visitor("Leo", "Male", 17, 1006, false);

        ride1.addVisitorToQueue(visitor1);
        ride1.addVisitorToQueue(visitor2);
        ride1.addVisitorToQueue(visitor3);
        ride1.addVisitorToQueue(visitor4);
        ride1.addVisitorToQueue(visitor5);
        ride1.addVisitorToQueue(visitor6);

        ride1.removeVisitorFromQueue();

        ride1.printQueue();
    }

    public void partFourA(){
        Employee rideOperator2 = new Employee("Billy", "Male", 21, "002", "Manager");
        Ride ride2 = new Ride("Thunderstorm", 4, rideOperator2);
        
        Visitor visitor1 = new Visitor("Tom", "Male", 25, 2001, true);
        Visitor visitor2 = new Visitor("Sherly", "Female", 30, 2002, false);
        Visitor visitor3 = new Visitor("Ben", "Male", 22, 2003, true);
        Visitor visitor4 = new Visitor("David", "Male", 27, 2004, false);
        Visitor visitor5 = new Visitor("Jack", "Male", 35, 2005, true);

        ride2.addVisitorToHistory(visitor1);
        ride2.addVisitorToHistory(visitor2);
        ride2.addVisitorToHistory(visitor3);
        ride2.addVisitorToHistory(visitor4);
        ride2.addVisitorToHistory(visitor5);

        Visitor visitorToCheck = new Visitor("Lee", "Male", 40, 2006, true);
        boolean isVisitorInHistory = ride2.checkVisitorFromHistory(visitorToCheck);
        System.out.println("Is " + visitorToCheck.getName() + " in the ride history? " + isVisitorInHistory);
        System.out.println("Number of visitors in the ride history: " + ride2.numberOfVisitors());

        ride2.printRideHistory();
    }

    public void partFourB(){
        Employee rideOperator2 = new Employee("Billy", "Male", 21, "002", "Manager");
        Ride ride2 = new Ride("Thunderstorm", 4, rideOperator2);

        Visitor visitor1 = new Visitor("Tom", "Male", 25, 2001, true);
        Visitor visitor2 = new Visitor("Sherly", "Female", 30, 2002, false);
        Visitor visitor3 = new Visitor("Ben", "Male", 22, 2003, true);
        Visitor visitor4 = new Visitor("David", "Male", 27, 2004, false);
        Visitor visitor5 = new Visitor("Jack", "Male", 35, 2005, true);

        ride2.addVisitorToHistory(visitor1);
        ride2.addVisitorToHistory(visitor2);
        ride2.addVisitorToHistory(visitor3);
        ride2.addVisitorToHistory(visitor4);
        ride2.addVisitorToHistory(visitor5);
    
        System.out.println("Visitors before sorting:");
        ride2.printRideHistory();
    
        VisitorComparator comparator = new VisitorComparator();
    
        ride2.sortRideHistory(comparator);
    
        System.out.println("Visitors after sorting:");
        ride2.printRideHistory();
    }

    public void partFive(){
        Employee rideOperator1 = new Employee("John", "Male", 30, "001", "Operator");
        Ride ride1 = new Ride("Roller Coaster", 2, rideOperator1);

        for (int i = 1; i <= 5; i++) {
            Visitor visitor = new Visitor("Visitor" + i, "Male", 25 + i, 1006 + i, true);
            ride1.addVisitorToQueue(visitor);
        }
    
        System.out.println("Visitors in the queue:");
        ride1.printQueue();
    
        ride1.RunOneCycle();
    
        System.out.println("Visitors in the queue after one cycle:");
        ride1.printQueue();
    
        System.out.println("Visitors in the ride history:");
        ride1.printRideHistory();
    }

    public void partSix(){
        Employee rideOperator1 = new Employee("John", "Male", 30, "001", "Operator");
        Ride ride1 = new Ride("Roller Coaster", 2, rideOperator1);
        
        Visitor visitor1 = new Visitor("Nehemia", "Female", 25, 1001, true);
        Visitor visitor2 = new Visitor("Jason", "Male", 30, 1002, false);
        Visitor visitor3 = new Visitor("Jack", "Male", 22, 1003, true);
        Visitor visitor4 = new Visitor("Sharon", "Female", 27, 1004, false);
        Visitor visitor5 = new Visitor("Benny", "Male", 35, 1005, true);
        Visitor visitor6 = new Visitor("Leo", "Male", 17, 1006, false);

        ride1.addVisitorToHistory(visitor1);
        ride1.addVisitorToHistory(visitor2);
        ride1.addVisitorToHistory(visitor3);
        ride1.addVisitorToHistory(visitor4);
        ride1.addVisitorToHistory(visitor5);
        ride1.addVisitorToHistory(visitor6);
        
        ride1.exportRideHistory("ride_history.txt");
    }

    public void partSeven(){
        Employee rideOperator1 = new Employee("John", "Male", 30, "001", "Operator");
        Ride ride1 = new Ride("Roller Coaster", 2, rideOperator1);

        ride1.importRideHistory("ride_history.txt");

        LinkedList<Visitor> rideHistory = ride1.getRideHistory(); 
        
        System.out.println("Number of Visitors in the LinkedList: " + ride1.getRideHistory().size());
        
        System.out.println("Visitors in the LinkedList:");
        
        for (Visitor visitor : ride1.getRideHistory()) {
            System.out.println(visitor);
        }
    }
}