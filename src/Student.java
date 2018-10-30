public class Student {
    private String studentName;
    private String StudentRollNo;
    private int q1Marks;private int q2Marks;
    private int marks;
    private String marksString,q1String,q2String;

    public int getQ1Marks() {
        return q1Marks;
    }

    public int getQ2Marks() {
        return q2Marks;
    }

    public Student(String studentName, String studentRollNo, int q1Marks, int q2Marks) {
        this.studentName = studentName;
        StudentRollNo = studentRollNo;
        this.q1Marks = q1Marks;
        this.q2Marks = q2Marks;
    }

    public String getQ1(){
        q1String = String.valueOf(q1Marks);
        return q1String;
    }

    public String getQ2(){
        q2String = String.valueOf(q2Marks);
        return q2String;
    }

    public String getMarksString() {
        marksString = String.valueOf(this.getMarks());
        return marksString;
    }

    public void setQ1Marks(int q1Marks) {
        this.q1Marks = q1Marks;
    }

    public void setQ2Marks(int q2Marks) {
        this.q2Marks = q2Marks;
    }

    public int getMarks() {
        marks = q1Marks + q2Marks;
        return marks;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentRollNo() {
        return StudentRollNo;
    }

    public Student(String studentName, String studentRollNo) {
        this.studentName = studentName;
        StudentRollNo = studentRollNo;
    }
}
