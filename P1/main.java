
class Student {
    
    private int rollNo;
    private String name;
    private double marks;

    
    Student() {
        rollNo = 0;
        name = "";
        marks = 0.0;
    }


    Student(int r, String n, double m) {
        setRollNo(r);
        setName(n);
        setMarks(m);
    }

   
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int r) {
        if (r >= 1 && r <= 20)
            rollNo = r;
        else
            System.out.println("Invalid roll number");
    }

    
    public String getName() {
        return name;
    }

    public void setName(String n) {
        if (n != null && !n.trim().isEmpty())
            name = n;
        else
            System.out.println("Invalid name");
    }

    
    public double getMarks() {
        return marks;
    }

    public void setMarks(double m) {
        if (m >= 0 && m <= 30)
            marks = m;
        else
            System.out.println("Invalid marks");
    }

    
    public void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks + "/30");
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        
        Student s1 = new Student();

        
        Student s2 = new Student(5, "Aditya", 18);
        Student s3 = new Student(12, "Rohit", 24);
        Student s4 = new Student(19, "Manav", 29);

        System.out.println("Default Constructor:");
        s1.display();

        System.out.println("Student Details:");
        s2.display();
        s3.display();
        s4.display();

       
        s2.setMarks(20);

        System.out.println("Updated Details:");
        s2.display();

        
        s3.setMarks(35);
        s4.setRollNo(25);

        
        System.out.println("Student Name: " + s4.getName());
        System.out.println("Student Marks: " + s4.getMarks());
    }
}
