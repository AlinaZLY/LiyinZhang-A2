import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {

    public int compare(Visitor v1, Visitor v2) {
        // Compare visitors based on age and then name
        if (v1.getAge() != v2.getAge()) {
            return v1.getAge() - v2.getAge();
        } else {
            return v1.getName().compareTo(v2.getName());
        }
    }
}