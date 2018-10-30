import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends JFrame {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,lq1,lq2,lqn1,lqn2,lsave,l12,ln,ldel,ladd,ldelmsg,laddmsg,lm1,lm2,lname;
    JLabel[] labels;
    JLabel lstudentscount,lshow1,lshow2,lscore;
    JTable t;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,bsave,blist,bs1,bs2,bs3,bs4,bshow,bveiw,bnext,bprev,bdel,badd,bsaveall;
    JTextField t1,t2,tqn1,tqn2,trollno,tn,tadd,tdel,trn,tq1,tq2,tname;
    public static int offset,start,stop,clicks=2;
    public static ArrayList<Student> students=  new ArrayList<>();
    public static int sum;
    public Main(String s){
        super(s);
    }
    public void setStudentComponents(){
        l3 = new JLabel("Enter Your Roll Number Here");
        t1 = new JTextField();
        b3 = new JButton("Press To See Score");
        l4 = new JLabel("");
        b9 = new JButton("Drop this Subject");
        l9 = new JLabel("[ Warning: Once Click on This you Dropped this subject PERMANENTLY ]");
        l10 = new JLabel();
        lshow1 = new JLabel();
        lshow2 = new JLabel();
        setLayout(null);
        t1.setBounds(325,100,250,30);
        l3.setBounds(350,-100,250,350);
        b3.setBounds(280,155,350,60);
        b9.setBounds(600,550,200,60);
        l9.setBounds(20,550,500,60);
        l10.setBounds(600,600,500,60);
        add(l3);
        add(t1);
        add(b3);
        b3.addActionListener(new showMarks());
        l4.setBounds(280,280,350,60);
        lshow1.setBounds(280,350,350,60);
        lshow2.setBounds(280,380,350,60);
        add(lshow1);
        add(lshow2);
        add(l4);
        add(l9);
        add(b9);
        b9.addActionListener(new dropCourse());
        add(l10);
    }
    public void setSummaryComponents(){
        b5 = new JButton("MEAN");
        b6 = new JButton("MEDIAN");
        b7 = new JButton("MIN");
        b8 = new JButton("MAX");
        l5 = new JLabel("");
        l6 = new JLabel("");
        l7 = new JLabel("");
        l8 = new JLabel("");
        lstudentscount = new JLabel("Total Students: "+students.size());
        setLayout(null);
        b5.setBounds(170,150,250,70);
        b6.setBounds(170,250,250,70);
        b7.setBounds(170,350,250,70);
        b8.setBounds(170,450,250,70);
        l5.setBounds(500,150,250,70);
        l6.setBounds(500,250,250,70);
        l7.setBounds(500,350,250,70);
        l8.setBounds(500,450,250,70);
        lstudentscount.setBounds(600,20,400,60);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(lstudentscount);
        b5.addActionListener(new showMean());
        b6.addActionListener(new showMedian());
        b7.addActionListener(new showMin());
        b8.addActionListener(new showMax());
        add(l5);
        add(l6);
        add(l7);
        add(l8);
    }
    public void setInstructorComponents(){
        l3 = new JLabel("Enter The Roll Number Here");
        t2 = new JTextField();
        b10 = new JButton("Score");
        l11 = new JLabel("");
        lq2 = new JLabel("");
        lq1 = new JLabel("");
        b11 = new JButton("Edit Marks");
        bdel = new JButton("Delete a Student");
        badd = new JButton("Add a Student");
        setLayout(null);
        l3.setBounds(350,-80,250,350);
        t2.setBounds(325,150,250,30);
        b10.setBounds(280,220,350,60);
        l11.setBounds(280,300,350,60);
        lq1.setBounds(280,350,350,60);
        lq2.setBounds(280,380,350,60);
        b11.setBounds(480,400,200,60);
        bdel.setBounds(50,550,250,40);
        badd.setBounds(580,550,250,40);
        badd.addActionListener(new MyHandler6());
        bdel.addActionListener(new MyHandler7());
        add(bdel);
        add(badd);
        add(l3);
        add(t2);
        add(b10);
        b10.addActionListener(new showMarkstoInstructor());
        add(l11);
        add(lq1);
        add(lq2);
    }
    public void setEditMarksComponents(){
        l12 = new JLabel("Specify the Roll Number: ");
        trollno = new JTextField();
        lqn1 = new JLabel("Enter new Q1 Marks : ");
        lqn2 = new JLabel("Enter new Q2 Marks : ");
        bsave = new JButton("Save");
        tqn1 = new JTextField();
        tqn2 = new JTextField();
        lsave = new JLabel();
        setLayout(null);
        l12.setBounds(120,50,250,100);
        trollno.setBounds(380,90,250,30);
        lqn1.setBounds(100,150,250,100);
        lqn2.setBounds(100,250,250,100);
        tqn1.setBounds(400,185,250,30);
        tqn2.setBounds(400,285,250,30);
        bsave.setBounds(330,450,250,60);
        lsave.setBounds(330,560,250,60);
        add(l12);
        add(trollno);
        add(lqn1);
        add(lqn2);
        add(tqn1);
        add(tqn2);
        add(bsave);
        bsave.addActionListener(new saveMarks());
        add(lsave);
    }
    public void setSortComponents(){
        bs1 = new JButton("Sort By RollNo.");
        bs2 = new JButton("Sort By Q1 Marks");
        bs3 = new JButton("Sort By Q2 Marks");
        bs4 = new JButton("Sort By Grand Total");
        bshow = new JButton("Show List");
        setLayout(null);
        bs1.setBounds(100,150,250,30);
        bs2.setBounds(100,250,250,30);
        bs3.setBounds(100,350,250,30);
        bs4.setBounds(100,450,250,30);
        bshow.setBounds(575,300,250,60);
        add(bs1);
        add(bs2);
        add(bs3);
        add(bs4);
        add(bshow);
        bs1.addActionListener(new RollNumSort());
        bs2.addActionListener(new Q1Sort());
        bs3.addActionListener(new Q2Sort());
        bs4.addActionListener(new GTSort());
        bshow.addActionListener(new MyHandler5());
    }
    public void setviewListComponents(){
        labels = new JLabel[50];
        labels[0] = new JLabel();
        labels[1] = new JLabel();
        labels[2] = new JLabel();
        labels[3] = new JLabel();
        labels[4] = new JLabel();
        labels[5] = new JLabel();
        labels[6] = new JLabel();
        labels[7] = new JLabel();
        labels[8] = new JLabel();
        labels[9] = new JLabel();
        labels[10] = new JLabel();
        labels[11] = new JLabel();
        labels[12] = new JLabel();
        labels[13] = new JLabel();
        labels[14] = new JLabel();

        ln = new JLabel("Enter the Size (MAX<12): ");
        tn = new JTextField();
        bveiw = new JButton("View");
        bnext = new JButton("Next->");
        bprev = new JButton("<-Prev");
        setLayout(null);
        ln.setBounds(100,50,300,50);
        tn.setBounds(300,60,400,30);
        bprev.setBounds(50,200,100,40);
        bnext.setBounds(700,200,100,40);
        bveiw.setBounds(220,150,300,40);
        labels[0].setBounds(200,270,600,30);
        labels[1].setBounds(200,300,600,30);
        labels[2].setBounds(200,330,600,30);
        labels[3].setBounds(200,360,600,30);
        labels[4].setBounds(200,390,600,30);
        labels[5].setBounds(200,420,600,30);
        labels[6].setBounds(200,450,600,30);
        labels[7].setBounds(200,480,600,30);
        labels[8].setBounds(200,510,600,30);
        labels[9].setBounds(200,540,600,30);
        labels[10].setBounds(200,570,600,30);
        labels[11].setBounds(200,600,600,30);
        labels[12].setBounds(200,630,600,30);
        labels[13].setBounds(200,660,600,30);
        labels[14].setBounds(200,690,600,30);
        add(ln);
        add(tn);
        add(bnext);
        add(bprev);
        add(bveiw);
        add(labels[0]);
        add(labels[1]);
        add(labels[2]);
        add(labels[3]);
        add(labels[4]);
        add(labels[5]);
        add(labels[6]);
        add(labels[7]);
        add(labels[8]);
        add(labels[9]);
        add(labels[10]);
        add(labels[11]);
        add(labels[12]);
        add(labels[13]);
        add(labels[14]);
        bveiw.addActionListener(new viewList());
        bnext.addActionListener((new viewNext()));
        bprev.addActionListener(new viewPrev());
    }
    public void setaddComponents(){
        ladd = new JLabel("Enter the Roll Number: ");
        lm1 = new JLabel("Enter Q1 Marks: ");
        lm2 = new JLabel("Enter Q2 Marks: ");
        badd = new JButton("Add This Student");
        trn = new JTextField();
        tq1 = new JTextField();
        tq2 = new JTextField();
        laddmsg = new JLabel();
        tadd = new JTextField();
        tname = new JTextField();
        lname = new JLabel("Enter The Name: ");
        setLayout(null);
        ladd.setBounds(200,150,250,40);
        lname.setBounds(200,200,250,40);
        lm1.setBounds(200,320,250,40);
        lm2.setBounds(200,370,250,40);
        trn.setBounds(450,150,250,30);
        tname.setBounds(450,205,205,30);
        tq1.setBounds(450,325,250,30);
        tq2.setBounds(450,375,250,30);
        badd.setBounds(300,500,250,50);
        laddmsg.setBounds(300,600,250,40);
        add(lname);
        add(tname);
        add(trn);
        add(tq1);
        add(tq2);
        add(ladd);
        add(lm1);
        add(lm2);
        add(badd);
        add(laddmsg);
        add(tadd);
        badd.addActionListener(new addStudent());
    }
    public void setdelComponents(){
        ldel = new JLabel("Enter the Roll Number: ");
        bdel = new JButton("Delete IT");
        tdel = new JTextField();
        ldelmsg = new JLabel();
        setLayout(null);
        ldel.setBounds(200,150,250,40);
        tdel.setBounds(300,250,250,40);
        bdel.setBounds(300,500,250,50);
        ldelmsg.setBounds(300,600,250,40);
        add(bdel);
        add(tdel);
        add(ldel);
        bdel.addActionListener(new deleteStudent());
        add(ldelmsg);
    }
    public void setComponents() {
        b1 = new JButton("Instructor");
        b2 = new JButton("Student");
        l1 = new JLabel("Welcome To Marks Portal");
        b4 = new JButton("Summary");
        bsaveall = new JButton("Save All Changes");
        blist = new JButton("View All Students");
        setLayout(null);
        l1.setFont(new Font(null,0, 20));
        l1.setBounds(320,50,400,350);
        b1.setBounds(250,330,180,100);
        b2.setBounds(450,330,180,100);
        b4.setBounds(330,500,250,60);
        bsaveall.setBounds(650,600,200,40);
        blist.setBounds(650,60,200,30);
        add(l1);
        add(b1);
        add(b2);
        add(b4);
        add(blist);
        blist.addActionListener(new MyHandler4());
        add(bsaveall);
        b1.addActionListener(new MyHandler());
        b2.addActionListener(new MyHandler1());
        b4.addActionListener(new MyHandler2());
        bsaveall.addActionListener(new writefile());
    }
    public class MyHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Main instructorFrame = new Main("Instructor Portal");
            instructorFrame.setInstructorComponents();
            instructorFrame.setSize(900,700);
            instructorFrame.setVisible(true);
            instructorFrame.setResizable(false);
            instructorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
    public class MyHandler1 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Main studentFrame = new Main("Student Portal");
            studentFrame.setStudentComponents();
            studentFrame.setSize(900,700);
            studentFrame.setVisible(true);
            studentFrame.setResizable(false);
            studentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
    public class MyHandler2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Main summaryFrame = new Main("Summary Portal");
            summaryFrame.setSummaryComponents();
            summaryFrame.setSize(900,700);
            summaryFrame.setVisible(true);
            summaryFrame.setResizable(false);
            summaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

    }
    public class MyHandler3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Main editMarksFrame = new Main("Edit Marks");
            editMarksFrame.setEditMarksComponents();
            editMarksFrame.setSize(900,700);
            editMarksFrame.setVisible(true);
            editMarksFrame.setResizable(false);
            editMarksFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

    }
    public class MyHandler4 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Main viewAllFrame = new Main("Student Portal");
            viewAllFrame.setSortComponents();
            viewAllFrame.setSize(900,700);
            viewAllFrame.setVisible(true);
            viewAllFrame.setResizable(false);
            viewAllFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
    public class MyHandler5 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Main showFrame = new Main("Instructor Portal");
            showFrame.setviewListComponents();
            showFrame.setSize(900,700);
            showFrame.setVisible(true);
            showFrame.setResizable(false);
            showFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
    public class MyHandler6 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Main addFrame = new Main("Instructor Portal");
            addFrame.setaddComponents();
            addFrame.setSize(900,700);
            addFrame.setVisible(true);
            addFrame.setResizable(false);
            addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
    public class MyHandler7 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Main delFrame = new Main("Instructor Portal");
            delFrame.setdelComponents();
            delFrame.setSize(900,700);
            delFrame.setVisible(true);
            delFrame.setResizable(false);
            delFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }
    public class writefile implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                FileWriter fw=new FileWriter("finalList.csv");
                for(int w=0;w<students.size();w++) {
                    String str = students.get(w).getStudentRollNo()+","+students.get(w).getStudentName()+","+students.get(w).getQ1()+","+students.get(w).getQ2()+","+students.get(w).getMarks();
                    for (int i = 0; i < str.length(); i++) {
                        fw.write(str.charAt(i));
                    }
                    fw.write("\n");
                }
                //close the file
                fw.close();
            } catch(IOException ie) {
                ie.printStackTrace();
            }
        }
    }
    public class addStudent implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int flag=0;
            for(int i=0;i<students.size();i++){
                if(students.get(i).getStudentRollNo().compareTo(trn.getText())==0){
                    flag=1;
                    laddmsg.setText("Already Existed!!");
                }
            }
            if(flag==0) {
                students.add(new Student(tname.getText(), trn.getText(), Integer.parseInt(tq1.getText()), Integer.parseInt(tq2.getText())));
                laddmsg.setText("Added Successfully.");
            }
        }
    }
    public class deleteStudent implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int flag=0;
            for(int i=0;i<students.size();i++){
                if(tdel.getText().toUpperCase().compareTo(students.get(i).getStudentRollNo())==0){
                    students.remove(i);
                    flag=1;
                    ldelmsg.setText("Deleted Successfully.");
                }
            }
            if(flag==0){
                ldelmsg.setText("Invalid Roll Number!!");
            }
        }
    }
    public class viewPrev implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(clicks>2) {
                offset = Integer.parseInt(tn.getText());
                start -= offset;
                stop -= offset;
                clicks -= 1;
                for (int i = start; i < stop; i++) {
                    labels[i % offset].setText(students.get(i).getStudentRollNo()+"    "+students.get(i).getStudentName() + "                       " + students.get(i).getMarksString());
                }
            }
        }
    }
    public class viewNext implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(clicks<(students.size()/Integer.parseInt(tn.getText()))) {
                offset = Integer.parseInt(tn.getText());
                start = (clicks - 1) * Integer.parseInt(tn.getText());
                stop = clicks * Integer.parseInt(tn.getText());
                clicks += 1;
                for (int i = start; i < stop; i++) {
                    labels[i % offset].setText(students.get(i).getStudentRollNo() + "    " + students.get(i).getStudentName() + "                       " + students.get(i).getMarksString());
                }
            }
        }
    }
    public class viewList implements ActionListener{
        public void actionPerformed(ActionEvent e){
            for(int i=0;i<Integer.parseInt(tn.getText());i++){
                lscore = new JLabel();
                labels[i].setText(students.get(i).getStudentRollNo() + "    " + students.get(i).getStudentName() + "                        " + students.get(i).getMarksString());
            }
        }
    }
    public class RollNumSort implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Collections.sort(students,new SortByRollNum());
        }
    }
    public class Q1Sort implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Collections.sort(students,new SortByQ1());

        }
    }
    public class Q2Sort implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Collections.sort(students,new SortByQ2());
        }
    }
    public class GTSort implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Collections.sort(students,new SortByGT());
        }
    }
    public class saveMarks implements ActionListener{
        public void actionPerformed(ActionEvent e){
            for(int i=0;i<students.size();i++){
                if(trollno.getText().compareTo(students.get(i).getStudentRollNo())==0){
                    students.get(i).setQ1Marks(Integer.parseInt(tqn1.getText()));
                    students.get(i).setQ2Marks(Integer.parseInt(tqn2.getText()));
                    lsave.setText("Saved Successfully.");
                }
            }
        }
    }
    public class showMarkstoInstructor implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int flag=0;
            for(int i=0;i<students.size();i++){
                if(t2.getText().toUpperCase().compareTo(students.get(i).getStudentRollNo())==0){
                    flag=1;
                    l11.setText("It is "+students.get(i).getStudentName()+" and Grand total : "+students.get(i).getMarks());
                    lq1.setText("Question 1 : "+students.get(i).getQ1Marks());
                    lq2.setText("Question 2 : "+students.get(i).getQ2Marks());
                    add(b11);
                    b11.addActionListener(new MyHandler3());
                }
            }
            if(flag==0){
                l11.setText("INVALID ROLL NUMBER");
            }
        }
    }
    public class showMarks implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int flag=0;
            for(int i=0;i<students.size();i++){
                if(t1.getText().toUpperCase().compareTo(students.get(i).getStudentRollNo())==0){
                    flag=1;
                    l4.setText("Hey! "+students.get(i).getStudentName()+" , "+"Your Grand Total is "+students.get(i).getMarks());
                    lshow1.setText("Marks in Q1: "+students.get(i).getQ1());
                    lshow2.setText("Marks in Q2: "+students.get(i).getQ2());
                }
            }
            if(flag==0){
                l4.setText("INVALID ROLL NUMBER");
            }
        }
    }

    public class showMean implements ActionListener{
        public void actionPerformed(ActionEvent e){
            sum=0;
            for(int i=1;i<students.size();i++){
                sum+=students.get(i).getMarks();
            }
            int div = students.size()-1;
            float mean = (float)sum/(float)div;
            l5.setText("The Mean is "+mean);
        }
    }

    public class dropCourse implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int flag=0;
            for(int i=0;i<students.size();i++){
                if(t1.getText().toUpperCase().compareTo(students.get(i).getStudentRollNo())==0){
                    flag=1;
                    l10.setText(students.get(i).getStudentName()+" is removed Successfully.");
                    students.remove(i);
                }
            }
            if(flag==0){
                l10.setText("ROLL NUMBER DOES NOT EXISTS");
            }
        }
    }

    public class showMedian implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Collections.sort(students,new SortByMarks());
            if(students.size()%2==0){
                int i = (students.size())/2;
                int j=i+1;
                int med = (students.get(i).getMarks()+students.get(j).getMarks())/2;
                l6.setText("The Medians is: "+med);
            }
            if(students.size()%2==1){
                int i = (students.size()+1)/2;
                l6.setText("The Median is: "+students.get(i).getMarks());
            }
        }
    }

    public class showMin implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int min = 1000;
            for(int i=1;i<students.size();i++){
                if(min>students.get(i).getMarks()){
                    min = students.get(i).getMarks();
                }
            }
            l7.setText("The Min Marks are "+min);
        }
    }

    public class showMax implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int max = 0;
            for(int i=1;i<students.size();i++){
                if(max<students.get(i).getMarks()){
                    max = students.get(i).getMarks();
                }
            }
            l8.setText("The Max Marks are "+max);
        }
    }

    public static void main(String[] args) {
        Main frame = new Main("Marks Portal");
        frame.setComponents();
        String fileName = "finalList.csv";
        File file = new File(fileName);
        try{
            Scanner inputStream = new Scanner(file);
            int i=0;
            while (inputStream.hasNextLine()){
                String stu = inputStream.nextLine();
                String[] values = stu.split(",");           // reading CSV file
                students.add(new Student(values[1],values[0]));
                Student student = students.get(i);
                student.setQ1Marks(Integer.parseInt(values[2]));
                student.setQ2Marks(Integer.parseInt(values[3]));
//                System.out.println(values[4]);
                i++;
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        frame.setSize(900,700);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
