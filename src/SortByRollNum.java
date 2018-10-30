import java.util.Comparator;

public class SortByRollNum implements Comparator<Student> {
    public int compare(Student a,Student b){
        return a.getStudentRollNo().compareTo(b.getStudentRollNo());
    }
}
