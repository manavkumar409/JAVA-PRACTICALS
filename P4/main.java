
abstract class Employee {
    protected String name;
    protected int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double calculateSalary();

    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: " + calculateSalary());
    }
}

interface Payable {
    void pay();
}

interface Printable {
    void print();
}

class FullTimeEmployee extends Employee
        implements Payable, Printable {

    double basicSalary;

    FullTimeEmployee(String name, int id, double basicSalary) {
        super(name, id);
        this.basicSalary = basicSalary;
    }

    @Override
    double calculateSalary() {
        return basicSalary + 5000;
    }

    @Override
    public void pay() {
        System.out.println("Full-time employee salary paid.");
    }

    @Override
    public void print() {
        display();
    }
}

class PartTimeEmployee extends Employee
        implements Payable, Printable {

    int hours;
    double rate;

    PartTimeEmployee(String name, int id, int hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double calculateSalary() {
        return hours * rate;
    }

    @Override
    public void pay() {
        System.out.println("Part-time employee salary paid.");
    }

    @Override
    public void print() {
        display();
    }
}

public class Main {
    public static void main(String[] args) {
        FullTimeEmployee e1 =
                new FullTimeEmployee("Aditya", 101, 30000);

        PartTimeEmployee e2 =
                new PartTimeEmployee("Rohit", 102, 80, 200);

        System.out.println("Full-Time Employee:");
        e1.print();
        e1.pay();

        System.out.println();

        System.out.println("Part-Time Employee:");
        e2.print();
        e2.pay();
    }
}

