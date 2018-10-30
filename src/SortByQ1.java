import java.util.Comparator;

public class SortByQ1 implements Comparator<Student> {
    public int compare(Student a,Student b){
        return b.getQ1().compareTo(a.getQ1());
    }
}
