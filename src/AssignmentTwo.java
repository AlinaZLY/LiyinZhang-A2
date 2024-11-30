public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
    }

    public void partThree(){
        Employee rideOperator1 = new Employee("John Doe", "Male", 30, "001", "Operator");
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
    }
    public void partFourB(){
    }
    public void partFive(){
    }
    public void partSix(){
    }
    public void partSeven(){
    }
    }