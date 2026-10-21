
class Shape {
    void area() {
        System.out.println("Area of shape");
    }

    void area(int side) {
        System.out.println("Area of square: " + (side * side));
    }

    void area(int length, int breadth) {
        System.out.println("Area of rectangle: " + (length * breadth));
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void area() {
        System.out.println("Area of circle: " +
                           (3.14 * radius * radius));
    }
}

class Rectangle extends Shape {
    int length, breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    void area() {
        System.out.println("Area of rectangle: " +
                           (length * breadth));
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s = new Shape();

        s.area();
        s.area(5);
        s.area(4, 6);

        System.out.println();

        Shape sh;

        sh = new Circle(7);
        sh.area();

        sh = new Rectangle(4, 6);
        sh.area();
    }
}
