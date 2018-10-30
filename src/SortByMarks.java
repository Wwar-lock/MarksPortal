import java.util.Comparator;

public class SortByMarks implements Comparator<Student> {
    public int compare(Student a,Student b){
        return a.getMarksString().compareTo(b.getMarksString());
    }
}
