public class Employee extends Person {
    private String employeeId;
    private String job;

    public Employee() {

    }

    public Employee(String name, String gender, int age, String employeeId, String job) {
        super(name, gender, age);
        this.employeeId = employeeId;
        this.job = job;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}