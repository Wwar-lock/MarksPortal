import java.util.Comparator;

public class SortByGT implements Comparator<Student> {
    public int compare(Student a,Student b){
        return b.getMarksString().compareTo(a.getMarksString());
    }
}
