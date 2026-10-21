
class Person {
    protected String name;
    protected int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    private int rollNo;
    private double marks;

    Student(String name, int age, int rollNo, double marks) {
        super(name, age);
        this.rollNo = rollNo;
        this.marks = marks;
    }

    void displayStudent() {
        super.displayPerson();
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks + "/30");
    }
}

class Faculty extends Person {
    protected String subject;

    Faculty(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayFaculty() {
        super.displayPerson();
        System.out.println("Subject: " + subject);
    }
}

class Professor extends Faculty {
    private double salary;

    Professor(String name, int age, String subject, double salary) {
        super(name, age, subject);
        this.salary = salary;
    }

    void displayProfessor() {
        super.displayFaculty();
        System.out.println("Salary: " + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("Aditya", 20, 5, 18);

        System.out.println("Student Details:");
        s.displayStudent();

        System.out.println();

        Faculty f = new Faculty("Rohit", 40, "Java");

        System.out.println("Faculty Details:");
        f.displayFaculty();

        System.out.println();

        Professor p = new Professor("Manav", 45,
                                    "Computer Science", 60000);

        System.out.println("Professor Details:");
        p.displayProfessor();
    }
}
