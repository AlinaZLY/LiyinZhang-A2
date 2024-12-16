public class Visitor extends Person {
    private int visitorId;
    private boolean member;

    public Visitor() {

    }

    public Visitor(String name, String gender, int age, int visitorId, boolean member) {
        super(name, gender, age);
        this.visitorId = visitorId;
        this.member = member;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public String toString() {
        return name + "," + gender + "," + age + "," + visitorId + "," + m;
    }
}