import java.util.Comparator;

public class SortByQ2 implements Comparator<Student> {
    public int compare(Student a,Student b){
        return b.getQ2().compareTo(a.getQ2());
    }
}
