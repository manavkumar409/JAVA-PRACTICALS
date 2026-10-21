
import java.util.ArrayList;

class Teacher {
    String name;

    Teacher(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Teacher: " + name);
    }
}

class Department {
    String name;
    ArrayList<Teacher> teachers = new ArrayList<>();

    Department(String name) {
        this.name = name;
    }

    void addTeacher(Teacher t) {
        teachers.add(t);
    }

    void display() {
        System.out.println("Department: " + name);

        for (Teacher t : teachers) {
            t.display();
        }
    }
}

class College {
    String name;
    ArrayList<Department> departments = new ArrayList<>();

    College(String name) {
        this.name = name;
    }

    void addDepartment(Department d) {
        departments.add(d);
    }

    void display() {
        System.out.println("College: " + name);

        for (Department d : departments) {
            d.display();
        }
    }
}

class Course {
    String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    void display() {
        System.out.println("Course: " + courseName);
    }
}

class Student {
    String name;
    ArrayList<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void addCourse(Course c) {
        courses.add(c);
    }

    void display() {
        System.out.println("Student: " + name);

        for (Course c : courses) {
            c.display();
        }
    }
}

class Library {
    String name;

    Library(String name) {
        this.name = name;
    }
}

class CollegeWithLibrary {
    String name;
    Library library;

    CollegeWithLibrary(String name) {
        this.name = name;
        library = new Library("College Library");
    }

    void display() {
        System.out.println("College: " + name);
        System.out.println("Library: " + library.name);
    }
}

public class Main {
    public static void main(String[] args) {

        Teacher t1 = new Teacher("Mr. Sharma");
        Teacher t2 = new Teacher("Ms. Verma");

        Department d1 = new Department("Computer Science");
        d1.addTeacher(t1);
        d1.addTeacher(t2);

        College c1 = new College("ABC College");
        c1.addDepartment(d1);

        System.out.println("Aggregation:");
        c1.display();

        System.out.println();

        Student s1 = new Student("Aditya");
        Course c2 = new Course("Java");
        Course c3 = new Course("DBMS");

        s1.addCourse(c2);
        s1.addCourse(c3);

        System.out.println("Association:");
        s1.display();

        System.out.println();

        CollegeWithLibrary c4 =
                new CollegeWithLibrary("XYZ College");

        System.out.println("Composition:");
        c4.display();
    }
}

